package com.example.bilibili.service.rx.impl;

import com.example.bilibili.entity.AdvertisingPosition;
import com.example.bilibili.mapper.rx.AdvertiseMapper;
import com.example.bilibili.service.rx.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {
    @Autowired
    private AdvertiseMapper advertiseMapper;
    @Override
    public int uploadAdvertise(AdvertisingPosition advertise,Integer advertiser_ID){
        return advertiseMapper.uploadAdvertise(advertise,advertiser_ID);
    }
}
