package com.example.bilibili.service.rx.impl;

import com.example.bilibili.entity.Resource;
import com.example.bilibili.mapper.rx.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bilibili.service.rx.VideoService;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private ResourceMapper videoMapper;
    @Override
    public boolean uploadVideo (Resource video){
        return videoMapper.uploadVideo(video);
    }

}
