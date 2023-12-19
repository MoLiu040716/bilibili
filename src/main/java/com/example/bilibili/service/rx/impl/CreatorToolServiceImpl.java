package com.example.bilibili.service.rx.impl;

import com.example.bilibili.mapper.rx.CreatorToolMapper;
import com.example.bilibili.service.rx.CreatorToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


        // 创建测试数据
//        {
//            Map<String, Object> data1 = new HashMap<>();
//            data1.put("title", "Video 1");
//            data1.put("playNum", 1000);
//            data1.put("likeNum", 500);
//            data1.put("collectNum", 200);
//            data1.put("danmuNum", 100);
//            testDataList.add(data1);
//
//            Map<String, Object> data2 = new HashMap<>();
//            data2.put("title", "Video 2");
//            data2.put("playNum", 800);
//            data2.put("likeNum", 300);
//            data2.put("collectNum", 150);
//            data2.put("danmuNum", 80);
//            testDataList.add(data2);
//            return testDataList;
//        }

        testDataList=creatorToolMapper.getVideosByCreatorId(ID);
        return creatorToolMapper.getVideosByCreatorId(ID);
    }
}
