package com.example.demo.Ultis;

public class checkStringorNumber {
    public static boolean checkNumber(String value) {
        try {
            @SuppressWarnings("unused")
            Long number = (long) Long.parseLong(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
