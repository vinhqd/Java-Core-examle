package com.ex.manager;

import com.ex.constant.SystemConstant;
import com.ex.data.CreateData;
import com.ex.model.AbstractModel;
import com.ex.model.CartModel;
import com.ex.model.OrderModel;
import com.ex.model.ProductModel;
import com.ex.service.ICartService;
import com.ex.service.IOrderService;
import com.ex.service.impl.CartService;
import com.ex.service.impl.OrderService;
import com.ex.utils.IdUtil;
import com.ex.utils.ScannerUtil;

import java.util.List;
import java.util.Scanner;

public class OrderManager {
    private IOrderService orderService;
    private ICartService cartService;

    public OrderManager() {
        if (orderService == null) orderService = new OrderService();
        if (cartService == null) cartService = new CartService();
    }

    public double showCart() {
        CartModel cartModel = cartService.findOne(CreateData.userModel.getId());
        double price = 0;
        if (cartModel != null) {
            for (ProductModel value : cartModel.getProductModels()) {
                System.out.println(value.toString());
                price += value.getPrice();
            }
            System.out.println("Giá tiền: " + price);
        } else
            System.out.println("Gio hang trong.");
        return price;
    }

    public void showOrder() {
        List<OrderModel> orderModels = orderService.findByUser(CreateData.userModel.getId());
        if (orderModels.size() > 0) {
            for (OrderModel orderModel : orderModels) {
                System.out.println(orderModel.getProductModels().toString());
                System.out.println("Gia tien don hang: " + orderModel.getTotalPrice());
                System.out.println("Dia chi: " + orderModel.getAddress());
                if (orderModel.getStatus() == 0) {
                    System.out.println("Đơn hàng đang chờ xác nhận.");
                } else if (orderModel.getStatus() == 1) {
                    System.out.println("Đang chuyển hàng.");
                } else if (orderModel.getStatus() == -1) {
                    System.out.println("Nhận hàng thành công.");
                }
                System.out.println("");
            }
        } else {
            System.out.println("Khong co don hang nao.");
        }
    }

    public void showAllOrder() {
        List<OrderModel> orderModels = orderService.findAll();
        if (orderModels.size() > 0) {
            for (OrderModel orderModel : orderModels) {
                System.out.println("Id: " + orderModel.getId());
                System.out.println(orderModel.getProductModels().toString());
                System.out.println("Gia tien don hang: " + orderModel.getTotalPrice());
                System.out.println("Dia chi: " + orderModel.getAddress());
                if (orderModel.getStatus() == 0) {
                    System.out.println("Đơn hàng đang chờ xác nhận.");
                } else if (orderModel.getStatus() == 1) {
                    System.out.println("Đang chuyển hàng.");
                } else if (orderModel.getStatus() == -1) {
                    System.out.println("Đã giao hàng xong.");
                }
                System.out.println("");
            }
        } else {
            System.out.println("Không có đơn hàng nào.");
        }
    }

    public int showAllOrderUnconfirmed() {
        List<OrderModel> orderModels = orderService.findByStatus(0);
        if (orderModels.size() > 0) {
            for (OrderModel orderModel : orderModels) {
                System.out.println("Id: " + orderModel.getId());
                System.out.println(orderModel.getProductModels().toString());
                System.out.println("Gia tien don hang: " + orderModel.getTotalPrice());
                System.out.println("Dia chi: " + orderModel.getAddress());
                System.out.println("Đơn hàng đang chờ xác nhận.");
                System.out.println("");
            }
        } else {
            System.out.println("Không có đơn hàng nào.");
        }
        return orderModels.size();
    }

    public int showAllOrderConfirmed() {
        List<OrderModel> orderModels = orderService.findByStatus(1);
        if (orderModels.size() > 0) {
            for (OrderModel orderModel : orderModels) {
                System.out.println("Id: " + orderModel.getId());
                System.out.println(orderModel.getProductModels().toString());
                System.out.println("Gia tien don hang: " + orderModel.getTotalPrice());
                System.out.println("Dia chi: " + orderModel.getAddress());
                System.out.println("Đang chuyển hàng.");
                System.out.println("");
            }
        } else {
            System.out.println("Không có đơn hàng nào.");
        }
        return orderModels.size();
    }

    public void showAllOrderDone() {
        List<OrderModel> orderModels = orderService.findByStatus(-1);
        if (orderModels.size() > 0) {
            for (OrderModel orderModel : orderModels) {
                System.out.println("Id: " + orderModel.getId());
                System.out.println(orderModel.getProductModels().toString());
                System.out.println("Gia tien don hang: " + orderModel.getTotalPrice());
                System.out.println("Dia chi: " + orderModel.getAddress());
                System.out.println("Giao hàng thành công.");
            }
            System.out.println("");
        } else {
            System.out.println("Không có đơn hàng nào.");
        }
    }

    public boolean addOrder() {
        Scanner s = new Scanner(System.in);
        String choice;
        while (true) {
            System.out.println("Bạn có muốn đặt hàng? (Y/n):");
            choice = s.nextLine();
            if (choice.toLowerCase().equals("y")) {
                System.out.println("Nhap dia chi giao hang: ");
                String address = s.nextLine();
                CartModel cartModel = cartService.findOne(CreateData.userModel.getId());
                AbstractModel.currentId = IdUtil.checkId(orderService.findAll());
                OrderModel orderModel = new OrderModel();
                orderModel.setUserId(cartModel.getUserId());
                orderModel.setUserModel(cartModel.getUserModel());
                orderModel.setProductModels(cartModel.getProductModels());
                orderModel.setTotalPrice(showCart());
                orderModel.setAddress(address);
                orderModel.setStatus(0);
                orderService.insert(orderModel);
                cartService.removeCart(CreateData.userModel.getId());
                System.out.println("Đặt hàng thành công!");
                return true;
            } else if (choice.toLowerCase().equals("n")) {
                System.out.println("Không đặt hàng");
                return true;
            } else {
                System.out.println("Không hợp lệ nhập lại.");
            }
        }
    }

    public void confirmOrder(String message, int status) {
        Scanner s = new Scanner(System.in);
        ScannerUtil su = new ScannerUtil();
        String choice;
        long orderId = su.checkInteger(s, "Nhập id đơn hàng: ", SystemConstant.ERROR_MESSAGE);
        OrderModel orderModel = orderService.findOne(orderId);
        if (orderModel == null) {
            System.out.println("Id đơn hàng không tồn tại.");
            return;
        }
        System.out.println(orderModel.getProductModels().toString());
        System.out.println("Giá: " + orderModel.getTotalPrice());
        System.out.println("");
        while (true) {
            System.out.println("Bạn có muốn " + message + "? (Y/n):");
            choice = s.nextLine();
            if (choice.toLowerCase().equals("y")) {
                orderModel.setStatus(status);
                orderService.update(orderModel);
                System.out.println(message + " thành công!");
                return;
            } else if (choice.toLowerCase().equals("n")) {
                System.out.println("Không " + message + ".");
                return;
            } else {
                System.out.println("Không hợp lệ nhập lại.");
            }
        }
    }
}
