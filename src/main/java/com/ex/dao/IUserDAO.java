package com.ex.dao;

import com.ex.model.UserModel;

import java.util.List;

public interface IUserDAO {
    List<UserModel> findAll();
    UserModel findOne(long id);
    UserModel findByUserNameAndPassword(String userName, String password, int status);
    UserModel insert(UserModel userModel);
    void delete(Long id);
}
