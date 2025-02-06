package com.example.demo.express.address.service;

import com.example.demo.common.exception.ValidationException;
import com.example.demo.express.address.entity.ExpressAddress;
import com.example.demo.express.address.mapper.ExpressAddressMapper;

import com.example.demo.express.address.utils.PhoneNumberMasker;
import com.example.demo.express.address.utils.PhoneNumberValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xj
 * @since 2025-02-05
 */
@Service
public class ExpressAddressServiceImpl{

    @Autowired
    private ExpressAddressMapper expressAddressMapper;

    public int create(ExpressAddress expressAddress) {
        //校验手机号吗
        // Validate phone number
        if (!PhoneNumberValidator.isValid(expressAddress.getPhoneNumber())) {
            throw new ValidationException("Invalid phone number");
        }
        expressAddress.setCreateTime(LocalDateTime.now());
        expressAddress.setUpdateTime(LocalDateTime.now());
        return expressAddressMapper.insert(expressAddress);
    }

    public int delete(Integer id) {
        return expressAddressMapper.deleteById(id);
    }

    public int update(ExpressAddress expressAddress) {
        expressAddress.setUpdateTime(LocalDateTime.now());
        return expressAddressMapper.update(expressAddress);
    }

    public ExpressAddress getById(Integer id) {
        ExpressAddress expressAddress = expressAddressMapper.selectById(id);
        // 查询时确保地址信息不超过40个字符
        if (expressAddress.getDetailAddress() != null && expressAddress.getDetailAddress().length() > 40) {
            expressAddress.setDetailAddress(expressAddress.getDetailAddress().substring(0, 40)+"...");
        }
        String maskedPhoneNumber = PhoneNumberMasker.mask(expressAddress.getPhoneNumber());
        expressAddress.setPhoneNumber(maskedPhoneNumber);
        return expressAddress;
    }

    public List<ExpressAddress> getPage(int pageNum, int pageSize) {
        int offset = (pageNum - 1) * pageSize;
        return expressAddressMapper.selectPage(offset, pageSize);
    }

    public int countAll() {
        return expressAddressMapper.countAll();
    }

}
