package com.ex.model;

import java.util.Objects;

public class ProductModel extends AbstractModel {
    private String name;
    private double price;
    private long categoryId;
    private CategoryModel categoryModel;

    public ProductModel() {
    }

    public ProductModel(String name, double price, long categoryId) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public CategoryModel getCategoryModel() {
        return categoryModel;
    }

    public void setCategoryModel(CategoryModel categoryModel) {
        this.categoryModel = categoryModel;
    }

    @Override
    public String toString() {
        return "ProductModel{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", categoryName=" + categoryModel.getName() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductModel that = (ProductModel) o;
        return Long.compare(that.getId(), getId()) == 0;
    }
}
