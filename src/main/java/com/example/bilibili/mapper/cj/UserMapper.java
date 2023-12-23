package com.example.bilibili.mapper.cj;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bilibili.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
    User selectByUserNameAndPassword(String userName, String Password);

    @Override
    int insert(User user);
}
