package com.example.bilibili.mapper.agh;

import com.example.bilibili.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where user_name=#{name}")
    public User getUserInfoByName(String name);

    @Select("SELECT * FROM user order by id")
    public List<User> getAllUsers();

    @Update("UPDATE user SET account_status = 1, recovery_time = null WHERE id = #{id}")
    public int updateUserStatus(Integer id);

    @Update("UPDATE user SET password = #{newPassword} WHERE user_name = #{username} AND password = #{oldPassword}")
    public int updatePassword(String username, String oldPassword, String newPassword);

    @Select("SELECT name FROM role WHERE id IN (" +
            "SELECT role_id FROM role_association WHERE target_type = 0 AND targetid IN (" +
            "SELECT id FROM user WHERE user_name = #{principal}))")
    public String getUserRoleInfo(@Param("principal")String principal);

    @Select("SELECT name FROM authorization WHERE id IN (" +
            "SELECT authorization_id FROM role_authorization WHERE role_id IN (" +
            "SELECT id FROM role WHERE role.name = #{role}))")
    public List<String> getUserPermissionInfo(String role);
}
