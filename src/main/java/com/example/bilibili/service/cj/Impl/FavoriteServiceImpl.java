package com.example.bilibili.service.cj.Impl;

import com.example.bilibili.entity.Favorite;
import com.example.bilibili.entity.Resource;
import com.example.bilibili.mapper.cj.FavoriteMapper;
import com.example.bilibili.service.cj.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FavoriteServiceImpl implements FavouriteService {

    @Autowired
    private FavoriteMapper favoriteMapper;

    @Override
    public boolean addFavourite(int resourceId, int collection) {
        Favorite favorite = new Favorite();
        favorite.setCreatTime(new Date());
        if (favoriteMapper.selectByTime(favorite.getCreatTime()) == null) {
            return true;
        } else {
            return favoriteMapper.insert(favorite) > 0;
        }
    }

    @Override
    public List<Resource> listALL(int id) {
        List<Resource> resourceList = favoriteMapper.selectResourceById(id);
        if (resourceList == null) {
            return null;
        } else {
            return resourceList;
        }
    }
}
