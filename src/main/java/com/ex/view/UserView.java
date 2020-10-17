package com.ex.view;

import com.ex.constant.SystemConstant;
import com.ex.data.CreateData;
import com.ex.manager.CartManager;
import com.ex.manager.OrderManager;
import com.ex.manager.ProductManager;
import com.ex.utils.ScannerUtil;

import java.util.Scanner;

public class UserView {
    private Scanner s = new Scanner(System.in);

    public void showUserView() {
        ScannerUtil su = new ScannerUtil();
        boolean isHas = true;
        while (isHas) {
            MenuView.userView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    showProductMenu();
                    break;
                case 2:
                    showSearchMenu();
                    break;
                case 3:
                    showCartMenu();
                    break;
                case 4:
                    showOrderMenu();
                    break;
                case 0:
                    CreateData.userModel = null;
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 4)!");
            }
        }
    }

    private void showSearchMenu() {
        ScannerUtil su = new ScannerUtil();
        ProductManager productManager = new ProductManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.userSearchView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    productManager.searchProductByName();
                    addToCart();
                    break;
                case 2:
                    productManager.searchProductByBiggerPrice();
                    addToCart();
                    break;
                case 3:
                    productManager.searchProductByLesserPrice();
                    addToCart();
                    break;
                case 4:
                    productManager.searchProductByCategory();
                    addToCart();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 4)!");
            }
        }
    }

    private void showOrderMenu() {
        ScannerUtil su = new ScannerUtil();
        OrderManager orderManager = new OrderManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.userOrderView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    if (orderManager.showCart() > 0) {
                        addToOrder();
                    } else {
                        System.out.println("Khong co don hang nao.0");
                    }
                    break;
                case 2:
                    orderManager.showOrder();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 2)!");
            }
        }
    }

    private void showProductMenu() {
        ScannerUtil su = new ScannerUtil();
        ProductManager productManager = new ProductManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.userProductsView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    productManager.showProduct();
                    addToCart();
                    break;
                case 2:
                    productManager.sortProductByNameASC();
                    addToCart();
                    break;
                case 3:
                    productManager.sortProductByNameDESC();
                    addToCart();
                    break;
                case 4:
                    productManager.sortProductByPriceASC();
                    addToCart();
                    break;
                case 5:
                    productManager.sortProductByPriceDESC();
                    addToCart();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 5)!");
            }
        }
    }

    private void showCartMenu() {
        ScannerUtil su = new ScannerUtil();
        CartManager cartManager = new CartManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.userCartView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    cartManager.showCart();
                    break;
                case 2:
                    cartManager.deleteProductPromCart();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 2)!");
            }
        }
    }

    private void addToCart() {
        ScannerUtil su = new ScannerUtil();
        CartManager cartManager = new CartManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.addToCartView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    cartManager.addToCart();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 1)!");
            }
        }
    }

    private void addToOrder() {
        ScannerUtil su = new ScannerUtil();
        OrderManager orderManager = new OrderManager();
        boolean isHas = true;
        while (isHas) {
            MenuView.addToOrderView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    isHas = !orderManager.addOrder();
                    break;
                case 0:
                    isHas = false;
                    break;
                default:
                    System.out.println("Vui lòng nhập (0 - 1)!");
            }
        }
    }
}
