package com.example.bilibili.mapper.rx;

import com.example.bilibili.entity.DTO.TimeRange;
import com.example.bilibili.entity.TakeAdvertise;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface CreatorToolMapper {
    @Select("SELECT title, view_count, like_num, like_num / view_count AS like_rate, like_num * 0.01 AS earnings FROM Resource WHERE id = id")
    List<Map<String, Object>> getVideosByCreatorId(Integer id);

    @Insert("INSERT INTO take_advertise (upload_id, position_id, take_time,progress,impression_num) " +
            "VALUES (#{UploadID}, #{PositionID},#{TakeTime}, #{progress},0)")
    @Options(useGeneratedKeys = true, keyProperty = "tk.id", keyColumn = "id")
    int takeAdvertise(TakeAdvertise tk,Integer UploadID, Integer PositionID, Integer progress, Date TakeTime);
    @Select("SELECT begin_time AS beginTime, end_time AS endTime FROM advertising_position WHERE id=#{ad_ID}")
    TimeRange getBeginAndEndTime(Integer ad_ID);

    @Select("SELECT user_name,begin_time,end_time,introduction,title,impression_num " +
            "FROM take_advertise t1 " +
            "JOIN advertising_position t2 ON t1.position_id = t2.id " +
            "JOIN advertiser t3 ON t2.advertiser_id = t3.id " +
            "JOIN advertise_click t4 ON t4.take_advertise_id = t1.id " +
            "WHERE t1.id=8")
    List<Map<String,Object>> setAdvertise(Integer TakeAdId);

    @Update("UPDATE take_advertise SET impression_num=impression_num+1 WHERE id=#{TakeAdId}")
    int addImpressionNum(Integer TakeAdId);

    @Select("SELECT impression_num FROM take_advertise WHERE id=#{TakeAdId}")
    int getImpressionNum(Integer TakeAdId);
    @Select("SELECT COUNT(*) AS ClickNum " +
            "FROM advertise_click " +
            "WHERE take_advertise_id = #{TakeAdId}")
    int getClickNum(Integer TakeAdId);
}
