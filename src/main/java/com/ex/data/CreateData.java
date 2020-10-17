package com.ex.data;

import com.ex.model.*;

import java.util.ArrayList;
import java.util.List;

public class CreateData {
    public static List<RoleModel> roleModels = new ArrayList<>();
    public static List<UserModel> userModels = new ArrayList<>();
    public static List<CategoryModel> categoryModels = new ArrayList<>();
    public static List<ProductModel> productModels = new ArrayList<>();
    public static List<CartModel> cartModels = new ArrayList<>();
    public static List<OrderModel> orderModels = new ArrayList<>();
    public static UserModel userModel;

    private static CreateData createData;

    private CreateData() {}

    public static CreateData getInstance() {
        if (createData == null) createData = new CreateData();
        return createData;
    }

    public void initData() {
        roleModels = SystemData.roleData();
        userModels = SystemData.userData();
        categoryModels = SystemData.categoryData();
        productModels = SystemData.productData();
    }
}
