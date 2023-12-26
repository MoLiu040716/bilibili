package com.example.bilibili.service.cj;


import com.example.bilibili.entity.Resource;

import java.util.List;

public interface FavouriteService {

    boolean addFavourite(int resourceId, int collectionId);
    List<Resource> listALL(int id);

}
