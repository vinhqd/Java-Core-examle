package com.ex.service.impl;

import com.ex.dao.IRoleDAO;
import com.ex.dao.impl.RoleDAO;
import com.ex.model.RoleModel;
import com.ex.service.IRoleService;

import java.util.List;

public class RoleService implements IRoleService {
    private IRoleDAO roleDAO;

    public RoleService() {
        if (roleDAO == null) roleDAO = new RoleDAO();
    }

    @Override
    public List<RoleModel> findAll() {
        return roleDAO.findAll();
    }

}
