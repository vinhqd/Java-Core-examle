package com.ex.utils;

import com.ex.model.AbstractModel;

import java.util.List;

public class IdUtil {
    public static <T> long checkId(List<T> tList) {
        if (tList.size() == 0) return 1;
        else return tList.size() + 1;
    }
}
