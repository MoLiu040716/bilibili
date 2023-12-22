package com.example.bilibili.mapper.rx;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface InteractionMapper {

    @Select("SELECT " +
            "    r.content AS replyContent, " +
            "    r.like_num AS replyLikeNum, " +
            "    r.comment_id AS parentCommentId, " +
            "    r.id AS replyId, " +
            "    r.parent_id AS parentId, " +
            "    COALESCE(r.parent_id, c.id) AS replyID, " +
            "    CASE " +
            "        WHEN r.parent_id IS NULL THEN 'Comment' " +
            "        ELSE 'Reply' " +
            "    END AS replyType " +
            "FROM Comment c " +
            "LEFT JOIN Reply r ON c.id = r.comment_id " +
            "WHERE c.resource_id = #{id}")
    List<Map<String, Object>> getRepliesByResourceId(Integer id);

    @Select("SELECT " +
            "c.content AS commentContent, " +
            "c.like_num AS commentLikeNum, " +
            "c.id AS commentId " +
            "FROM Comment c " +
            "WHERE c.resource_id = #{id}")
    List<Map<String, Object>> getCommentsByResourceId(Integer id);

    @Insert("INSERT INTO comment (content, user_id, resource_id,like_num,reply_num, user_name)" +
            "VALUES (#{comment}, #{userID}, #{resourceID} ,0,0,(SELECT user_name FROM user WHERE id = #{userID} LIMIT 1))")
    int commentByResourseAndUserId(Integer resourceID, Integer userID, String comment);

    @Insert("INSERT INTO reply (content, user_id, comment_id,like_num, user_name)" +
            "VALUES (#{reply}, #{userID}, #{commentID} ,0,(SELECT user_name FROM user WHERE id = #{userID} LIMIT 1))")
    int replyForCommentByUserId(Integer commentID, Integer userID, String reply);


    @Update("SET @comment_id := (SELECT comment_id FROM reply WHERE id = #{replyID} LIMIT 1)")
    void setCommentId(Integer replyID);
    @Insert("INSERT INTO reply (content, user_id, like_num, parent_id, comment_id, user_name) " +
            "VALUES (#{reply}, #{userID}, 0, #{replyID}, @comment_id, " +
            "(SELECT user_name FROM user WHERE id = #{userID} LIMIT 1));")
    int replyForReplyByUserId(Integer replyID, Integer userID, String reply);
    @Update("UPDATE comment SET like_num = like_num + 1 WHERE id = #{id}")
    int addLikeForComment(Integer id);

    @Update("UPDATE reply SET like_num = like_num + 1 WHERE id = #{id}")
    int addLikeForReply(Integer id);
}
