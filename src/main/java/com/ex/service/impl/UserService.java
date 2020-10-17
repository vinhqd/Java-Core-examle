package com.ex.service.impl;

import com.ex.constant.SystemConstant;
import com.ex.dao.IRoleDAO;
import com.ex.dao.IUserDAO;
import com.ex.dao.impl.RoleDAO;
import com.ex.dao.impl.UserDAO;
import com.ex.model.AbstractModel;
import com.ex.model.UserModel;
import com.ex.service.IUserService;
import com.ex.utils.IdUtil;

import java.util.List;

public class UserService implements IUserService {
    private IUserDAO userDAO;
    private IRoleDAO roleDAO;

    public UserService() {
        if (userDAO == null) userDAO = new UserDAO();
        if (roleDAO == null) roleDAO = new RoleDAO();
    }

    @Override
    public List<UserModel> findAll() {
        return userDAO.findAll();
    }

    @Override
    public UserModel findOne(long id) {
        return userDAO.findOne(id);
    }

    @Override
    public UserModel findByUserNameAndPassword(String userName, String password, int status) {
        return userDAO.findByUserNameAndPassword(userName, password, status);
    }

    @Override
    public UserModel insert(UserModel userModel) {
        List<UserModel> userModels = userDAO.findAll();
        for (UserModel user : userModels) {
            if (user.getStatus() != SystemConstant.STATUS_OK || user.getUserName().equals(userModel.getUserName())){
                return null;
            }
        }
        userModel.setRoleModel(roleDAO.findOne(userModel.getRoleId()));
        return userDAO.insert(userModel);
    }

    @Override
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
