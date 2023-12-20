package com.example.bilibili.controller.rx;

import com.example.bilibili.service.rx.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/InteractionController")
public class InteractionController {
    @Autowired
    private InteractionService interactionService;

    // 查询某个资源下的所有评论及回复信息
    @RequestMapping("/getCommentsAndRepliesByResourceId")
    @ResponseBody
    public List<Map<String, Object>>  getCommentsAndRepliesByResourceId(@RequestParam Integer id){
        return interactionService.getCommentsAndRepliesByResourceId(id);
    }
//    public List<CommentAndReplyDTO> getCommentsAndRepliesByResourceId(Integer id){
//        return interactionService.getCommentsAndRepliesByResourceId(id);
//    }

    @RequestMapping("/commentByResourseAndUserId")
    @ResponseBody
    public String commentByResourseAndUserId(@RequestParam Integer resourceID,
                                             @RequestParam Integer userID,
                                             @RequestParam String comment){
        int result = interactionService.commentByResourseAndUserId(resourceID,userID,comment);
        if(result==1){
            return "评论发布成功";
        }else{
            return "评论发布失败";
        }
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
