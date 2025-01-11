package com.example.demo.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SocketReq {
    private String message;

    private String userId;
}
