package com.example.bilibili.service.rx;

import com.example.bilibili.DTO.CommentAndReplyDTO;

import java.util.List;

public interface InteractionService {
    public List<CommentAndReplyDTO> getCommentsAndRepliesByResourceId(Integer id);
}
