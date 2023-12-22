package com.example.bilibili.controller.rx;

import java.io.File;
import java.sql.Time;

import com.example.bilibili.entity.Resource;
import com.example.bilibili.util.VideoOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.bilibili.service.rx.VideoService;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/VideoController")
@CrossOrigin
public class VideoController {

    @Autowired
    private VideoService videoService;

    @RequestMapping("/test")
    @ResponseBody
    public String test(@RequestParam String name,
                       @RequestParam int age){
        return "helloworld"+name+age;
    }

    @RequestMapping("/uploadVideo")
    public boolean uploadVideo(@RequestParam("file") MultipartFile file,
                               @RequestParam String title,
                               @RequestParam String description,
                               @RequestParam Integer creatorID,
                               @RequestParam String creatorName) throws Exception{
        System.out.println(file.getClass());
        System.out.println(title);
        Resource video=new Resource();
        String path="E:\\VIDEO";
        String fileName = file.getOriginalFilename();
        String URL=path + "\\" +fileName;
        Time uploadTime=new Time(System.currentTimeMillis());
        Integer size= Math.toIntExact(file.getSize());//存储的视频最大为2GB！！！！！！

        video.setTitle(title);
        video.setCreatTime(uploadTime);
        video.setUpdateTime(uploadTime);
        video.setURL(URL);
        video.setIntroduction(description);
        video.setFileSize(size);
//        video.setCreatorID(creatorID);
        video.setUploaderName(creatorName);
        video.setFileType("mp4");

        File originalFile = new File(URL);
        file.transferTo(originalFile);
        VideoOperation.transcodeVideo(URL, URL);

        return videoService.uploadVideo(video);
    }
}
