package com.ex.dao;

import java.util.List;

public interface GenericDAO<T> {
    T insert(List<T> list, T t);
}
