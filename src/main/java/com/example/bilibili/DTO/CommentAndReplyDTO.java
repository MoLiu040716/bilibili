package com.example.bilibili.DTO;

public class CommentAndReplyDTO {
    private String commentContent;
    private int commentLikeNum;
    private String replyContent;
    private int replyLikeNum;

    public String getCommentContent() {
        return commentContent;
    }

    public int getCommentLikeNum() {
        return commentLikeNum;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public int getReplyLikeNum() {
        return replyLikeNum;
    }
}
