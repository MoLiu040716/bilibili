package com.example.bilibili.controller.rx;

import java.util.List;
import java.util.Map;

import com.example.bilibili.entity.TakeAdvertise;
import com.example.bilibili.service.rx.CreatorToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/CreatorToolController")
@CrossOrigin
public class CreatorToolController {

    @Autowired
    private CreatorToolService creatorToolService;
    @GetMapping("/getAnalysisData")
    @ResponseBody
    public List<Map<String, Object>> getAnalysisDataById(@RequestParam Integer ID) {
        return creatorToolService.getAnalysisDataById(ID);
    }
    @GetMapping("/takeAdvertise")
    @ResponseBody
    public int takeAdvertise(@RequestParam Integer UploadID,
                             @RequestParam Integer PositionID){
        TakeAdvertise tk=new TakeAdvertise();
        int get_progress=creatorToolService.getProgress(PositionID);
        creatorToolService.takeAdvertise(tk,UploadID,PositionID,get_progress);
        return tk.getId();
    }
    @GetMapping("/setAdvertise")
    @ResponseBody
    public List<Map<String,Object>> setAdvertise(@RequestParam Integer TakeAdId){
        return creatorToolService.setAdvertise(TakeAdId);
    }

    @GetMapping("/getAdConversionRate")
    @ResponseBody
    public Double getAdConversionRate(@RequestParam Integer TakeAdId){
        return creatorToolService.getAdConversionRate(TakeAdId);
    }

    @GetMapping("/getAllAds")
    @ResponseBody
    public List<Map<String,Object>> getAllAds(Integer UploadID){
        return creatorToolService.getAllAds(UploadID);
    }
}
