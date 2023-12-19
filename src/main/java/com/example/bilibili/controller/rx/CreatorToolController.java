package com.example.bilibili.controller.rx;

import java.util.List;
import java.util.Map;
import com.example.bilibili.service.rx.CreatorToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/CreatorToolController")
public class CreatorToolController {

    @Autowired
    private CreatorToolService creatorToolService;
    @GetMapping("/getAnalysisData")
    @ResponseBody
    public List<Map<String, Object>> getAnalysisDataById(@RequestParam Integer ID) {
        return creatorToolService.getAnalysisDataById(ID);
    }

}
