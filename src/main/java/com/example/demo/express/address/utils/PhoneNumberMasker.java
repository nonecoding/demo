package com.example.demo.express.address.utils;

public class PhoneNumberMasker {

    /**
     * Masks the last 5 to 8 digits of a phone number or landline.
     *
     * @param phoneNumber the phone number to mask
     * @return the masked phone number
     */
    public static String mask(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() < 5) {
            return phoneNumber;
        }
        int length = phoneNumber.length();
        StringBuilder maskedNumber = new StringBuilder(phoneNumber);
        for (int i = length - 5; i >= Math.max(length - 8, 0); i--) {
            maskedNumber.setCharAt(i, '*');
        }
        return maskedNumber.toString();
    }
}