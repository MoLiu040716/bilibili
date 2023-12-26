package com.example.bilibili.controller.agh;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.bilibili.entity.User;
import com.example.bilibili.service.agh.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/UserController")
@CrossOrigin
public class UserController {
    @GetMapping("/userLogin")
    public Map<String, Object> userLogin(String name, String password) {
        Map<String, Object> result = new HashMap<>();

        // 1获取subject对象
        Subject subject = SecurityUtils.getSubject();
        // 2封装请求对象到token
        AuthenticationToken token = new UsernamePasswordToken(name, password);
        // 3调用subject的Login方法进行登录认证
        try {
            subject.login(token);
            Object principal = subject.getPrincipal();
            if (principal != null) {
                if (principal instanceof User) {
                    User user = (User) principal;
                    int userId = user.getId();
                    String user_name = user.getUserName();
                    // 在这里生成JWT Token
                    String jwtToken = generateJwtToken(name);

                    // 封装用户信息到Map
                    result.put("userId", userId);
                    result.put("username", user_name);
                    result.put("token", jwtToken);
                    System.out.println(subject.isAuthenticated());
                    System.out.println(subject.getPrincipal());
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

    private String generateJwtToken(String username) {
        Algorithm algorithm = Algorithm.HMAC256("175175"); // 替换为你的实际密钥
        String jwtToken = JWT.create()
                .withSubject(username)
                .withExpiresAt(new Date(System.currentTimeMillis() + 3600000)) // 设置过期时间，这里设置为1小时
                .sign(algorithm);

        return jwtToken;
    }

    @Autowired
    private UserService userService;

    @GetMapping("/getAllUsers")
    public List<Object> getAllUsers() {
        List<Object> result = new ArrayList<>();
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

    @GetMapping("/updatePassword")
    public String updatePassword(String username, String oldPassword, String newPassword){
        int result = userService.updatePassword(username, oldPassword, newPassword);
        if (result == 1){
            return "密码更新成功";
        } else if (result == 0){
            return "密码更新失败";
        } else {
            return "发生错误！";
        }
    }

    @RequiresPermissions("HD")
    @RequestMapping("/videoHD")
    public String videoHD() {
        // 检查用户是否已经登录
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            return "请先登录";
        }
        try {
            // 检查是否有 "HD" 权限
            SecurityUtils.getSubject().checkPermission("HD");

            // 用户已登录并且有权限
            return "您享有高清版本视频观看权限";
        } catch (UnauthorizedException e) {
            throw e; // 交给全局异常处理器处理
        }
    }

    @RequiresPermissions("Ad free")
    @RequestMapping("/AdFree")
    public String AdFree() {
        // 检查用户是否已经登录
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            return "请先登录";
        }
        try {
            // 检查是否有 "HD" 权限
            SecurityUtils.getSubject().checkPermission("Ad free");

            // 用户已登录并且有权限
            return "您享有免广告权限";
        } catch (UnauthorizedException e) {
            throw e; // 交给全局异常处理器处理
        }
    }

    @RequiresPermissions("color")
    @RequestMapping("/commentColor")
    public String commentColor() {
        // 检查用户是否已经登录
        if (!SecurityUtils.getSubject().isAuthenticated()) {
            return "请先登录";
        }
        try {
            // 检查是否有 "HD" 权限
            SecurityUtils.getSubject().checkPermission("color");

            // 用户已登录并且有权限
            return "您享有评论弹幕颜色配置权限";
        } catch (UnauthorizedException e) {
            throw e; // 交给全局异常处理器处理
        }
    }

}
