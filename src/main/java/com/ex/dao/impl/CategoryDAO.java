package com.ex.dao.impl;

import com.ex.dao.ICategoryDAO;
import com.ex.data.CreateData;
import com.ex.model.CategoryModel;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
    @Override
    public List<CategoryModel> findAll() {
        return CreateData.categoryModels;
    }

    @Override
    public CategoryModel findOne(long id) {
        for (CategoryModel categoryModel : CreateData.categoryModels) {
            if (categoryModel.getId().equals(id)) {
                return categoryModel;
            }
        }
        return null;
    }

    @Override
    public CategoryModel insert(CategoryModel categoryModel) {
        return insert(CreateData.categoryModels, categoryModel);
    }

    @Override
    public CategoryModel update(int index, CategoryModel categoryModel) {
        List<CategoryModel> categoryModels = findAll();
        return categoryModels.set(index, categoryModel);
    }
}
