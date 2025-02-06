package com.example.demo.express.address.utils;

import java.util.regex.Pattern;

public class PhoneNumberValidator {

    // Regular expression for validating Chinese phone numbers or landline numbers
    private static final String CHINA_PHONE_OR_LANDLINE_REGEX = "^(1[3-9]\\d{9})$|^(0\\d{2,3}-?\\d{7,8})$";
    private static final Pattern PATTERN = Pattern.compile(CHINA_PHONE_OR_LANDLINE_REGEX);

    /**
     * Validates if the given phone number is a valid Chinese phone number or landline number.
     *
     * @param phoneNumber the phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    public static boolean isValid(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        return PATTERN.matcher(phoneNumber).matches();
    }
}