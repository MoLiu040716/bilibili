package com.example.bilibili.service.rx.impl;

import com.example.bilibili.entity.Email;
import com.example.bilibili.mapper.rx.EmailMapper;
import com.example.bilibili.service.rx.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailMapper emailMapper;
    public List<Map<String,Object>> getSendEmailsWithUploadId(Integer UploadID){
        return emailMapper.getSendEmailsWithUploadId(UploadID);
    }
    public List<Map<String,Object>> getReceiveEmailsWithUploadId(Integer UploadID){
        return emailMapper.getReceiveEmailsWithUploadId(UploadID);
    }
    public List<Map<String,Object>> getSendEmailsWithAdvertiserId(Integer AdvertiserID){
        return emailMapper.getSendEmailsWithAdvertiserId(AdvertiserID);
    }
    public List<Map<String,Object>> getReceiveEmailsWithAdvertiserId(Integer AdvertiserID){
        return emailMapper.getReceiveEmailsWithAdvertiserId(AdvertiserID);
    }
    public int sendEmailWithUploadId(String Content, Date SendTime, Integer Status, String Title, Integer AdvertiserID, Integer UploadID){
        return emailMapper.sendEmailWithUploadId(Content,SendTime,Status,Title,AdvertiserID,UploadID);
    }
    public int sendEmailWithAdvertiserId(String Content,Date SendTime,Integer Status,String Title,Integer AdvertiserID,Integer UploadID){
        return emailMapper.sendEmailWithAdvertiserId(Content,SendTime,Status,Title,AdvertiserID,UploadID);
    }
}
