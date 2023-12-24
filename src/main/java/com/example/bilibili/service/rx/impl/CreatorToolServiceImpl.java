package com.example.bilibili.service.rx.impl;

import com.example.bilibili.entity.DTO.TimeRange;
import com.example.bilibili.entity.TakeAdvertise;
import com.example.bilibili.mapper.rx.CreatorToolMapper;
import com.example.bilibili.service.rx.CreatorToolService;
import com.example.bilibili.util.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CreatorToolServiceImpl implements CreatorToolService {
    @Autowired
    private CreatorToolMapper creatorToolMapper;
    @Override
    public List<Map<String, Object>> getAnalysisDataById(Integer ID){
        List<Map<String, Object>> testDataList = new ArrayList<>();

        testDataList=creatorToolMapper.getVideosByCreatorId(ID);
        return creatorToolMapper.getVideosByCreatorId(ID);
    }
    @Override
    public int takeAdvertise(TakeAdvertise tk, Integer UploadID, Integer PositionID, Integer progress){
        Date timeNow=new Date();
        return creatorToolMapper.takeAdvertise(tk,UploadID,PositionID,progress,timeNow);
    }

    @Override
    public int getProgress(Integer ad_id){
        TimeRange BETime=creatorToolMapper.getBeginAndEndTime(ad_id);
        return TimeTools.getActivityProcess(BETime.getBeginTime(),BETime.getEndTime());
    }

    @Override
    public List<Map<String,Object>> setAdvertise(Integer TakeAdId){
        creatorToolMapper.addImpressionNum(TakeAdId);
        return creatorToolMapper.setAdvertise(TakeAdId);
    }

    @Override
    public Double getAdConversionRate(Integer TakeAdId){
        int ImpressionNum=creatorToolMapper.getImpressionNum(TakeAdId);
        int ClickNum=creatorToolMapper.getClickNum(TakeAdId);
        if(ImpressionNum == 0 || ClickNum == 0){
            return 0.0;
        }else{
            return ClickNum*1.0/ImpressionNum;
        }
    }
    @Override
    public List<Map<String,Object>> getAllAds(Integer UploadID){
        return creatorToolMapper.getAllAds(UploadID);
    }
}
