package com.example.bilibili.mapper.agh;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminMapper {
    @Update("UPDATE user SET password = #{newPassword} WHERE user_name = #{username} AND password = #{oldPassword}")
    public int updatePassword(String username, String oldPassword, String newPassword);

    @Update("UPDATE report SET manager_id = #{ManagerId}, remark = #{remark}, result = #{result} WHERE id = #{ReportId}")
    public int examineReportByReportIdAndManagerId(Integer ManagerId, Integer ReportId, String remark, Integer result);

}
