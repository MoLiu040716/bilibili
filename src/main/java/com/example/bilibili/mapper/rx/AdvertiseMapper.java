package com.example.bilibili.mapper.rx;

import com.example.bilibili.entity.AdvertiseClick;
import com.example.bilibili.entity.AdvertisingPosition;
import com.example.bilibili.entity.DTO.AdvertiseImpressionData;
import com.example.bilibili.entity.DTO.TimeRange;
import com.example.bilibili.entity.Upload;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdvertiseMapper {
    @Insert("INSERT INTO advertising_position (begin_time, end_time, introduction," +
            "process,reward, title,advertiser_id,show_num )" +
            "VALUES (#{BeginTime}, #{EndTime}, #{Introduction}, " +
            "#{Process},#{Reward},#{Title},#{advertiser_id},0) ")
    @Options(useGeneratedKeys = true, keyProperty = "ADP.id", keyColumn = "id")
    int uploadAdvertise(AdvertisingPosition ADP,Date BeginTime,Date EndTime,String Introduction,Integer Process,
                        Double Reward,String Title,Integer advertiser_id);

    @Select("SELECT t1.id, begin_time, end_time, introduction, process," +
            "reward,title,user_name " +
            "FROM advertising_position t1 " +
            "JOIN advertiser t2 ON t1.advertiser_id=t2.id " +
            "WHERE t1.process IN (0, 1)")
    List<Map<String, Object>> getAdvertise();

    @Update("UPDATE advertising_position " +
            "SET process = " +
            "CASE " +
            "WHEN begin_time > #{currentTime} THEN 0 " +
            "WHEN end_time < #{currentTime} THEN 2 " +
            "ELSE 1 " +
            "END")
    void updateAdvertiseProcess(Date currentTime);

    @Update("UPDATE advertising_position SET show_num = show_num + 1 WHERE id = #{ad_id}")
    int addShowNum(Integer ad_id);

    @Select("SELECT begin_time AS beginTime, end_time AS endTime FROM advertising_position WHERE id=#{ad_ID}")
    TimeRange getBeginAndEndTime(Integer ad_ID);

    @Insert("INSERT INTO advertise_click (user_id, take_advertise_id, click_time,viewing_duration) " +
            "VALUES (#{UserID}, #{TakeAdvertiseID}, #{ClickTime},0)")
    @Options(useGeneratedKeys = true, keyProperty = "adck.id", keyColumn = "id")
    int clickAdvertise(AdvertiseClick adck,Integer UserID, Integer TakeAdvertiseID, Date ClickTime);
    @Select("SELECT click_time FROM advertise_click WHERE id=#{ClickID}")
    Date getClickTime(Integer ClickID);
    @Update("UPDATE advertise_click SET viewing_duration=#{duration} WHERE id=#{ClickID}")
    int setDuration(Integer ClickID,int duration);

    @Select("SELECT id,impression_num AS impressionNum,upload_id AS UploadID FROM take_advertise WHERE position_id=#{AdPositionId}")
    List<AdvertiseImpressionData> getAllImpressionNum(Integer AdPositionId);
    @Select("SELECT COUNT(*) AS ClickNum " +
            "FROM advertise_click " +
            "WHERE take_advertise_id = #{TakeAdId}")
    int getAllClickNum(Integer TakeAdId);

}