package com.example.demo.express.address.service;

import com.example.demo.common.exception.ValidationException;
import com.example.demo.express.address.entity.ExpressAddress;
import com.example.demo.express.address.mapper.ExpressAddressMapper;

import com.example.demo.express.address.utils.PhoneNumberMasker;
import com.example.demo.express.address.utils.PhoneNumberValidator;
import com.example.demo.express.address.vo.AuthReq;
import com.example.demo.express.auth.entity.AuthenticationRecord;
import com.example.demo.express.auth.mapper.AuthenticationRecordMapper;
import com.example.demo.express.auth.service.AuthenticationRecordServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xj
 * @since 2025-02-05
 */
@Slf4j
@Service
public class ExpressAddressServiceImpl{

    @Autowired
    private ExpressAddressMapper expressAddressMapper;
    @Resource
    AuthenticationRecordMapper authenticationRecordMapper;
    @Resource
    AuthenticationRecordServiceImpl realNameVerificationService;

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

    public Boolean auth(AuthReq authReq) {
        // 1. 基础参数校验
        if (StringUtils.isEmpty(authReq.getName())
            || StringUtils.isEmpty(authReq.getIdCardNumber())
            || StringUtils.isEmpty(authReq.getPhoneNumber())) {
            throw new ValidationException("实名认证信息不完整");
        }

        // 2. 身份证号码格式校验
        if (!validateIdCard(authReq.getIdCardNumber())) {
            throw new ValidationException("身份证号码格式不正确");
        }

        // 3. 手机号码格式校验
        if (!PhoneNumberValidator.isValid(authReq.getPhoneNumber())) {
            throw new ValidationException("手机号码格式不正确");
        }

        try {
            // 4. 调用实名认证服务进行验证
            boolean verificationResult = verifyRealNameInfo(
                authReq.getName(),
                authReq.getIdCardNumber(),
                authReq.getPhoneNumber()
            );

            if (verificationResult) {
                // 5. 认证成功，保存认证信息
                saveAuthenticationRecord(authReq);
                return true;
            }

            return false;
        } catch (Exception e) {
            log.error("实名认证过程发生错误", e);
            throw new RuntimeException("实名认证服务异常"+e.getMessage());
        }
    }

    private boolean validateIdCard(String idCard) {
        // 身份证号码校验规则
        String pattern = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)";
        return Pattern.matches(pattern, idCard);
    }

    private boolean verifyRealNameInfo(String name, String idCard, String phone) {
        // 调用第三方实名认证服务
        // 这里可以集成公安部实名认证、运营商三要素认证等服务
        // 示例使用模拟实现
        try {
            // 模拟调用第三方API
             realNameVerificationService.verify(name, idCard, phone);
            return true;
        } catch (Exception e) {
            log.error("第三方实名认证服务调用失败", e);
            return false;
        }
    }

    private void saveAuthenticationRecord(AuthReq authReq) {
        AuthenticationRecord record = new AuthenticationRecord();
        record.setName(authReq.getName());
        record.setIdCardNumber(authReq.getIdCardNumber());
        record.setPhoneNumber(authReq.getPhoneNumber());
        record.setAuthTime(LocalDateTime.now());
        record.setAuthStatus(1);  // 1表示认证成功
        record.setCreateTime(LocalDateTime.now());
        record.setUpdateTime(LocalDateTime.now());
        // 保存认证记录
         authenticationRecordMapper.insert(record);
    }
}
