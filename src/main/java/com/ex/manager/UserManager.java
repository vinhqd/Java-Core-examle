package com.ex.manager;

import com.ex.constant.SystemConstant;
import com.ex.model.AbstractModel;
import com.ex.model.UserModel;
import com.ex.service.IUserService;
import com.ex.service.impl.UserService;
import com.ex.utils.IdUtil;
import com.ex.utils.ScannerUtil;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager {
    private IUserService userService;

    public UserManager() {
        if (userService == null) userService = new UserService();
    }

    public UserModel checkLogin(){
        Scanner s = new Scanner(System.in);
        Console console = System.console();
        System.out.println("Nhập tên đăng nhập: ");
        String userName = s.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = s.nextLine();
        return userService.findByUserNameAndPassword(userName, password, SystemConstant.STATUS_OK);
    }

    public void register() {
        Scanner s = new Scanner(System.in);
        System.out.println("Nhập tên đăng nhập: ");
        String userName = s.nextLine();
        System.out.println("Nhập mật khẩu: ");
        String password = s.nextLine();
        System.out.println("Nhập lại mật khẩu: ");
        String confirmPassword = s.nextLine();
        System.out.println("Nhập tên đầy đủ: ");
        String fullName = s.nextLine();
        AbstractModel.currentId = IdUtil.checkId(userService.findAll());
        UserModel userModel = userService.insert(new UserModel(
                userName, password, fullName, SystemConstant.STATUS_OK, 1L));
        if (userModel == null){
            System.out.println("Tên đăng nhập đã tồn tại!");
            return;
        }
        if (password.equals(confirmPassword)) {
            System.out.println("Đăng ký thành công!");
        } else {
            System.out.println("Confirm password invalid!");
        }
    }

    public void showUsers() {
        List<UserModel> userModels = userService.findAll();
        for (UserModel userModel : userModels) {
            if (userModel.getStatus() == SystemConstant.STATUS_OK &&
                userModel.getRoleModel().getCode().equals(SystemConstant.USER_ROLE)) {
                System.out.println(userModel.toString());
            }
        }
    }

    public void deleteUser() {
        if (getUserByUser().size() != 0) {
            showUsers();
            Scanner s = new Scanner(System.in);
            ScannerUtil su = new ScannerUtil();
            long userId = su.checkInteger(s, "Nhập id user muốn xoá: ", SystemConstant.ERROR_MESSAGE);
            UserModel userModel = userService.findOne(userId);
            if (userModel != null && userModel.getRoleModel().getCode().equals(SystemConstant.USER_ROLE)) {
                System.out.println("Xoá thành công username: " + userService.findOne(userId).getUserName() + "!");
                userService.delete(userId);
            } else {
                System.out.println("Id không tồn tại.");
            }
        } else {
            System.out.println("Chưa có người dùng nào!");
        }
    }

    private List<UserModel> getUserByUser() {
        List<UserModel> userModels = userService.findAll();
        List<UserModel> users = new ArrayList<>();
        for (UserModel userModel: userModels) {
            if (userModel.getRoleModel().getCode().equals(SystemConstant.USER_ROLE) &&
                userModel.getStatus() == SystemConstant.STATUS_OK){
                users.add(userModel);
            }
        }
        return users;
    }

}
