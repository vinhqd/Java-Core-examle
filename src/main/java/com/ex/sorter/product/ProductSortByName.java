package com.ex.sorter.product;

import com.ex.model.ProductModel;

import java.util.Comparator;

public class ProductSortByName implements Comparator<ProductModel> {
    @Override
    public int compare(ProductModel o1, ProductModel o2) {
        if (o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase()) == 0) {
            return (int) Math.ceil(o1.getPrice() - o2.getPrice());
        }
        return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
    }
}
