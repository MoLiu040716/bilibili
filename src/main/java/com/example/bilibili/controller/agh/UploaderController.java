package com.example.bilibili.controller.agh;

import com.example.bilibili.entity.Upload;
import com.example.bilibili.service.agh.UploaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/UploaderController")
public class UploaderController {
    @Autowired
    private UploaderService uploaderService;

    @GetMapping("/getAllUploaders")
    public List<Object> getAllUploaders(){
        List<Object> result = new ArrayList<>();
        List<Upload> uploaderList = uploaderService.getAllUploaders();

        // 遍历up主列表，将用户ID和用户名添加到结果Map中
        for (Upload uploader : uploaderList) {
            Map<String, Object> oneUploader = new HashMap<>();
            int uploaderId = uploader.getId();
            String uploaderName = uploader.getUserName();
            oneUploader.put("uploaderId", uploaderId);
            oneUploader.put("uploaderName", uploaderName);
            result.add(oneUploader);
        }

        return result;
    }
}
