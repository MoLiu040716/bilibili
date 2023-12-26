package com.example.bilibili.service.rx;

import com.example.bilibili.entity.Resource;

public interface VideoService {
   int uploadVideo (Resource video,Integer uploaderID);

   String getUrlById(int id);



}