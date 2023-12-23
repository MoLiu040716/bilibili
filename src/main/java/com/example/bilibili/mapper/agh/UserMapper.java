package com.example.bilibili.mapper.agh;

import com.example.bilibili.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name=#{name}")
    public User getUserInfoByName(String name);

    @Select("SELECT * FROM user order by id")
    public List<User> getAllUsers();

    @Update("UPDATE user SET account_status = 1, recovery_time = null WHERE id = #{id}")
    public int updateUserStatus(Integer id);
}
