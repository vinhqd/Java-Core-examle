package com.ex.view;

import com.ex.constant.SystemConstant;
import com.ex.data.CreateData;
import com.ex.manager.CategoryManager;
import com.ex.manager.OrderManager;
import com.ex.manager.ProductManager;
import com.ex.manager.UserManager;
import com.ex.utils.ScannerUtil;

import java.util.Scanner;

public class AdminView {
    private Scanner s = new Scanner(System.in);

    public void showAdminView() {
        ScannerUtil su = new ScannerUtil();
        boolean isHas = true;
        while (isHas) {
            MenuView.adminView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    showUserManagerView();
                    break;
                case 2:
                    showProductManagerView();
                    break;
                case 3:
                    showOrderManagerView();
                    break;
                case 0:
                    CreateData.userModel = null;
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 3)!");
            }
        }
    }

    private void showOrderManagerView() {
        ScannerUtil su = new ScannerUtil();
        OrderManager orderManager = new OrderManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.orderManagerView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    orderManager.showAllOrder();
                    break;
                case 2:
                    if (orderManager.showAllOrderUnconfirmed() > 0) {
                        showSubOrderManagerView("Xác nhận đơn hàng", 1);
                    }
                    break;
                case 3:
                    if (orderManager.showAllOrderConfirmed() > 0) {
                        showSubOrderManagerView("Xác nhận giao hàng thành công", -1);
                    }
                    break;
                case 4:
                    orderManager.showAllOrderDone();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 4)!");
            }
        }
    }

    private void showSubOrderManagerView(String message, int status) {
        ScannerUtil su = new ScannerUtil();
        OrderManager orderManager = new OrderManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.subOrderManagerView(message);
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    orderManager.confirmOrder(message, status);
                    isHas = false;
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 1)!");
            }
        }
    }

    private void showUserManagerView() {
        ScannerUtil su = new ScannerUtil();
        UserManager userManager = new UserManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.userManagerView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    userManager.showUsers();
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    userManager.deleteUser();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 4)!");
            }
        }
    }

    private void showProductManagerView() {
        ScannerUtil su = new ScannerUtil();
        CategoryManager categoryManager = new CategoryManager();
        ProductManager productManager = new ProductManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.productManagerView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice) {
                case 1:
                    productManager.showProduct();
                    break;
                case 2:
                    categoryManager.showCategory();
                    break;
                case 3:
                    productManager.insertProduct();
                    break;
                case 4:
                    categoryManager.insertCategory();
                    break;
                case 5:
                    productManager.updateProduct();
                    break;
                case 6:
                    categoryManager.updateCategory();
                    break;
                case 7:
                    showSearchView();
                    break;
                case 8:
                    showSortView();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 8)!");
            }
        }
    }

    private void showSearchView() {
        ScannerUtil su = new ScannerUtil();
        ProductManager productManager = new ProductManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.productManagerSearchView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    productManager.searchProductByName();
                    break;
                case 2:
                    productManager.searchProductByBiggerPrice();
                    break;
                case 3:
                    productManager.searchProductByLesserPrice();
                    break;
                case 4:
                    productManager.searchProductByCategory();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 4)!");
            }
        }
    }

    private void showSortView() {
        ScannerUtil su = new ScannerUtil();
        ProductManager productManager = new ProductManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.productManagerSortView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    productManager.sortProductByNameASC();
                    break;
                case 2:
                    productManager.sortProductByNameDESC();
                    break;
                case 3:
                    productManager.sortProductByPriceASC();
                    break;
                case 4:
                    productManager.sortProductByPriceDESC();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 4)!");
            }
        }
    }
}
