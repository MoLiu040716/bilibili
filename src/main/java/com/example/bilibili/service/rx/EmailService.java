package com.example.bilibili.service.rx;

import com.example.bilibili.entity.Email;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EmailService {
    public List<Map<String,Object>> getSendEmailsWithUploadId(Integer UploadID);
    public List<Map<String,Object>> getReceiveEmailsWithUploadId(Integer UploadID);
    public List<Map<String,Object>> getSendEmailsWithAdvertiserId(Integer AdvertiserID);
    public List<Map<String,Object>> getReceiveEmailsWithAdvertiserId(Integer AdvertiserID);
    public int sendEmailWithUploadId(String Content, Date SendTime, Integer Status, String Title, Integer AdvertiserID, Integer UploadID);
    public int sendEmailWithAdvertiserId(String Content,Date SendTime,Integer Status,String Title,Integer AdvertiserID,Integer UploadID);
}
