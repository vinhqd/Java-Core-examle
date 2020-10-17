package com.ex.utils;

import java.util.Scanner;

public class ScannerUtil {
    public int checkInteger(Scanner s, String message, String error) {
        while (true) {
            try {
                System.out.println(message);
                return Integer.parseInt(s.nextLine());
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }

    public double checkDouble(Scanner s, String message, String error) {
        while (true) {
            try {
                System.out.println(message);
                return Double.parseDouble(s.nextLine());
            } catch (Exception e) {
                System.out.println(error);
            }
        }
    }
}
