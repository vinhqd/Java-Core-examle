package com.ex.view;

public class MenuView {
    public static void loginView() {
        System.out.println("---------- Đăng nhập ----------");
        System.out.println("1. Đăng nhập.");
        System.out.println("2. Đăng ký.");
        System.out.println("0. Thoát chương trình.");
    }

    public static void userView() {
        System.out.println("---------- Người dùng ----------");
        System.out.println("1. Hiển thị sản phẩm.");
        System.out.println("2. Tìm kiếm sản phẩm");
        System.out.println("3. Giỏ hàng.");
        System.out.println("4. Đặt mua.");
        System.out.println("0. Logout.");
    }

    public static void userProductsView() {
        System.out.println("---------- Người dùng -> Hiển thị sản phẩm ----------");
        System.out.println("1. Hiển thị toàn bộ sản phẩm");
        System.out.println("2. Hiển thị sản phẩm theo tên(ASC).");
        System.out.println("3. Hiển thị sản phẩm theo tên(DESC).");
        System.out.println("4. Hiển thị sản phẩm theo giá(ASC).");
        System.out.println("5. Hiển thị sản phẩm theo giá(DESC).");
        System.out.println("0. Quay lại.");
    }

    public static void userSearchView() {
        System.out.println("---------- Người dùng -> Tìm kiếm ----------");
        System.out.println("1. Tìm kiếm theo tên sản phẩm.");
        System.out.println("2. Tìm kiếm theo giá sản phẩm(lớn hơn).");
        System.out.println("3. Tìm kiếm theo giá sản phẩm(nhỏ hơn).");
        System.out.println("4. Tìm kiếm theo thể loại.");
        System.out.println("0. Quay lại.");
    }

    public static void userCartView() {
        System.out.println("---------- Người dùng -> Giỏ hàng ----------");
        System.out.println("1. Hiển thị giỏ hàng");
        System.out.println("2. Xoá sản phẩm khỏi giỏ hàng");
        System.out.println("0. Quay lại.");
    }

    public static void userOrderView() {
        System.out.println("---------- Người dùng -> Đặt hàng ----------");
        System.out.println("1. Hiển thị giỏ hàng");
        System.out.println("2. Hiển thị đơn hàng đã đặt");
        System.out.println("0. Quay lại.");
    }

    public static void addToOrderView() {
        System.out.println("---------- Người dùng -> Đặt hàng ----------");
        System.out.println("1. Đặt hàng");
        System.out.println("0. Quay lại.");
    }

    public static void addToCartView() {
        System.out.println("---------- Người dùng -> Giỏ hàng ----------");
        System.out.println("1. Thểm sản phẩm vào giỏ hàng.");
        System.out.println("0. Quay lại.");
    }

    public static void adminView() {
        System.out.println("---------- Quản trị ----------");
        System.out.println("1. Quản lý người dùng.");
        System.out.println("2. Quản lý sản phẩm.");
        System.out.println("3. Quản lý đơn hàng");
        System.out.println("0. Logout.");
    }

    public static void orderManagerView(){
        System.out.println("---------- Quản trị -> Quản lý đơn hàng ----------");
        System.out.println("1. Hiển thị danh sách đơn hàng.");
        System.out.println("2. Hiển thị danh sách đơn hàng chưa xác nhân.");
        System.out.println("3. Hiển thị danh sách đơn hàng đang vận chuyển.");
        System.out.println("4. Hiển thị danh sách đơn hàng đã chuyển xong.");
        System.out.println("0. Quay lại..");
    }

    public static void subOrderManagerView(String message){
        System.out.println("1. " + message + ".");
        System.out.println("0. Quay lại.");
    }

    public static void userManagerView() {
        System.out.println("---------- Quản trị -> Quản lý người dùng ----------");
        System.out.println("1. Hiển thị danh sách User.");
        System.out.println("2. Sắp xếp User.");
        System.out.println("2. Tìm kiếm User.");
        System.out.println("4. Xoá người dùng.");
        System.out.println("0. Quay lại.");
    }

    public static void productManagerView() {
        System.out.println("---------- Quản trị -> Quản lý sản phẩm ----------");
        System.out.println("1. Hiển thị danh sách sản phẩm.");
        System.out.println("2. Hiển thị thể loại.");
        System.out.println("3. Thểm mới sản phẩm.");
        System.out.println("4. Thêm mới thể loại.");
        System.out.println("5. Sửa sản phẩm.");
        System.out.println("6. Sửa thể loại.");
        System.out.println("7. Tìm kiếm sản phẩm");
        System.out.println("8. Sắp xếp sản phẩm");
        System.out.println("0. Quay lại.");
    }

    public static void productManagerSearchView() {
        System.out.println("---------- Quản trị -> Quản lý sản phẩm -> Tìm kiếm ----------");
        System.out.println("1. Tìm kiếm theo tên sản phẩm.");
        System.out.println("2. Tìm kiếm theo giá sản phẩm(lớn hơn).");
        System.out.println("3. Tìm kiếm theo giá sản phẩm(nhỏ hơn).");
        System.out.println("4. Tìm kiếm theo thể loại.");
        System.out.println("0. Quay lại.");
    }

    public static void productManagerSortView() {
        System.out.println("---------- Quản trị -> Quản lý sản phẩm -> Sắp xếp ----------");
        System.out.println("1. Sắp xếp theo tên sản phẩm(ASC).");
        System.out.println("2. Sắp xếp theo tên sản phẩm(DESC).");
        System.out.println("3. Sắp xếp theo giá sản phẩm(tăng dần).");
        System.out.println("4. Sắp xếp theo giá sản phẩm(giảm dần).");
        System.out.println("0. Quay lại.");
    }
}
