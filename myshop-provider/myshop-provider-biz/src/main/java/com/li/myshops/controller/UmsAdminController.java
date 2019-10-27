package com.li.myshops.controller;

import com.li.myshop.commons.dto.ResponseResult;
import com.li.myshops.entity.UmsAdmin;
import com.li.myshops.service.UmsAdminService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户注册服务
 * @author dell
 */
@RestController
@RequestMapping("/umsadmin")
public class UmsAdminController {
    @Resource
    private UmsAdminService umsAdminService;

    /**
     * 添加用户
     * @param umsAdmin {@link UmsAdmin}
     * @return
     */
    @PostMapping("/addUmsAdmin")
    public ResponseResult insertUmsAdmin(@RequestBody UmsAdmin umsAdmin){
        Integer insert = umsAdminService.insert(umsAdmin);
        if (insert != null) {
            //inser>0 表示添加成功
            if(insert>0){
                return new ResponseResult(HttpStatus.OK.value(),"用户注册成功");
            }
        }
        return new ResponseResult(HttpStatus.NOT_ACCEPTABLE.value(),"用户注册失败");
    }

    @GetMapping("/getUmsAdmin")
    public UmsAdmin getByName(String name){
        UmsAdmin umsAdmin = umsAdminService.get(name);
        return umsAdmin;
    }
}
