package com.example.bilibili.mapper.cj;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bilibili.entity.Favorite;
import com.example.bilibili.entity.Resource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Date;
import java.util.List;

@Mapper
public interface FavoriteMapper extends BaseMapper<Favorite> {

    int insert(Favorite collectionFolder);

    @Select("SELECT * FROM resource WHERE(" +
            "SELECT resource_id FROM favorite WHERE id = #{id})")
    List<Resource> selectResourceById(int id);

    void update(Favorite collectionFolder);

    @Select("SELECT * FROM WHERE create_time = #{create_time}")
    Favorite selectByTime(@Param("create_time") Date createTime);

    void delete(int id);
}
