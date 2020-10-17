package com.ex.model;

public class RoleModel extends AbstractModel{
    private String name;
    private String code;

    public RoleModel() {
    }

    public RoleModel(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "RoleModel{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
