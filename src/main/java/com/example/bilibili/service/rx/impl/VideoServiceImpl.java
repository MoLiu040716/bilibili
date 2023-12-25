package com.example.bilibili.service.rx.impl;

import com.example.bilibili.entity.Resource;
import com.example.bilibili.mapper.rx.ResourceMapper;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bilibili.service.rx.VideoService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private ResourceMapper videoMapper;
    @Override
    public int uploadVideo (Resource video,Integer uploaderID){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date uploadTime=video.getUpdateTime();
        String formattedTime = dateFormat.format(uploadTime);
        return videoMapper.uploadVideo(formattedTime,formattedTime,
                video.getURL(),video.getTitle(),video.getIntroduction(),
                video.getFileSize(),video.getFileType(),
                video.getDuration(),uploaderID);
    }

}
