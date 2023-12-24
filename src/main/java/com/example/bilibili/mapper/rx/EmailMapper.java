package com.example.bilibili.mapper.rx;

import com.example.bilibili.entity.Email;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface EmailMapper {
    //创作者发件箱
    @Select("SELECT email.id AS EmailID, content,send_time,title,user_name AS receiver " +
            "FROM email " +
            "JOIN advertiser ON email.advertiser_id=advertiser.id " +
            "WHERE status=0 AND upload_id=#{UploadID}")
    List<Map<String,Object>> getSendEmailsWithUploadId(Integer UploadID);
    //创作者收件箱
    @Select("SELECT email.id AS EmailID, content,send_time,title,user_name AS receiver " +
            "FROM email " +
            "JOIN advertiser ON email.advertiser_id=advertiser.id " +
            "WHERE status=1 AND upload_id=#{UploadID}")
    List<Map<String,Object>> getReceiveEmailsWithUploadId(Integer UploadID);
    //金主发件箱
    @Select("SELECT email.id AS EmailID, content,send_time,title,user_name AS receiver " +
            "FROM email " +
            "JOIN upload ON email.upload_id=upload.id " +
            "WHERE status=1 AND advertiser_id=#{AdvertiserID}")
    List<Map<String,Object>> getSendEmailsWithAdvertiserId(Integer AdvertiserID);
    //金主收件箱
    @Select("SELECT email.id AS EmailID, content,send_time,title,user_name AS receiver " +
            "FROM email " +
            "JOIN upload ON email.upload_id=upload.id " +
            "WHERE status=0 AND advertiser_id=#{AdvertiserID}")
    List<Map<String,Object>> getReceiveEmailsWithAdvertiserId(Integer AdvertiserID);

    @Insert("INSERT INTO email(content,send_time,status,title,advertiser_id,upload_id) " +
            "VALUES (#{Content},#{SendTime},#{Status},#{Title},#{AdvertiserID},#{UploadID})")
    int sendEmailWithUploadId(String Content,Date SendTime,Integer Status,String Title,Integer AdvertiserID,Integer UploadID);

    @Insert("INSERT INTO email(content,send_time,status,title,advertiser_id,upload_id) " +
            "VALUES (#{Content},#{SendTime},#{Status},#{Title},#{AdvertiserID},#{UploadID})")
    int sendEmailWithAdvertiserId(String Content,Date SendTime,Integer Status,String Title,Integer AdvertiserID,Integer UploadID);
}
