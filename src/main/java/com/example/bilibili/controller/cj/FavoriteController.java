package com.example.bilibili.controller.cj;

import com.example.bilibili.entity.Resource;
import com.example.bilibili.service.cj.Impl.FavoriteServiceImpl;
import com.example.bilibili.util.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/FavoriteController")
@CrossOrigin
public class FavoriteController {

    @Autowired
    FavoriteServiceImpl favoriteService;

    @RequestMapping("/favorite")
    public List<Resource> getFavorite(@RequestParam("id") int id) {
        List<Resource> resourceList = favoriteService.listALL(id);
        if (favoriteService.listALL(id) == null) {
            return null;
        } else
            return resourceList;
    }

    @RequestMapping("/addFavorite")
    public CommonResult<String> addFavorite(@RequestParam("resource_id")int resourceId,
                                            @RequestParam("collection_id")int collectionId){
        if (favoriteService.addFavourite(resourceId,collectionId)){
            return CommonResult.success("收藏成功");
        }else {
            return CommonResult.error("收藏失败");
        }
    }


}
