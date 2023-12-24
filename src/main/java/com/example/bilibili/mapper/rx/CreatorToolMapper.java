package com.example.bilibili.mapper.rx;

import com.example.bilibili.entity.DTO.TimeRange;
import com.example.bilibili.entity.TakeAdvertise;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

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
            "WHERE id=#{TakeAdId};")
    List<Map<String,Object>> setAdvertise(Integer TakeAdId);

    //按id统计次数
    int getClickNum(Integer TakeAdId);
}
