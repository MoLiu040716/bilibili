package com.example.bilibili.service.rx.impl;

import com.example.bilibili.entity.Resource;
import com.example.bilibili.mapper.rx.ResourceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bilibili.service.rx.VideoService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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
                video.getUrl(),video.getTitle(),video.getIntroduction(),
                video.getFileSize(),video.getFileType(),
                video.getDuration(),uploaderID);
    }

    @Override
    public String getUrlById(int id) {
        Resource r = videoMapper.selectById(id);
        if (r!=null){
            return r.getUrl();
        }else {
            return "未找到视频的URL";
        }

    }

    @Override
    public List<Resource> findAll(int id) {
        List<Resource> resourceList = videoMapper.selectAllResource(id);
        if (resourceList==null){
            return null;
        }
        return resourceList;
    }

}
