package com.example.bilibili.config;

import com.example.bilibili.realm.MyRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.config.DefaultShiroFilterChainDefinition;
import org.apache.shiro.util.ThreadContext;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {
    @Autowired
    private MyRealm myRealm;

    // 配置SecurityManager
    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        // 1创建defaultWebSecurityManager对象
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        ThreadContext.bind(defaultWebSecurityManager);
        // 2创建加密对象，设置相关属性
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        // 2.1采用MD5加密
        matcher.setHashAlgorithmName("md5");
        // 2.2迭代加密的次数
        matcher.setHashIterations(3);
        // 3将加密对象存储到myRealm中
        myRealm.setCredentialsMatcher(matcher);
        // 4将myRealm存入defaultWebSecurityManager对象中
        defaultWebSecurityManager.setRealm(myRealm);
        // 4.1设置RememberMe
        defaultWebSecurityManager.setRememberMeManager(rememberMeManager());
        // 5返回
        return defaultWebSecurityManager;
    }

    // cookie属性设置
    public SimpleCookie rememberMeCookie(){
        SimpleCookie cookie = new SimpleCookie("rememberMe");
        // 设置跨域
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(30*24*60*60);
        return cookie;
    }

    // 创建Shiro的cookie管理对象
    public CookieRememberMeManager rememberMeManager(){
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // RememberMe 的 Cookie 通常是加密的，以确保安全性
        // setCipherKey 方法接受一个字节数组作为参数，这个字节数组就是用于加密和解密 RememberMe Cookie 的密钥
        cookieRememberMeManager.setCipherKey("175175".getBytes());
        return cookieRememberMeManager;
    }

    // 设置Shiro内置过滤器拦截范围
    @Bean
    public DefaultShiroFilterChainDefinition shiroFilterChainDefinition(){
        DefaultShiroFilterChainDefinition definition = new DefaultShiroFilterChainDefinition();
        // 1设置不认证可以访问的资源
        definition.addPathDefinition("/UserController/userLogin", "anon");
        // 设置登出过滤器
        definition.addPathDefinition("/logout", "logout");
        // 2设置需要进行登录认证的拦截范围
        definition.addPathDefinition("/**", "authc");
        // 3添加存在用户的过滤器（rememberMe）
        definition.addPathDefinition("/**", "user");
        return definition;
    }
}
