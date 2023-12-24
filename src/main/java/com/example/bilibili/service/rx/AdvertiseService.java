package com.example.bilibili.service.rx;

import com.example.bilibili.entity.AdvertiseClick;
import com.example.bilibili.entity.AdvertisingPosition;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface AdvertiseService {
    public int uploadAdvertise(AdvertisingPosition advertise);
    public List<Map<String, Object>> getAdvertise();
    public int clickAdvertise( Integer UserID, Integer TakeAdvertiseID, Date ClickTime);
    public int closeAdvertise(Integer ClickID);
    public List<Map<String,Object>> getAllImpressionData(Integer AdPositionId);
}
