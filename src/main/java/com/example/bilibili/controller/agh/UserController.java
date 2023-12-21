package com.example.bilibili.controller.agh;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/UserController")
public class UserController {
    @GetMapping("/userLogin")
    public String userLogin(String name, String password,
                            @RequestParam(defaultValue = "false")boolean rememberMe){
        // 1获取subject对象
        Subject subject = SecurityUtils.getSubject();
        // 2封装请求对象到token
        AuthenticationToken token = new UsernamePasswordToken(name, password, rememberMe);
        // 3调用subject的Login方法进行登录认证
        try {
            subject.login(token);
            return "登录成功";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("登录失败");
            return "用户名或密码错误";
        }
    }
}
