package com.example.bilibili.service.rx.impl;

import com.example.bilibili.mapper.rx.InteractionMapper;
import com.example.bilibili.service.rx.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Autowired
    private InteractionMapper interactionMapper;
    @Override
    public List<Map<String, Object>> getCommentsAndRepliesByResourceId(Integer id) {
        List<Map<String, Object>> comments = interactionMapper.getCommentsByResourceId(id);
        List<Map<String, Object>> replies = interactionMapper.getRepliesByResourceId(id);

        List<Map<String, Object>> result = new ArrayList<>();

        for (Map<String, Object> comment : comments) {
            Map<String, Object> commentAndReplies = new HashMap<>();
            Integer commentId = (Integer) comment.get("commentId");
            commentAndReplies.put("Type","comment");
            commentAndReplies.put("commentID", commentId);
            commentAndReplies.put("commentContent", comment.get("commentContent"));
            commentAndReplies.put("commentLikeNum", comment.get("commentLikeNum"));
//            commentAndReplies.put("replyID", comment.get("replyID"));
//            commentAndReplies.put("replyType", comment.get("replyType"));

            // Add comment to the result
            result.add(commentAndReplies);

            // Add corresponding replies to the result
            for (Map<String, Object> reply : replies) {
                Integer parentCommentId = (Integer) reply.get("parentCommentId");
                if (parentCommentId != null && parentCommentId.equals(commentId)) {
                    Map<String, Object> replyObject = new HashMap<>();
                    replyObject.put("Type", "reply");
                    replyObject.put("replyID", reply.get("replyID"));
                    replyObject.put("replyContent", reply.get("replyContent"));
                    replyObject.put("replyLikeNum", reply.get("replyLikeNum"));
                    replyObject.put("replyID", reply.get("replyID"));
                    replyObject.put("replyType", reply.get("replyType"));

                    // Add reply to the result
                    result.add(replyObject);
                }
            }
        }

        return result;
    }

//    @Override
//    public List<Map<String, Object>> getCommentsAndRepliesByResourceId(Integer id){
//        return interactionMapper.getRepliesByResourceId(id);
//    }
    public int commentByResourseAndUserId(Integer resourceID, Integer userID, String comment){
        return interactionMapper.commentByResourseAndUserId(resourceID,userID,comment);
    }

    public int replyForCommentByUserId(Integer commentID, Integer userID, String reply){
        return interactionMapper.replyForCommentByUserId(commentID,userID,reply);
    }
    public int replyForReplyByUserId(Integer replyID, Integer userID, String reply){
        interactionMapper.setCommentId(replyID);
        return interactionMapper.replyForReplyByUserId(replyID,userID,reply);
    }
    public int addLikeForComment(Integer id){
        return interactionMapper.addLikeForComment(id);
    }

    public int addLikeForReply(Integer id){
        return interactionMapper.addLikeForReply(id);
    }
}