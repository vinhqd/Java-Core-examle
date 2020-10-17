package com.ex.model;

public abstract class AbstractModel {
    private Long id;

    public static Long currentId = 1L;

    public AbstractModel() {
        this.id = currentId;
        currentId++;
    }

    public Long getId() {
        return id;
    }
}
