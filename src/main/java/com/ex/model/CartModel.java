package com.ex.model;

import java.util.LinkedList;
import java.util.List;

public class CartModel extends AbstractModel {
    private Long userId;
    private UserModel userModel;
    private List<ProductModel> productModels = new LinkedList<>();

    public CartModel() {
    }

    public CartModel(List<ProductModel> productModels) {
        this.productModels = productModels;
    }

    public List<ProductModel> getProductModels() {
        return productModels;
    }

    public void setProductModels(List<ProductModel> productModels) {
        this.productModels = productModels;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
