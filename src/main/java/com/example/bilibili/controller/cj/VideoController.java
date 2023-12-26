//package com.example.bilibili.controller.cj;
//
//import com.example.bilibili.service.rx.impl.VideoServiceImpl;
//import com.example.bilibili.util.CommonResult;
//import org.apache.ibatis.annotations.Param;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStream;
//
//@RestController
//@RequestMapping("/video")
//@CrossOrigin
//
//public class VideoController {
//    @Autowired
//    VideoServiceImpl videoService;
//
//    @GetMapping("/display")
//    public CommonResult<String> displayMp4(HttpServletResponse response,@Param("id") int id) throws Exception {
//        String fileName = videoService.getUrlById(id);
//        File file = new File( fileName + ".mp4");
//        if (!file.exists()) {
//            return CommonResult.error("文件不存在");
//        }
//        InputStream inStream = new FileInputStream(file);
//        byte[] buffer = new byte[1024];
//        int len;
//        while ((len = inStream.read(buffer)) != -1) {
//            response.getOutputStream().write(buffer, 0, len);
//        }
//        inStream.close();
//        response.getOutputStream().flush();
//        response.getOutputStream().close();
//        return CommonResult.success("success");
//    }
//}
