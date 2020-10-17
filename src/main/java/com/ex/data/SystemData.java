package com.ex.data;

import com.ex.dao.ICategoryDAO;
import com.ex.dao.IRoleDAO;
import com.ex.dao.impl.CategoryDAO;
import com.ex.dao.impl.RoleDAO;
import com.ex.model.*;
import com.ex.utils.IdUtil;

import java.util.ArrayList;
import java.util.List;

public class SystemData {

    public static List<RoleModel> roleData() {
        AbstractModel.currentId = IdUtil.checkId(CreateData.roleModels);
        List<RoleModel> roleModels = new ArrayList<>();
        roleModels.add(new RoleModel("Người dùng", "USER"));
        roleModels.add(new RoleModel("Quản trị viên", "ADMIN"));
        return roleModels;
    }

    public static List<UserModel> userData() {
        AbstractModel.currentId = IdUtil.checkId(CreateData.userModels);
        List<UserModel> userModels = new ArrayList<>();
        IRoleDAO roleDAO = new RoleDAO();
        UserModel userModel = new UserModel();
        userModel.setUserName("admin");
        userModel.setPassword("123456");
        userModel.setFullName("Nguyen Van A");
        userModel.setStatus(1);
        userModel.setRoleId(2L);
        userModel.setRoleModel(roleDAO.findOne(userModel.getRoleId()));
        UserModel userModel1 = new UserModel();
        userModel1.setUserName("vinhqd");
        userModel1.setPassword("123456");
        userModel1.setFullName("Ha Ha Ha Hi Hi Hi");
        userModel1.setStatus(1);
        userModel1.setRoleId(1L);
        userModel1.setRoleModel(roleDAO.findOne(userModel1.getRoleId()));
        userModels.add(userModel);
        userModels.add(userModel1);
        return userModels;
    }

    public static List<CategoryModel> categoryData() {
        AbstractModel.currentId = IdUtil.checkId(CreateData.categoryModels);
        List<CategoryModel> categoryModels = new ArrayList<>();
        categoryModels.add(new CategoryModel("Điện thoại"));
        categoryModels.add(new CategoryModel("Phụ kiện điện thoại"));
        categoryModels.add(new CategoryModel("Laptop"));
        categoryModels.add(new CategoryModel("Phụ kiện laptop"));
        return categoryModels;
    }

    public static List<ProductModel> productData() {
        AbstractModel.currentId = IdUtil.checkId(CreateData.productModels);
        ICategoryDAO categoryDAO = new CategoryDAO();
        List<ProductModel> productModels = new ArrayList<>();
        productModels.add(new ProductModel("Iphone 15", 5000, 1));
        productModels.add(new ProductModel("Samsung S10", 1000, 1));
        productModels.add(new ProductModel("Tai nghe", 100, 2));
        productModels.add(new ProductModel("Sạc", 10, 2));
        productModels.add(new ProductModel("MacBook Supper pro", 9999, 3));
        productModels.add(new ProductModel("Dell", 7777, 3));
        productModels.add(new ProductModel("Lenovo", 8888, 3));
        productModels.add(new ProductModel("HP", 5555, 3));
        productModels.add(new ProductModel("Chuột bluetooth", 100, 4));
        productModels.add(new ProductModel("Bàn phím bluetooth", 50, 4));
        for(ProductModel productModel: productModels) {
            productModel.setCategoryModel(categoryDAO.findOne(productModel.getCategoryId()));
        }
        return productModels;
    }
}
