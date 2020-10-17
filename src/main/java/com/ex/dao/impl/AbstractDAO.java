package com.ex.dao.impl;

import com.ex.dao.GenericDAO;

import java.util.List;

public abstract class AbstractDAO<T> implements GenericDAO<T> {

    @Override
    public T insert(List<T> list, T t) {
        list.add(t);
        return t;
    }
}
