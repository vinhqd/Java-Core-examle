package com.ex.view;

import com.ex.constant.SystemConstant;
import com.ex.data.CreateData;
import com.ex.manager.UserManager;
import com.ex.model.UserModel;
import com.ex.utils.ScannerUtil;

import java.util.Scanner;

public class MainView {
    private Scanner s;

    public void openPrograming() {
        s = new Scanner(System.in);
        ScannerUtil su = new ScannerUtil();
        UserManager userManager = new UserManager();
        while (true) {
            MenuView.loginView();
            int choice = su.checkInteger(s, "Lựa chọn: ", SystemConstant.ERROR_MESSAGE);
            switch (choice){
                case 1:
                    UserModel userModel = userManager.checkLogin();
                    if (userModel != null) {
                        System.out.println("Đăng nhập thành công.");
                        System.out.println("Xin chào: " + userModel.getFullName() + "!");
                        CreateData.userModel = userModel;
                        authorization(userModel);
                    } else {
                        System.out.println("Tên đăng nhập hoặc mật khẩu không tồn tại.");
                    }
                    break;
                case 2:
                    userManager.register();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Vui lòng nhập (1 - 2)!");
            }
        }
    }

    private void authorization(UserModel userModel) {
        AdminView adminView = new AdminView();
        UserView userView = new UserView();
        String roleName = userModel.getRoleModel().getCode();
        if (roleName.equals(SystemConstant.ADMIN_ROLE))
            adminView.showAdminView();
        else if (roleName.equals(SystemConstant.USER_ROLE))
            userView.showUserView();
    }


}
