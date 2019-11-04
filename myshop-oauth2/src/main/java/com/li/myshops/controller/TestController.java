package com.li.myshops.controller;

import com.li.myshops.entity.UmsAdmin;
import com.li.myshops.fegin.UmsAdminFegin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dell
 */
@RestController
public class TestController {

    @Resource
    private UmsAdminFegin umsAdminFegin;

    @GetMapping("/test")
    public UmsAdmin test(String username) {
        UmsAdmin lisi = umsAdminFegin.getByName("lisi");
        System.err.println(lisi.toString());
        return lisi;
    }

    @GetMapping("/testFegin")
    public String test() {
        String test = umsAdminFegin.test();
        return test;
    }

}
