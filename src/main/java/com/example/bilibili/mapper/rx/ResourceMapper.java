package com.example.bilibili.mapper.rx;

import com.example.bilibili.entity.Resource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceMapper {
    @Insert("INSERT INTO Resource (id,CreatTime, UpdateTime, URL, Title, Introduction, FileSize, FileType, UploaderName) " +
            "VALUES (#{id},#{CreatTime}, #{UpdateTime}, #{URL}, #{Title}, #{Introduction}, #{FileSize}, #{FileType},  #{Duration}, #{UploaderName})")
    boolean uploadVideo(Resource video);

}
