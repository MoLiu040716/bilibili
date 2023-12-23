package com.example.bilibili.mapper.rx;

import com.example.bilibili.entity.AdvertisingPosition;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdvertiseMapper {
    @Insert("INSERT INTO advertising_position (begin_time, end_time, introduction," +
            "process,reward, title,advertiser_id )" +
            "VALUES (#{BeginTime}, #{EndTime}, #{Introduction}, " +
            "#{Process},#{Reward},#{Title},#{advertiser_id}) ")
    int uploadAdvertise(AdvertisingPosition advertise,Integer advertiser_ID);
}
