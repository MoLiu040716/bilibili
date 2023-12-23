package com.example.bilibili.mapper.rx;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResourceMapper {
    @Insert("INSERT INTO Resource (create_time, update_time, URL, " +
            "title, introduction, file_size, file_type, uploader_name,upload_id" +
            ",duration,bullet_comment_num,collection_num,like_num,view_count) " +
            "VALUES (#{CreatTime}, #{UpdateTime}, #{URL}," +
            " #{Title}, #{Introduction}, #{FileSize}, #{FileType}, " +
            "(SELECT user_name FROM user WHERE id = #{uploaderID} ),#{uploaderID}," +
            "#{duration},0,0,0,0)")
    int uploadVideo(String CreatTime, String UpdateTime,String URL,
            String Title,String Introduction,Integer FileSize,
                    String FileType,String UploaderName,Integer duration,
                    Integer uploaderID);


    int updateUploaderID(Integer id);
}
