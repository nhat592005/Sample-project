package com.example.demo.repository.ultis;

public class checkStringorNumber {
    public static boolean checkNumber(String value) {
        try {
            @SuppressWarnings("unused")
            Long number = (long) Integer.parseInt(value);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
