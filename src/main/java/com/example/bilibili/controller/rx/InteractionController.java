package com.example.bilibili.controller.rx;

import com.example.bilibili.service.rx.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/InteractionController")
@CrossOrigin
public class InteractionController {
    @Autowired
    private InteractionService interactionService;
    @RequestMapping("/commentByResourseAndUserId")
    @ResponseBody
    public int commentByResourseAndUserId(Integer resourceID, Integer userID, String comment){
        return interactionService.commentByResourseAndUserId(resourceID,userID,comment);
    }
    @RequestMapping("/getCommentsAndRepliesByResourceId")
    @ResponseBody
    public List<Map<String, Object>> getCommentsAndRepliesByResourceId(Integer id){
        return interactionService.getCommentsAndRepliesByResourceId(id);
    }

    //    回复评论
    @RequestMapping("/replyForCommentByUserId")
    @ResponseBody
    public String replyForCommentByUserId(@RequestParam Integer commentID,
                                          @RequestParam Integer userID,
                                          @RequestParam String reply){
        int result = interactionService.replyForCommentByUserId(commentID,userID,reply);
        if(result==1){
            return "回复发布成功";
        }else{
            return "回复发布失败";
        }
    }

    //    回复回复
    @RequestMapping("/replyForReplyByUserId")
    @ResponseBody
    public String replyForReplyByUserId(@RequestParam Integer replyID,
                                        @RequestParam Integer userID,
                                        @RequestParam String reply){
        int result = interactionService.replyForReplyByUserId(replyID,userID,reply);
        if(result==1){
            return "回复成功";
        }else{
            return "回复失败";
        }
    }

    //    点赞评论
    @RequestMapping("/addLikeForComment")
    @ResponseBody
    public String addLikeForComment(@RequestParam Integer id){
        int result = interactionService.addLikeForComment(id);
        if(result>=1){
            return "succeed";
        }else{
            return "fail";
        }
    }

    //    点赞回复
    @RequestMapping("/addLikeForReply")
    @ResponseBody
    public String addLikeForReply(@RequestParam Integer id){
        int result = interactionService.addLikeForReply(id);
        if(result>=1){
            return "succeed";
        }else{
            return "fail";
        }
    }

}
