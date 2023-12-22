package com.example.bilibili.controller.rx;

import com.example.bilibili.entity.AdvertisingPosition;
import com.example.bilibili.service.rx.AdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/AdvertiseController")
@CrossOrigin
public class AdvertiseController {
    @Autowired
    private AdvertiseService advertiseService;

    @GetMapping("/uploadAdvertise")
    @ResponseBody
    public int uploadAdvertise(@RequestParam String Title,
                               @RequestParam String Introduction,
                               @RequestParam Date BeginTime,
                               @RequestParam Date EndTime,
                               @RequestParam Double Reward,
                               @RequestParam int Process,
                               @RequestParam Integer advertiser_ID){
        AdvertisingPosition advertise=new AdvertisingPosition();
        advertise.setTitle(Title);
        advertise.setIntroduction(Introduction);
        advertise.setBeginTime(BeginTime);
        advertise.setEndTime(EndTime);
        advertise.setReward(Reward);
        advertise.setProcess(Process);
        return advertiseService.uploadAdvertise(advertise,advertiser_ID);
    }
}
