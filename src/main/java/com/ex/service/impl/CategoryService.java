package com.ex.service.impl;

import com.ex.dao.ICategoryDAO;
import com.ex.dao.impl.CategoryDAO;
import com.ex.data.CreateData;
import com.ex.model.CategoryModel;
import com.ex.service.ICategoryService;

import java.util.List;

public class CategoryService implements ICategoryService {
    private ICategoryDAO categoryDAO;

    public CategoryService() {
        if (categoryDAO == null) categoryDAO = new CategoryDAO();
    }

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }

    @Override
    public CategoryModel findOne(long id) {
        return categoryDAO.findOne(id);
    }

    @Override
    public CategoryModel insert(CategoryModel categoryModel) {
        return categoryDAO.insert(categoryModel);
    }

    @Override
    public CategoryModel update(int index, CategoryModel categoryModel) {
        return categoryDAO.update(index, categoryModel);
    }
}
