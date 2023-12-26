package com.example.bilibili.service.rx;

import com.example.bilibili.entity.Resource;

import java.util.List;


public interface VideoService {
   int uploadVideo (Resource video,Integer uploaderID);

   String getUrlById(int id);

   List<Resource> findAll(int id);


}