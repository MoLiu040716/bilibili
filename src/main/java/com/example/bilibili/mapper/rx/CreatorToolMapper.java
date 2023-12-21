package com.example.bilibili.mapper.rx;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CreatorToolMapper {
    @Select("SELECT title, view_count, like_num, like_num / view_count AS like_rate, like_num * 0.01 AS earnings FROM Resource WHERE id = id")
    List<Map<String, Object>> getVideosByCreatorId(Integer id);
}
