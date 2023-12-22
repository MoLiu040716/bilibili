package com.example.bilibili.mapper.rx;

import com.example.bilibili.entity.Resource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import java.util.Date;

@Mapper
public interface ResourceMapper {
    @Insert("INSERT INTO Resource (create_time, update_time, URL, " +
            "title, introduction, file_size, file_type, uploader_name" +
            ",duration,bullet_comment_num,collection_num,like_num,view_count) " +
            "VALUES (#{CreatTime}, #{UpdateTime}, #{URL}," +
            " #{Title}, #{Introduction}, #{FileSize}, #{FileType}, " +
            "#{UploaderName},#{duration},0,0,0,0)")
    int uploadVideo(String CreatTime, String UpdateTime,String URL,
            String Title,String Introduction,Integer FileSize,
                    String FileType,String UploaderName,Integer duration,
                    Integer uploaderID);


    int updateUploaderID(Integer id);
}
