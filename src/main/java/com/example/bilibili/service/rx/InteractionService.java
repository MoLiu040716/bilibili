package com.example.bilibili.service.rx;

import java.util.List;
import java.util.Map;

public interface InteractionService {
//    public List<CommentAndReplyDTO> getCommentsAndRepliesByResourceId(Integer id);
    public List<Map<String, Object>> getCommentsAndRepliesByResourceId(Integer id);
    public int commentByResourseAndUserId(Integer resourceID, Integer userID, String comment);
    public int replyForCommentByUserId(Integer commentID, Integer userID, String reply);
    public int replyForReplyByUserId(Integer replyID, Integer userID, String reply);
    public int addLikeForComment(Integer id);
    public int addLikeForReply(Integer id);

}
