package com.ex.dao.impl;

import com.ex.dao.IRoleDAO;
import com.ex.data.CreateData;
import com.ex.data.SystemData;
import com.ex.model.RoleModel;

import java.util.List;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO {

    @Override
    public List<RoleModel> findAll() {
        return CreateData.roleModels;
    }

    @Override
    public RoleModel findOne(Long roleId) {
        for (RoleModel roleModel: CreateData.roleModels) {
            if (roleModel.getId().equals(roleId))
                return roleModel;
        }
        return null;
    }
}
