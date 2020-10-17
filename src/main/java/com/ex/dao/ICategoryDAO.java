package com.ex.dao;

import com.ex.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO {
    List<CategoryModel> findAll();

    CategoryModel findOne(long id);

    CategoryModel insert(CategoryModel categoryModel);

    CategoryModel update(int index, CategoryModel categoryModel);
}
