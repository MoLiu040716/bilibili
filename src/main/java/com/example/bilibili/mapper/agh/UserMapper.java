package com.example.bilibili.mapper.agh;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bilibili.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
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
    public String getUserRoleInfo(@Param("principal") String principal);

    @Select("SELECT name FROM authorization WHERE id IN (" +
            "SELECT authorization_id FROM role_authorization WHERE role_id IN (" +
            "SELECT id FROM role WHERE role.name = #{role}))")
    public List<String> getUserPermissionInfo(String role);

    @Select("SELECT * FROM user WHERE user_name=#{userName}")
    User selectUserByUserName(@Param("userName") String userName);

    @Select("SELECT * FROM user WHERE email=#{email}")
    User selectUserByEmail(@Param("email") String email);

    @Select("SELECT * FROM user WHERE phone=#{phone}")
    User selectUserPhone(@Param("phone") String phone);

    @Override
    int insert(User user);


    @Update("UPDATE  user SET profile_photo = #{profile_photo} WHERE id = #{id}")
    int updateAvatar(
            @Param("id") int id,
            @Param("profile_photo") String profile_photo
    );


    @Update("UPDATE user SET user_name=#{user_name}, email=#{email}, phone=#{phone}, birthday=#{birthday}, sex=#{sex} WHERE id=#{id}")
    int updateUserInfo(
            @Param("id") int id,
            @Param("email") String email,
            @Param("user_name") String user_name,
            @Param("phone") String phone,
            @Param("birthday") String birthday,
            @Param("sex") int sex
    );

}
