package com.example.bilibili.controller.agh;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.bilibili.entity.User;
import com.example.bilibili.service.agh.UserService;
import com.example.bilibili.util.CommonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
    public String updatePassword(String username, String oldPassword, String newPassword) {
        int result = userService.updatePassword(username, oldPassword, newPassword);
        if (result == 1) {
            return "密码更新成功";
        } else if (result == 0) {
            return "密码更新失败";
        } else {
            return "发生错误！";
        }
    }

    @RequiresPermissions("HD")
    @RequestMapping("ideoHD")
    public String videoHD() {
        try {
            return "您享有高清版本视频观看权限";
        } catch (UnauthorizedException e) {
            throw e; // 交给全局异常处理器处理
        }
    }

    @RequiresPermissions("Ad free")
    @RequestMapping("/AdFree")
    public String AdFree() {
        try {
            return "您享有免广告权限";
        } catch (UnauthorizedException e) {
            throw e; // 交给全局异常处理器处理
        }
    }

    @RequiresPermissions("color")
    @RequestMapping("/commentColor")
    public String commentColor() {
        try {
            return "您享有评论弹幕颜色配置权限";
        } catch (UnauthorizedException e) {
            throw e; // 交给全局异常处理器处理
        }
    }

    @RequestMapping("/register")
    public CommonResult<String> register(@RequestParam String phone,
                                         @RequestParam String email,
                                         @RequestParam String userName,
                                         @RequestParam String password) {
        boolean success = userService.register(phone, email, password, userName);

        if (success) {
            return CommonResult.success("注册成功");
        } else {
            return CommonResult.error("注册失败");
        }
    }

    @RequestMapping("/changeAvatar")
    public CommonResult<String> upload(@RequestParam("id") int id,
                                       @RequestParam("file") MultipartFile photo) {

        // 判断文件是否为空
        if (photo.isEmpty()) {
            return CommonResult.error("上传失败，请选择文件");
        }
        byte[] imageArr;
        try {
            imageArr = photo.getBytes();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String imageAsString = Base64.getEncoder().encodeToString(imageArr);
        userService.updateAvatarById(id, imageAsString);
        return CommonResult.success("上传成功");
    }

    @GetMapping("/getAvatar")
    public String getAvtar(@RequestParam Integer id) {
        boolean success =  userService.getAvatarById(id);
        if (success) {
            User user = userService.getUserById(id);
            return user.getProfilePhoto();
        } else {
            return "获取失败";
        }
    }

    @GetMapping("/edit")
    public CommonResult<String> editUser(
            @RequestParam int id,
            @RequestParam String email,
            @RequestParam String userName,
            @RequestParam String phone,
            @RequestParam Date birthday,
            @RequestParam int sex) {
        User existingUser = userService.getUserById(id);
        if (existingUser == null) {
            return CommonResult.error("用户信息不存在");
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String birthdayFormat = simpleDateFormat.format(birthday);
        if (userService.updateUserInfoById(id, email, userName, phone, birthdayFormat, sex)) {
            return CommonResult.success("修改成功");
        } else {
            return CommonResult.error("修改失败");
        }
    }


}
