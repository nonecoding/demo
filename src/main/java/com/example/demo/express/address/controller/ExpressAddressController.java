package com.example.demo.express.address.controller;


import com.example.demo.common.utils.ResponseResult;
import com.example.demo.express.address.entity.ExpressAddress;
import com.example.demo.express.address.service.ExpressAddressServiceImpl;
import com.example.demo.express.address.vo.AuthReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/express-address")
public class ExpressAddressController {

    @Autowired
    private ExpressAddressServiceImpl expressAddressService;

    @PostMapping("/create")
    public ResponseResult<String> create(@RequestBody ExpressAddress expressAddress) {
        expressAddressService.create(expressAddress);
        return ResponseResult.success("Create success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseResult<String> delete(@PathVariable Integer id) {
        expressAddressService.delete(id);
        return ResponseResult.success("Delete success");
    }

    @PutMapping("/update")
    public ResponseResult<String> update(@RequestBody ExpressAddress expressAddress) {
        expressAddressService.update(expressAddress);
        return ResponseResult.success("Update success");
    }

    @GetMapping("/get/{id}")
    public ResponseResult<ExpressAddress> get(@PathVariable Integer id) {
        ExpressAddress address = expressAddressService.getById(id);
        return ResponseResult.success(address);
    }

    @GetMapping("/list")
    public ResponseResult<List<ExpressAddress>> list(@RequestParam(defaultValue = "1") int pageNum,
                                                    @RequestParam(defaultValue = "10") int pageSize) {
        List<ExpressAddress> addresses = expressAddressService.getPage(pageNum, pageSize);
        return ResponseResult.success(addresses);
    }

    /**
     * 根据国家法律法规要求，寄件人姓名须与实名信息一致。您可以在下单前认证或现场出示证件
     * @param authReq
     * @return
     */
    @PostMapping("/auth")
    public ResponseResult<Boolean> auth(@RequestBody AuthReq authReq) {
        Boolean result = expressAddressService.auth(authReq);
        return ResponseResult.success(result);
    }
}