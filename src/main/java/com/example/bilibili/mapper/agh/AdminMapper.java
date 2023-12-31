package com.example.bilibili.mapper.agh;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.sql.Timestamp;

@Mapper
public interface AdminMapper {
    @Update("UPDATE report SET manager_id = #{ManagerId}, remark = #{remark}, result = #{result} WHERE id = #{ReportId}")
    public int examineReportByReportIdAndManagerId(Integer ManagerId, Integer ReportId, String remark, Integer result);

    @Update("UPDATE user set account_status = 0, recovery_time = #{recoveryTime} where id = #{userId}")
    public int freezeUser(String userId, Timestamp recoveryTime);

    @Update("UPDATE upload set account_status = 0, recovery_time = #{recoveryTime} where id = #{uploaderId}")
    public int freezeUploader(String uploaderId, Timestamp recoveryTime);

    @Update("UPDATE user set password = #{newPassword} where id = #{userId}")
    public int resetPassword(Integer userId, String newPassword);
}
