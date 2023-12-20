package com.example.bilibili.mapper.rx;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CreatorToolMapper {
    @Select("SELECT Title, ViewCount, LikeNum, LikeNum / ViewCount AS LikeRate, LikeNum * 0.01 AS Earnings FROM Resource WHERE id = id")
    List<Map<String, Object>> getVideosByCreatorId(Integer id);
}
