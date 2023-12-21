package com.example.bilibili.mapper.rx;

import com.example.bilibili.entity.Resource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceMapper {
    @Insert("INSERT INTO Resource (creat_time, update_time, URL, title, introduction, file_size, file_type, uploader_name) " +
            "VALUES (#{CreatTime}, #{UpdateTime}, #{URL}, #{Title}, #{Introduction}, #{FileSize}, #{FileType},  #{Duration}, #{UploaderName})")
    boolean uploadVideo(Resource video);

}
