package com.ex.dao.impl;

import com.ex.constant.SystemConstant;
import com.ex.dao.IProductDAO;
import com.ex.data.CreateData;
import com.ex.model.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO<ProductModel> implements IProductDAO {
    @Override
    public List<ProductModel> findAll() {
        return CreateData.productModels;
    }

    @Override
    public List<ProductModel> findByName(String name) {
        List<ProductModel> productModels = findAll();
        List<ProductModel> newList = new ArrayList<>();
        for(ProductModel productModel: productModels) {
            if (productModel.getName().toLowerCase().contains(name.toLowerCase())) {
                newList.add(productModel);
            }
        }
        return newList;
    }

    @Override
    public List<ProductModel> findByPrice(double price, String choose) {
        List<ProductModel> productModels = findAll();
        List<ProductModel> newList = new ArrayList<>();
        for(ProductModel productModel: productModels) {
            if (choose.equals(SystemConstant.BIGGER_PRICE)) {
                if (productModel.getPrice() >= price) {
                    newList.add(productModel);
                }
            } else if (choose.equals(SystemConstant.LESSER_PRICE)) {
                if (productModel.getPrice() <= price) {
                    newList.add(productModel);
                }
            }
        }
        return newList;
    }

    @Override
    public List<ProductModel> findByCategory(long categoryId) {
        List<ProductModel> productModels = findAll();
        List<ProductModel> newList = new ArrayList<>();
        for(ProductModel productModel: productModels) {
            if (productModel.getCategoryId() == categoryId) {
                newList.add(productModel);
            }
        }
        return newList;
    }

    @Override
    public ProductModel insert(ProductModel productModel) {
        return insert(findAll(), productModel);
    }

    @Override
    public ProductModel findOne(long id) {
        for (ProductModel productModel: findAll()) {
            if (productModel.getId().equals(id)) {
                return productModel;
            }
        }
        return null;
    }

    @Override
    public ProductModel update(int index, ProductModel productModel) {
        return findAll().set(index, productModel);
    }
}
