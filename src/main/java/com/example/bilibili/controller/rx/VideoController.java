package com.example.bilibili.controller.rx;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import com.example.bilibili.entity.Resource;

import com.example.bilibili.util.BusinessException;
import com.example.bilibili.util.CommonResult;
import com.example.bilibili.util.VideoOperation;
import jakarta.servlet.http.HttpServletResponse;
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
                       @RequestParam int age) {
        return "helloworld" + name + age;
    }

    @RequestMapping("/uploadVideo")
    public String uploadVideo(@RequestParam("file") MultipartFile file,
                              @RequestParam String title,
                              @RequestParam String description,
                              @RequestParam Integer creatorID) throws Exception {
        System.out.println(file.getClass());
        System.out.println(title);
        Resource video = new Resource();
        String path = "D:\\VIDEO";
        String fileName = file.getOriginalFilename();
        String URL = path + "\\" + fileName;
        String outputURL = path + "\\output\\" + fileName.substring(0, fileName.lastIndexOf(".")) + ".mp4";
        Time uploadTime = new Time(System.currentTimeMillis());
        Integer size = Math.toIntExact(file.getSize());//存储的视频最大为2GB！！！！！！

        video.setTitle(title);
        video.setCreatTime(uploadTime);
        video.setUpdateTime(uploadTime);
        video.setUrl(outputURL);
        video.setIntroduction(description);
        video.setFileSize(size);
        video.setFileType("mp4");


        File originalFile = new File(URL);
        file.transferTo(originalFile);


        VideoOperation.transcodeVideo(URL, outputURL);
        video.setDuration(VideoOperation.getVideoDuration(outputURL));
        int result = videoService.uploadVideo(video, creatorID);

        if (result > 0) {
            return "发布成功";
        } else {
            return "发布失败";
        }
    }

    @RequestMapping("/displayUrl")
    public String displayMp4(@RequestParam("upload_id") int id) {
        String filePath = videoService.getUrlById(id);
        if (filePath == null) {
            throw new BusinessException("文件不存在");
        }
        return filePath;
    }

    @RequestMapping("/listAll")
    public List<Resource> findAll(@RequestParam("upload_id") int id) {
        List<Resource> resourceList = videoService.findAll(id);
        if (resourceList == null) {
            throw new BusinessException("加载失败");
        } else {
            return resourceList;
        }
    }

}

