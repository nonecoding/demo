package com.example.demo.express.address.vo;

import lombok.Data;

@Data
public class AuthReq {
    private String name;           // 寄件人姓名
    private String idCardNumber;   // 身份证号码
    private String phoneNumber;    // 手机号码
}
