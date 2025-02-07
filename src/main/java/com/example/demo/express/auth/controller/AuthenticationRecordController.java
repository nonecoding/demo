package com.example.demo.express.auth.controller;


import com.example.demo.common.utils.ResponseResult;

import com.example.demo.express.auth.entity.AuthenticationRecord;
import com.example.demo.express.auth.service.AuthenticationRecordServiceImpl;
import com.example.demo.express.auth.vo.AuthenticationRecordReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth-record")
public class AuthenticationRecordController {
    
    @Autowired
    private AuthenticationRecordServiceImpl authenticationRecordService;

    @PostMapping("/create")
    public ResponseResult<Integer> create(@RequestBody AuthenticationRecordReq record) {
        return ResponseResult.success(authenticationRecordService.create(record));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseResult<Integer> delete(@PathVariable Long id) {
        return ResponseResult.success(authenticationRecordService.delete(id));
    }

    @PutMapping("/update")
    public ResponseResult<Integer> update(@RequestBody AuthenticationRecord record) {
        return ResponseResult.success(authenticationRecordService.update(record));
    }

    @GetMapping("/get/{id}")
    public ResponseResult<AuthenticationRecord> getById(@PathVariable Long id) {
        return ResponseResult.success(authenticationRecordService.getById(id));
    }

    @GetMapping("/list")
    public ResponseResult<List<AuthenticationRecord>> list(
            @RequestParam(defaultValue = "1") int pageNum,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phoneNumber) {
        return ResponseResult.success(authenticationRecordService.getPage(pageNum, pageSize, name, phoneNumber));
    }
}
