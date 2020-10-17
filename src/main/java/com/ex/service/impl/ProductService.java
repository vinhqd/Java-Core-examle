package com.ex.service.impl;

import com.ex.dao.ICategoryDAO;
import com.ex.dao.IProductDAO;
import com.ex.dao.impl.CategoryDAO;
import com.ex.dao.impl.ProductDAO;
import com.ex.model.ProductModel;
import com.ex.service.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private IProductDAO productDAO;
    private ICategoryDAO categoryDAO;

    public ProductService() {
        if (productDAO == null) productDAO = new ProductDAO();
        if (categoryDAO == null) categoryDAO = new CategoryDAO();
    }

    @Override
    public List<ProductModel> findAll() {
        return productDAO.findAll();
    }

    @Override
    public List<ProductModel> findByName(String name) {
        return productDAO.findByName(name);
    }

    @Override
    public List<ProductModel> findByPrice(double price, String choose) {
        return productDAO.findByPrice(price, choose);
    }

    @Override
    public List<ProductModel> findByCategory(long categoryId) {
        return productDAO.findByCategory(categoryId);
    }

    @Override
    public ProductModel insert(ProductModel productModel) {
        productModel.setCategoryModel(categoryDAO.findOne(productModel.getCategoryId()));
        return productDAO.insert(productModel);
    }

    @Override
    public ProductModel findOne(long id) {
        return productDAO.findOne(id);
    }

    @Override
    public ProductModel update(int index, ProductModel productModel) {
        return productDAO.update(index, productModel);
    }
}
