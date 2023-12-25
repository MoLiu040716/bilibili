package com.example.bilibili.controller.rx;

import java.io.File;
import java.sql.Time;

import com.example.bilibili.entity.Resource;
import com.example.bilibili.entity.Upload;
import com.example.bilibili.entity.User;
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

    @RequestMapping("uploadVideo")
    public String uploadVideo(@RequestParam("file") MultipartFile file,
                               @RequestParam String title,
                               @RequestParam String description,
                               @RequestParam Integer creatorID) throws Exception{
        System.out.println(file.getClass());
        System.out.println(title);
        Resource video=new Resource();
        String path="E:\\VIDEO";
        String fileName = file.getOriginalFilename();
        String URL=path + "\\" +fileName;
        String outputURL=path+"\\output\\"+fileName.substring(0, fileName.lastIndexOf("."))+".mp4";
        Time uploadTime=new Time(System.currentTimeMillis());
        Integer size= Math.toIntExact(file.getSize());//存储的视频最大为2GB！！！！！！

        video.setTitle(title);
        video.setCreatTime(uploadTime);
        video.setUpdateTime(uploadTime);
        video.setURL(outputURL);
        video.setIntroduction(description);
        video.setFileSize(size);
        video.setFileType("mp4");


        File originalFile = new File(URL);
        file.transferTo(originalFile);


        VideoOperation.transcodeVideo(URL, outputURL);
        video.setDuration(VideoOperation.getVideoDuration(outputURL));
        int result=videoService.uploadVideo(video,creatorID);

        if(result>0){
            return "发布成功";
        }else{
            return "发布失败";
        }
    }
}
