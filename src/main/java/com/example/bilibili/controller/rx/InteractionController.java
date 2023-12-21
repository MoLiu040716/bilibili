package com.example.bilibili.controller.rx;

import com.example.bilibili.service.rx.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/InteractionController")
@CrossOrigin
public class InteractionController {
    @Autowired
    private InteractionService interactionService;

    @RequestMapping("/getCommentsAndRepliesByResourceId")
    @ResponseBody
    public List<Map<String, Object>> getCommentsAndRepliesByResourceId(Integer id){
        return interactionService.getCommentsAndRepliesByResourceId(id);
    }

}
