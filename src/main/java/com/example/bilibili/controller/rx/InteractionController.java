package com.example.bilibili.controller.rx;

import com.example.bilibili.filter.BadWordsFilter;
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
    public String commentByResourseAndUserId(@RequestParam Integer resourceID,
                                             @RequestParam Integer userID,
                                             @RequestParam String comment){
        // 使用过滤类进行评论过滤
        String filteredComment = BadWordsFilter.filterComment(comment);

        int result = interactionService.commentByResourseAndUserId(resourceID,userID,filteredComment);
        if(result==1){
            return "评论发布成功";
        }else{
            return "评论发布失败";
        }
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
        // 使用过滤类进行评论过滤
        String filteredReply = BadWordsFilter.filterComment(reply);

        int result = interactionService.replyForCommentByUserId(commentID,userID,filteredReply);
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
        // 使用过滤类进行评论过滤
        String filteredReplyForReply = BadWordsFilter.filterComment(reply);

        int result = interactionService.replyForReplyByUserId(replyID,userID,filteredReplyForReply);
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
