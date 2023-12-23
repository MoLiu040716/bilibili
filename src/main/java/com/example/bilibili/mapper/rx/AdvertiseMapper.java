package com.example.bilibili.mapper.rx;

import com.example.bilibili.entity.AdvertisingPosition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Mapper
public interface AdvertiseMapper {
    @Insert("INSERT INTO advertising_position (begin_time, end_time, introduction," +
            "process,reward, title,advertiser_id )" +
            "process,reward, title,advertiser_id,show_num )" +
            "VALUES (#{BeginTime}, #{EndTime}, #{Introduction}, " +
            "#{Process},#{Reward},#{Title},#{advertiser_id}) ")
    int uploadAdvertise(Date BeginTime,Date EndTime,String Introduction,Integer Process,
                        Double Reward,String Title,Integer advertiser_id);

    @Select("SELECT id, begin_time, end_time, introduction, process," +
            "reward,title,advertiser_id, " +
            "(SELECT user_name FROM advertiser WHERE id=(SELECT advertiser_id FROM advertiser WHERE id=#{ad_id})) " +
            "FROM advertising_position WHERE id = #{ad_id}")
    List<Map<String, Object>> getAdvertise(Integer ad_id);

    @Update("UPDATE advertising_position SET show_num = show_num + 1 WHERE id = #{ad_id}")
    int addShowNum(Integer ad_id);

    @Insert("INSERT INTO advertise_click (user_id,take_advertise_id,click_time) " +
            "VALUES (#{UserID},#{TakeAdvertiseID},#{clickTime})")
    int clickAdvertise(Integer UserID,Integer TakeAdvertiseID,Date ClickTime);


}