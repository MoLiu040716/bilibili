package com.example.bilibili.service.rx.impl;

import com.example.bilibili.DTO.CommentAndReplyDTO;
import com.example.bilibili.mapper.rx.InteractionMapper;
import com.example.bilibili.service.rx.InteractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InteractionServiceImpl implements InteractionService {

    @Autowired
    private InteractionMapper interactionMapper;
    @Override
    public List<CommentAndReplyDTO> getCommentsAndRepliesByResourceId(Integer id){
        return interactionMapper.getCommentsAndRepliesByResourceId(id);
    }

}