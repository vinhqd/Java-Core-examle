package com.ex.model;

public class CategoryModel extends AbstractModel {
    private String name;

    public CategoryModel() {
    }

    public CategoryModel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryModel{" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
