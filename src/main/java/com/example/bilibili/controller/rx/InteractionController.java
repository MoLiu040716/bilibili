package com.example.bilibili.controller.rx;

import com.example.bilibili.DTO.CommentAndReplyDTO;
import com.example.bilibili.mapper.rx.InteractionMapper;
import com.example.bilibili.service.rx.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/InteractionController")
public class InteractionController {
    @Autowired
    private InteractionService interactionService;

    @RequestMapping("/getCommentsAndRepliesByResourceId")
    @ResponseBody
    public List<CommentAndReplyDTO> getCommentsAndRepliesByResourceId(Integer id){
        return interactionService.getCommentsAndRepliesByResourceId(id);
    }

}
