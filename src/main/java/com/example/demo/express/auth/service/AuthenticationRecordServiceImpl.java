package com.example.demo.express.auth.service;


import com.example.demo.express.auth.entity.AuthenticationRecord;
import com.example.demo.express.auth.mapper.AuthenticationRecordMapper;
import com.example.demo.express.auth.vo.AuthenticationRecordReq;
import com.fasterxml.jackson.databind.util.BeanUtil;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
public class AuthenticationRecordServiceImpl{

    @Resource
    AuthenticationRecordMapper authenticationRecordMapper;

    public int create(AuthenticationRecordReq record) {
        AuthenticationRecord authenticationRecord = new AuthenticationRecord();
        BeanUtils.copyProperties(record,authenticationRecord);
        authenticationRecord.setCreateTime(LocalDateTime.now());
        authenticationRecord.setUpdateTime(LocalDateTime.now());
        return authenticationRecordMapper.insert(authenticationRecord);
    }

    public int delete(Long id) {
        return authenticationRecordMapper.deleteById(id);
    }


    public int update(AuthenticationRecord record) {
        record.setUpdateTime(LocalDateTime.now());
        return authenticationRecordMapper.update(record);
    }

    public AuthenticationRecord getById(Long id) {
        return authenticationRecordMapper.selectById(id);
    }


    public List<AuthenticationRecord> getPage(int pageNum, int pageSize, String name, String phoneNumber) {
        int offset = (pageNum - 1) * pageSize;
        return authenticationRecordMapper.selectPage(offset, pageSize, name, phoneNumber);
    }

    public static String verify(String name, String idNo, String phone) throws IOException{

        String url = "https://idenauthen.market.alicloudapi.com/idenAuthentication";
        // 获取appCode链接：https://market.console.aliyun.com/
        String appCode = "e1ff33s21dfg2s1dd2f1ff33fc60d7130";

        String result = "";
        RequestBody formBody = new FormBody.Builder().add("name", name).add("idNo", idNo).build();
        Request request = new Request.Builder().url(url).addHeader("Authorization", "APPCODE " + appCode).post(formBody).build();

        Call call = new OkHttpClient().newCall(request);
        Response response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            System.out.println("execute failed, message:" + e.getMessage());
        }

        assert response != null;
        if (!response.isSuccessful()) {      // 当返回结果发生错误时
            // 状态码为403时一般是套餐包用尽，需续购；注意：续购不会改变秘钥（appCode），仅增加次数
            // 续购链接：https://market.aliyun.com/products/57000002/cmapi025518.html
            System.out.println("request failed----" + "返回状态码" + response.code()  + ",message:" + response.message());
        }
        result = response.body().string();    //此处不可以使用toString()方法，该方法已过期

        return result;

    }

//    private boolean verifyRealNameInfo(String name, String idCard, String phone) {
//        try {
//            // Alibaba Cloud SDK configuration
//            DefaultProfile profile = DefaultProfile.getProfile(
//                    "cn-hangzhou",  // Region
//                    "<your-access-key-id>",
//                    "<your-access-key-secret>"
//            );
//            IAcsClient client = new DefaultAcsClient(profile);
//
//            // Create verification request
//            VerifyIdentityRequest request = new VerifyIdentityRequest();
//            request.setName(name);
//            request.setIdCardNumber(idCard);
//            request.setPhoneNumber(phone);
//
//            // Execute verification
//            VerifyIdentityResponse response = client.getAcsResponse(request);
//
//            // Check verification result
//            return response.getVerificationStatus().equals("PASS");
//
//        } catch (Exception e) {
//            log.error("阿里云实名认证服务调用失败", e);
//            return false;
//        }
//    }

}
