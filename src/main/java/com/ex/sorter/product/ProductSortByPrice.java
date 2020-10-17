package com.ex.sorter.product;

import com.ex.model.ProductModel;

import java.util.Comparator;

public class ProductSortByPrice implements Comparator<ProductModel> {
    @Override
    public int compare(ProductModel o1, ProductModel o2) {
        if (o1.getPrice() - o2.getPrice() == 0) {
            return o1.getName().toLowerCase().compareTo(o2.getName().toLowerCase());
        }
        return (int) Math.ceil(o1.getPrice() - o2.getPrice());
    }
}
