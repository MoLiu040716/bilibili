package com.example.bilibili.mapper.agh;

import com.example.bilibili.entity.Upload;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UploaderMapper {
    @Select("SELECT * FROM upload order by id")
    public List<Upload> getAllUploaders();

    @Update("UPDATE upload SET account_status = 1, recovery_time = null WHERE id = #{id}")
    public int updateUploaderStatus(Integer id);
}
