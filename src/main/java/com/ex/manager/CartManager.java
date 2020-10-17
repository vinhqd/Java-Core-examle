package com.ex.manager;

import com.ex.constant.SystemConstant;
import com.ex.data.CreateData;
import com.ex.model.CartModel;
import com.ex.model.ProductModel;
import com.ex.service.ICartService;
import com.ex.service.IProductService;
import com.ex.service.impl.CartService;
import com.ex.service.impl.ProductService;
import com.ex.utils.ScannerUtil;

import java.util.List;
import java.util.Scanner;

public class CartManager {
    private ICartService cartService;
    private IProductService productService;

    public CartManager() {
        if (cartService == null) cartService = new CartService();
        if (productService == null) productService = new ProductService();
    }

    public void addToCart() {
        Scanner s = new Scanner(System.in);
        ScannerUtil su = new ScannerUtil();
        long productId;
        ProductModel productModel;
        while (true) {
            productId = su.checkInteger(s, "Nhập id sản phẩm muốn thêm vào giỏ hàng: ",
                    SystemConstant.ERROR_MESSAGE);
            productModel = productService.findOne(productId);
            if (productModel != null) {
                break;
            } else {
                System.out.println("Id sản phẩm không tồn tại!");
            }
        }
        cartService.addToCart(CreateData.userModel.getId(), productModel);
        System.out.println("Thêm vào giỏ hàng thành công.");
    }

    public void showCart() {
        CartModel cartModel = cartService.findOne(CreateData.userModel.getId());
        if (cartModel != null) {
            for (ProductModel productModel : cartModel.getProductModels()) {
                System.out.println(productModel.toString());
            }
        }
    }

    public void deleteProductPromCart() {
        Scanner s = new Scanner(System.in);
        ScannerUtil su = new ScannerUtil();
        long productId;
        ProductModel productModel = null;
        if (cartService.findOne(CreateData.userModel.getId()) != null) {
        List<ProductModel> productModels = cartService.findOne(CreateData.userModel.getId()).getProductModels();
            while (true) {
                productId = su.checkInteger(s, "Nhập id sản phẩm muốn xoá khỏi giỏ hàng: ",
                        SystemConstant.ERROR_MESSAGE);
                for (ProductModel productModel1 : productModels) {
                    if (productModel1.getId().equals(productId)) {
                        productModel = productModel1;
                        break;
                    }
                }
                if (productModel != null) {
                    break;
                } else {
                    System.out.println("Sản phẩm không tồn tại trong giỏ hàng!");
                }
            }
        }
        if (cartService.removeProductFromCart(CreateData.userModel.getId(), productModel) != null) {
            System.out.println("Xoá sản phẩm khỏi giỏ hàng thành công.");
        } else
            System.out.println("Giỏ hàng trống.");
    }
}
