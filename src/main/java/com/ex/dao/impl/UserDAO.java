package com.ex.dao.impl;

import com.ex.dao.IUserDAO;
import com.ex.data.CreateData;
import com.ex.model.UserModel;

import java.util.List;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

    @Override
    public List<UserModel> findAll() {
        return CreateData.userModels;
    }

    @Override
    public UserModel findOne(long id) {
        for (UserModel userModel: CreateData.userModels) {
            if (userModel.getId().equals(id))
                return userModel;
        }
        return null;
    }

    @Override
    public UserModel findByUserNameAndPassword(String userName, String password, int status) {
        for (UserModel userModel: CreateData.userModels) {
            if (userModel.getUserName().equals(userName) && userModel.getPassword().equals(password) &&
                userModel.getStatus() == status)
                return userModel;
        }
        return null;
    }

    @Override
    public UserModel insert(UserModel userModel) {
        return insert(CreateData.userModels, userModel);
    }

    @Override
    public void delete(Long id) {
        for (UserModel userModel: CreateData.userModels) {
            if (userModel.getId().equals(id))
                userModel.setStatus(0);
        }
    }
}
