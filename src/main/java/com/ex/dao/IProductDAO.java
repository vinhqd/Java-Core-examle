package com.ex.dao;

import com.ex.model.CategoryModel;
import com.ex.model.ProductModel;

import java.util.List;

public interface IProductDAO {
    List<ProductModel> findAll();

    ProductModel findOne(long id);

    List<ProductModel> findByName(String name);

    List<ProductModel> findByPrice(double price, String choose);

    List<ProductModel> findByCategory(long categoryId);

    ProductModel insert(ProductModel productModel);

    ProductModel update(int index, ProductModel productModel);

}
