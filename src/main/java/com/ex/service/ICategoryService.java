package com.ex.service;

import com.ex.model.CategoryModel;

import java.util.List;

public interface ICategoryService {
    List<CategoryModel> findAll();
    CategoryModel insert(CategoryModel categoryModel);
    CategoryModel findOne(long id);
    CategoryModel update(int index, CategoryModel categoryModel);
}
