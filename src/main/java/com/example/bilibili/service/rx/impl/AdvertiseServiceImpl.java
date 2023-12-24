package com.example.bilibili.service.rx.impl;

import com.example.bilibili.entity.AdvertiseClick;
import com.example.bilibili.entity.AdvertisingPosition;
import com.example.bilibili.entity.DTO.AdvertiseImpressionData;
import com.example.bilibili.mapper.rx.AdvertiseMapper;
import com.example.bilibili.service.rx.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AdvertiseServiceImpl implements AdvertiseService {
    @Autowired
    private AdvertiseMapper advertiseMapper;
    @Override
    public int uploadAdvertise(AdvertisingPosition advertise){
        AdvertisingPosition ADP=new AdvertisingPosition();
        advertiseMapper.uploadAdvertise(ADP,advertise.getBeginTime(),advertise.getEndTime(),
                advertise.getIntroduction(),advertise.getProcess(),advertise.getReward(),
                advertise.getTitle(),advertise.getAdvertiser().getId());
        return ADP.getId();
    }

    @Override
    public List<Map<String, Object>> getAdvertise(){
        Date currentTime=new Date();
        advertiseMapper.updateAdvertiseProcess(currentTime);
        return advertiseMapper.getAdvertise();
    }

    @Override
    public int clickAdvertise( Integer UserID, Integer TakeAdvertiseID, Date ClickTime){
        AdvertiseClick adck=new AdvertiseClick();
        advertiseMapper.clickAdvertise(adck,UserID,TakeAdvertiseID,ClickTime);
        return adck.getId();
    }
    @Override
    public int closeAdvertise(Integer ClickID){
        Date Time1=advertiseMapper.getClickTime(ClickID);
        Date Time2=new Date();
        long durationInMillis=Time2.getTime()-Time1.getTime();
        int duration=(int)(durationInMillis/1000);
        return advertiseMapper.setDuration(ClickID,duration);
    }

    @Override
    public List<Map<String,Object>> getAllImpressionData(Integer AdPositionId){
        List<AdvertiseImpressionData> data=advertiseMapper.getAllImpressionNum(AdPositionId);
        List<Map<String,Object>> result=new ArrayList<>();
        for (AdvertiseImpressionData adImData:data) {
            Map<String,Object> dataOfOneUpload=new HashMap<>();
            dataOfOneUpload.put("upload_id",adImData.getUploadID());
            dataOfOneUpload.put("impression_num",adImData.getImpressionNum());
            int id=adImData.getId();
            int clickNum=advertiseMapper.getAllClickNum(id);
            dataOfOneUpload.put("click_num",clickNum);
            double ConversionRate;
            if(adImData.getImpressionNum()==0 || clickNum==0){
                ConversionRate=0.0;
            }else {
                ConversionRate=clickNum*1.0/adImData.getImpressionNum();
            }
            dataOfOneUpload.put("conversion_rate",ConversionRate);
            result.add(dataOfOneUpload);
        }
        return result;
    }
}
