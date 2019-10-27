package com.li.myshop.aouth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dell
 */
@RestController
public class TestController {
   @GetMapping("/test")
   public String test(){
       return "这是我写的第一个SpringSecurity程序，实现单点登录";
   }
}
