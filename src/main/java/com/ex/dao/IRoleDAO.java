package com.ex.dao;

import com.ex.model.RoleModel;

import java.util.List;

public interface IRoleDAO {
    List<RoleModel> findAll();

    RoleModel findOne(Long roleId);
}
