package com.example.bilibili.controller.rx;

import com.example.bilibili.entity.Advertiser;
import com.example.bilibili.entity.AdvertisingPosition;
import com.example.bilibili.service.rx.AdvertiseService;
import com.example.bilibili.util.TimeTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

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
                               @RequestParam String BeginTime,
                               @RequestParam String EndTime,
                               @RequestParam Double Reward,
                               @RequestParam Integer advertiser_ID) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        AdvertisingPosition advertise=new AdvertisingPosition();
        advertise.setTitle(Title);
        advertise.setIntroduction(Introduction);
        Date bgTime=dateFormat.parse(BeginTime);
        Date edTime=dateFormat.parse(EndTime);;
        advertise.setBeginTime(bgTime) ;
        advertise.setEndTime(edTime);
        advertise.setReward(Reward);
        advertise.setProcess(TimeTools.getActivityProcess(BeginTime,EndTime));

        Advertiser advertiser=new Advertiser();
        advertiser.setId(advertiser_ID);
        advertise.setAdvertiser(advertiser);

        return advertiseService.uploadAdvertise(advertise);
    }

    @GetMapping("/getAdvertiseForUploaders")
    @ResponseBody
    public List<Map<String, Object>> getAdvertiseForUploaders(){
        return advertiseService.getAdvertise();
    }
    @GetMapping("/clickAdvertise")
    @ResponseBody
    public int clickAdvertise(@RequestParam Integer UserID,
                              @RequestParam Integer TakeAdvertiseID) {
        Date ClickTime=new Date();
        return advertiseService.clickAdvertise(UserID,TakeAdvertiseID,ClickTime);
    }
    @GetMapping("/closeAdvertise")
    @ResponseBody
    public int closeAdvertise(@RequestParam Integer ClickID){
        return advertiseService.closeAdvertise(ClickID);
    }
    @GetMapping("/getAllImpressionData")
    @ResponseBody
    public List<Map<String,Object>> getAllImpressionData(@RequestParam Integer AdPositionId){
        return advertiseService.getAllImpressionData(AdPositionId);
    }
}
