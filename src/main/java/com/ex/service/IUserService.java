package com.ex.service;

import com.ex.model.UserModel;

import java.util.List;

public interface IUserService {
    List<UserModel> findAll();
    UserModel findOne(long id);
    void delete(Long id);
    UserModel findByUserNameAndPassword(String userName, String password, int status);
    UserModel insert(UserModel userModel);
}
