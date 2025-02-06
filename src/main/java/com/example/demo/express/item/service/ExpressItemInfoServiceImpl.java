package com.example.demo.express.item.service;

import com.example.demo.express.item.entity.ExpressItemInfo;
import com.example.demo.express.item.mapper.ExpressItemInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpressItemInfoServiceImpl{

    @Autowired
    private ExpressItemInfoMapper expressItemInfoMapper;


    public void createExpressItemInfo(ExpressItemInfo expressItemInfo) {
        // set create and update time fields
        LocalDateTime now = LocalDateTime.now();
        expressItemInfo.setCreateTime(now);
        expressItemInfo.setUpdateTime(now);
        expressItemInfoMapper.insertExpressItemInfo(expressItemInfo);
    }


    public void updateExpressItemInfo(ExpressItemInfo expressItemInfo) {
        expressItemInfo.setUpdateTime(LocalDateTime.now());
        expressItemInfoMapper.updateExpressItemInfo(expressItemInfo);
    }


    public void deleteExpressItemInfo(Integer id) {
        expressItemInfoMapper.deleteExpressItemInfoById(id);
    }


    public ExpressItemInfo getExpressItemInfo(Integer id) {
        return expressItemInfoMapper.selectExpressItemInfoById(id);
    }


    public List<ExpressItemInfo> getExpressItemInfoPage(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        return expressItemInfoMapper.selectExpressItemInfoPage(offset, pageSize);
    }
}
