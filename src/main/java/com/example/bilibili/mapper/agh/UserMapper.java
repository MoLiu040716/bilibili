package com.example.bilibili.mapper.agh;

import com.example.bilibili.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name=#{name}")
    public User getUserInfoByName(String name);
}
