package com.ex.manager;

import com.ex.constant.SystemConstant;
import com.ex.data.CreateData;
import com.ex.model.AbstractModel;
import com.ex.model.ProductModel;
import com.ex.service.ICategoryService;
import com.ex.service.IProductService;
import com.ex.service.impl.CategoryService;
import com.ex.service.impl.ProductService;
import com.ex.sorter.product.ProductSortByName;
import com.ex.sorter.product.ProductSortByPrice;
import com.ex.utils.IdUtil;
import com.ex.utils.ScannerUtil;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private IProductService productService;
    private ICategoryService categoryService;

    public ProductManager() {
        if (productService == null) productService = new ProductService();
        if (categoryService == null) categoryService = new CategoryService();
    }

    public void showProduct() {
        List<ProductModel> productModels = productService.findAll();
        for (ProductModel productModel : productModels) {
            System.out.println(productModel.toString());
        }
    }

    public void insertProduct() {
        Scanner s = new Scanner(System.in);
        ScannerUtil su = new ScannerUtil();
        CategoryManager categoryManager = new CategoryManager();
        System.out.println("Nhập tên sản phẩm mới: ");
        String name = s.nextLine();
        double price = su.checkDouble(s, "Nhập giá sản phẩm mới: ", SystemConstant.ERROR_MESSAGE);
        int categoryId;
        while (true) {
            categoryManager.showCategory();
            categoryId = su.checkInteger(s, "Nhập id thể loại: ", SystemConstant.ERROR_MESSAGE);
            if (categoryService.findOne(categoryId) != null) {
                break;
            } else
                System.out.println("Id thể loại không tồn tại!");
        }
        AbstractModel.currentId = IdUtil.checkId(CreateData.productModels);
        productService.insert(new ProductModel(name, price, categoryId));
        System.out.println("Thêm mới sản phẩm thành công!");
    }

    public void updateProduct() {
        showProduct();
        Scanner s = new Scanner(System.in);
        ScannerUtil su = new ScannerUtil();
        CategoryManager categoryManager = new CategoryManager();
        long id = su.checkInteger(s, "Nhập id sản phẩm cần sửa: ", SystemConstant.ERROR_MESSAGE);
        ProductModel productModel = null;
        int index = 0;
        for (int i = 0; i < productService.findAll().size(); i++) {
            if (productService.findAll().get(i).getId().equals(id)) {
                productModel = productService.findAll().get(i);
                index = i;
            }
        }
        if (productModel == null) {
            System.out.println("Id sản phẩm không tồn tại");
            return;
        }
        double newPrice = su.checkDouble(s, "Nhập giá mới cho sản phẩm: ", SystemConstant.ERROR_MESSAGE);
        productModel.setPrice(newPrice);
        productService.update(index, productModel);
        System.out.println("Update sản phẩm thành công!");
    }

    public void searchProductByName() {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập tên sản phẩm cần tìm kiếm: ");
        String searchName = s.nextLine();
        List<ProductModel> productModels = productService.findByName(searchName);
        if (productModels.size() == 0)
            System.out.println("Không tìm thấy sản phẩm nào!");
        else {
            for (ProductModel productModel : productModels) {
                System.out.println(productModel.toString());
            }
        }
    }

    public void searchProductByBiggerPrice() {
        Scanner s = new Scanner(System.in);
        ScannerUtil su = new ScannerUtil();
        double priceSearch = su.checkDouble(s, "Nhập giá sản phẩm tìm kiếm: ", SystemConstant.ERROR_MESSAGE);
        List<ProductModel> productModels = productService.findByPrice(priceSearch, SystemConstant.BIGGER_PRICE);
        if (productModels.size() == 0)
            System.out.println("Không tìm thấy sản phẩm nào!");
        else {
            for (ProductModel productModel : productModels) {
                System.out.println(productModel.toString());
            }
        }
    }

    public void searchProductByLesserPrice() {
        Scanner s = new Scanner(System.in);
        ScannerUtil su = new ScannerUtil();
        double priceSearch = su.checkDouble(s, "Nhập giá sản phẩm tìm kiếm: ", SystemConstant.ERROR_MESSAGE);
        List<ProductModel> productModels = productService.findByPrice(priceSearch, SystemConstant.LESSER_PRICE);
        if (productModels.size() == 0)
            System.out.println("Không tìm thấy sản phẩm nào!");
        else {
            for (ProductModel productModel : productModels) {
                System.out.println(productModel.toString());
            }
        }
    }

    public void searchProductByCategory() {
        Scanner s = new Scanner(System.in);
        ScannerUtil su = new ScannerUtil();
        CategoryManager categoryManager = new CategoryManager();
        long cateIdSearch;
        while (true) {
            categoryManager.showCategory();
            cateIdSearch = su.checkInteger(s, "Nhập id sản phẩm tìm kiếm: ", SystemConstant.ERROR_MESSAGE);
            if (categoryService.findOne(cateIdSearch) != null) {
                break;
            } else {
                System.out.println("Id thể loại không tồn tại!");
            }
        }
        List<ProductModel> productModels = productService.findByCategory(cateIdSearch);
        if (productModels.size() == 0)
            System.out.println("Không tìm thấy sản phẩm nào!");
        else {
            for (ProductModel productModel : productModels) {
                System.out.println(productModel.toString());
            }
        }
    }

    public void sortProductByNameASC() {
        List<ProductModel> productModels = productService.findAll();
        Collections.sort(productModels, new ProductSortByName());
        for (ProductModel productModel : productModels) {
            System.out.println(productModel.toString());
        }
    }

    public void sortProductByNameDESC() {
        List<ProductModel> productModels = productService.findAll();
        Collections.sort(productModels, new ProductSortByName());
        Collections.reverse(productModels);
        for (ProductModel productModel : productModels) {
            System.out.println(productModel.toString());
        }
    }

    public void sortProductByPriceASC() {
        List<ProductModel> productModels = productService.findAll();
        Collections.sort(productModels, new ProductSortByPrice());
        for (ProductModel productModel : productModels) {
            System.out.println(productModel.toString());
        }
    }

    public void sortProductByPriceDESC() {
        List<ProductModel> productModels = productService.findAll();
        Collections.sort(productModels, new ProductSortByPrice());
        Collections.reverse(productModels);
        for (ProductModel productModel : productModels) {
            System.out.println(productModel.toString());
        }
    }
}
