package com.ex.main;

import com.ex.data.CreateData;
import com.ex.view.MainView;

public class Main {
    public static void main(String[] args) {
        CreateData.getInstance().initData();
        MainView mv = new MainView();
        mv.openPrograming();
    }

}
