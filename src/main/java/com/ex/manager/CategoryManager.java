package com.ex.manager;

import com.ex.constant.SystemConstant;
import com.ex.model.AbstractModel;
import com.ex.model.CategoryModel;
import com.ex.service.ICategoryService;
import com.ex.service.impl.CategoryService;
import com.ex.utils.IdUtil;
import com.ex.utils.ScannerUtil;

import java.util.List;
import java.util.Scanner;

public class CategoryManager {
    private ICategoryService categoryService;
    public CategoryManager() {
        if (categoryService == null) categoryService = new CategoryService();
    }

    public void showCategory() {
        List<CategoryModel> categoryModels = categoryService.findAll();
        for (CategoryModel categoryModel : categoryModels) {
            System.out.println(categoryModel.toString());
        }
    }

    public void insertCategory() {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập tên thể loại thêm mới: ");
        String name = s.nextLine();
        AbstractModel.currentId = IdUtil.checkId(categoryService.findAll());
        CategoryModel categoryModel = new CategoryModel(name);
        categoryService.insert(categoryModel);
        System.out.println("Thêm mới thành công!");
    }

    public void updateCategory() {
        showCategory();
        Scanner s = new Scanner(System.in);
        ScannerUtil su = new ScannerUtil();
        long id = su.checkInteger(s, "Nhập id thể loại muốn sửa: ", SystemConstant.ERROR_MESSAGE);
        CategoryModel categoryModel = null;
        int index = 0;
        for (int i = 0; i < categoryService.findAll().size(); i++) {
            if(categoryService.findAll().get(i).getId().equals(id)) {
                categoryModel = categoryService.findAll().get(i);
                index = i;
            }
        }
        if (categoryModel == null) {
            System.out.println("Id không hợp lệ");
            return;
        }
        System.out.println("Nhập tên thể loại muốn sửa: ");
        String name = s.nextLine();
        categoryModel.setName(name);
        categoryService.update(index, categoryModel);
        System.out.println("Update thành công!");
    }
}
