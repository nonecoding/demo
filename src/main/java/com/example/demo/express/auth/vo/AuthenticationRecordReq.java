package com.example.demo.express.auth.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * @author think
 * @version 1.0
 * @description:
 * @date 2025/2/7 17:15
 */
@Data
@Accessors(chain = true)
public class AuthenticationRecordReq {
    private Long id;
    private String name;
    private String idCardNumber;
    private String phoneNumber;
    private LocalDateTime authTime;
    private Integer authStatus;
    private String remark;
}
