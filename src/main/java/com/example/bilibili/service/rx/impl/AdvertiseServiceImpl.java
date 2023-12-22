package com.example.bilibili.service.rx.impl;

import com.example.bilibili.entity.AdvertisingPosition;
import com.example.bilibili.mapper.rx.AdvertiseMapper;
import com.example.bilibili.service.rx.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {
    @Autowired
    private AdvertiseMapper advertiseMapper;
    @Override
    public int uploadAdvertise(AdvertisingPosition advertise){
        return advertiseMapper.uploadAdvertise(advertise.getBeginTime(),advertise.getEndTime(),
                advertise.getIntroduction(),advertise.getProcess(),advertise.getReward(),
                advertise.getTitle(),advertise.getAdvertiser().getId());
    }

    @Override
    public List<Map<String, Object>> getAdvertise(Integer ad_id){
        advertiseMapper.addShowNum(ad_id);
        return advertiseMapper.getAdvertise(ad_id);
    }

    @Override
    public int clickAdvertise(Integer UserID, Integer TakeAdvertiseID, Date ClickTime){
        return advertiseMapper.clickAdvertise(UserID,TakeAdvertiseID,ClickTime);
    }
}
