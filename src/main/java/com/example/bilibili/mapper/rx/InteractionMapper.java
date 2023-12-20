package com.example.bilibili.mapper.rx;

import com.example.bilibili.DTO.CommentAndReplyDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface InteractionMapper {

    // 查询某个资源下的所有评论及回复信息
    @Select("SELECT c.Content AS commentContent, c.LikeNum AS commentLikeNum, " +
            "r.Content AS replyContent, r.LikeNum AS replyLikeNum " +
            "FROM Comment c " +
            "LEFT JOIN Reply r ON c.id = r.comment_id " +
            "WHERE c.resource_id = #{id}")
    List<CommentAndReplyDTO> getCommentsAndRepliesByResourceId(Integer id);

}
