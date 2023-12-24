package com.example.bilibili.controller.rx;

import com.example.bilibili.entity.Advertiser;
import com.example.bilibili.entity.Email;
import com.example.bilibili.entity.Upload;
import com.example.bilibili.service.rx.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/EmailController")
@CrossOrigin
public class EmailController {
    @Autowired
    private EmailService emailService;

    @GetMapping("/getSendEmailsWithUploadId")
    @ResponseBody
    public List<Map<String,Object>> getSendEmailsWithUploadId(@RequestParam Integer UploadID){
        return emailService.getSendEmailsWithUploadId(UploadID);
    }
    @GetMapping("/getReceiveEmailsWithUploadId")
    @ResponseBody
    public List<Map<String,Object>> getReceiveEmailsWithUploadId(@RequestParam Integer UploadID){
        return emailService.getReceiveEmailsWithUploadId(UploadID);
    }
    @GetMapping("/getSendEmailsWithAdvertiserId")
    @ResponseBody
    public List<Map<String,Object>> getSendEmailsWithAdvertiserId(@RequestParam Integer AdvertiseID){
        return emailService.getSendEmailsWithAdvertiserId(AdvertiseID);
    }
    @GetMapping("/getReceiveEmailsWithAdvertiserId")
    @ResponseBody
    public List<Map<String,Object>> getReceiveEmailsWithAdvertiserId(@RequestParam Integer AdvertiseID){
        return emailService.getReceiveEmailsWithAdvertiserId(AdvertiseID);
    }
    @GetMapping("/sendEmailWithUploadId")
    @ResponseBody
    public String sendEmailWithUploadId(@RequestParam String Title,
                                     @RequestParam String Content,
                                     @RequestParam Integer UploadID,
                                     @RequestParam Integer AdvertiserID){
        Date currentTime=new Date();
        int result = emailService.sendEmailWithUploadId(Content,currentTime,0,Title,AdvertiserID,UploadID);
        if(result>=1){
            return "发送成功";
        }else {
            return "发送失败";
        }
    }
    @GetMapping("/sendEmailWithAdvertiserId")
    @ResponseBody
    public String sendEmailWithAdvertiserId(@RequestParam String Title,
                                        @RequestParam String Content,
                                        @RequestParam Integer UploadID,
                                        @RequestParam Integer AdvertiserID){
        Date currentTime=new Date();
        int result = emailService.sendEmailWithUploadId(Content,currentTime,1,Title,AdvertiserID,UploadID);
        if(result>=1){
            return "发送成功";
        }else {
            return "发送失败";
        }
    }

}
