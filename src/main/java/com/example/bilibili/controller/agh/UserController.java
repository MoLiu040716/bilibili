package com.example.bilibili.controller.agh;

import com.example.bilibili.entity.User;
import com.example.bilibili.service.agh.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/UserController")
public class UserController {
    @GetMapping("/userLogin")
    public Map<String, Object> userLogin(String name, String password,
                                         @RequestParam(defaultValue = "false") boolean rememberMe) {
        Map<String, Object> result = new HashMap<>();

        // 1获取subject对象
        Subject subject = SecurityUtils.getSubject();
        // 2封装请求对象到token
        AuthenticationToken token = new UsernamePasswordToken(name, password, rememberMe);
        // 3调用subject的Login方法进行登录认证
        try {
            subject.login(token);
            Object principal = subject.getPrincipal();
            if (principal != null) {
                if (principal instanceof User) {
                    User user = (User) principal;
                    int userId = user.getId();
                    String user_name = user.getUserName();

                    // 封装用户信息到Map
                    result.put("userId", userId);
                    result.put("username", user_name);
                    return result;
                }
            }
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败");
            result.put("error", "用户名或密码错误");
            return result;
        }
        result.put("error", "发生错误");
        return result;
    }

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<Map<String, Object>> getAllUsers(){
        List<Map<String, Object>> result = new ArrayList<>();
        List<User> userList = userService.getAllUsers();

        // 遍历用户列表，将用户ID和用户名添加到结果Map中
        for (User user : userList) {
            Map<String, Object> oneUser = new HashMap<>();
            int userId = user.getId();
            String user_name = user.getUserName();
            oneUser.put("userId", userId);
            oneUser.put("username", user_name);
            result.add(oneUser);
        }

        return result;
    }
}
