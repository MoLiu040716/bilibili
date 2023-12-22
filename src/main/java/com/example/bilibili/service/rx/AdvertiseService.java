package com.example.bilibili.service.rx;

import com.example.bilibili.entity.AdvertisingPosition;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AdvertiseService {
    public int uploadAdvertise(AdvertisingPosition advertise);
    public List<Map<String, Object>> getAdvertise(Integer ad_id);
    public int clickAdvertise(Integer UserID, Integer TakeAdvertiseID, Date ClickTime);
}
