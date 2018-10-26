package com.chengli.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    Logger logger = LoggerFactory.getLogger(LoginController.class);

    @RequestMapping("/")
    public String index() {
        return "访问了首页哦";
    }

    @RequestMapping("/login")
    public String login(String ticket, HttpSession session){
        System.out.println("ticket:::"+ticket);
        return "";
    }

    @RequestMapping("/getLogin")
    public String getLogin(HttpSession session){

        logger.debug("登录成功==="+session.getId());
        return "登录成功";}

    @PreAuthorize("hasAuthority('TEST')")
    @RequestMapping("/logout")
    public String getLogout(HttpSession session){
        logger.debug("登出成功==="+session.getId());
        return "登出成功";
    }

    @PreAuthorize("hasAuthority('TEST1')")
    @RequestMapping("/hello")
    public String hello() {
        return "不验证哦";
    }

    @PreAuthorize("hasAuthority('TEST')")//有TEST权限的才能访问
    @RequestMapping("/security")
    public String security() {
        return "hello world security";
    }

    @PreAuthorize("hasAuthority('ADMIN')")//必须要有ADMIN权限的才能访问
    @RequestMapping("/authorize")
    public String authorize() {
        return "有权限访问";
    }

    /**这里注意的是，TEST与ADMIN只是权限编码，可以自己定义一套规则，根据实际情况即可*/

}
