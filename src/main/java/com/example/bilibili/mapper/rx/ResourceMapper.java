package com.example.bilibili.mapper.rx;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bilibili.entity.Resource;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;

@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {
    @Insert("INSERT INTO Resource (create_time, update_time, URL, " +
            "title, introduction, file_size, file_type, uploader_name,upload_id" +
            ",duration,bullet_comment_num,collection_num,like_num,view_count) " +
            "VALUES (#{CreatTime}, #{UpdateTime}, #{URL}," +
            " #{Title}, #{Introduction}, #{FileSize}, #{FileType}, " +
            "(SELECT user_name FROM upload WHERE id = #{uploaderID} ),#{uploaderID}," +
            "#{duration},0,0,0,0)")
    int uploadVideo(String CreatTime, String UpdateTime,String URL,
            String Title,String Introduction,Integer FileSize,
                    String FileType,Integer duration,
                    Integer uploaderID);

    @Select("SELECT * FROM resource WHERE id =#{id}")
    Resource selectById(int id);

}
