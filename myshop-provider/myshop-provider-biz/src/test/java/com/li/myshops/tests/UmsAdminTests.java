package com.li.myshops.tests;
import java.lang.reflect.Executable;
import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.li.myshops.entity.UmsAdmin;
import com.li.myshops.entity.UmsPermission;
import com.li.myshops.mapper.UmsAdminMapper;
import com.li.myshops.mapper.UmsPermissionMapper;
import com.li.myshops.service.UmsAdminService;
import lombok.val;
import netscape.javascript.JSObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UmsAdminTests {
    @Resource
    private UmsAdminMapper umsAdminMapper;
    @Resource
    private UmsAdminService umsAdminService;
    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private UmsPermissionMapper umsPermissionMapper;


    @Test
    public void test(){
        List<UmsAdmin> umsAdmins = umsAdminMapper.selectAll();
        umsAdmins.forEach(e->{
            System.out.println(e.getEmail());
        });
    }

    @Test
    public void testInsert(){
        UmsAdmin umsAdmin = new UmsAdmin();
        umsAdmin.setUsername("李艳明");
        umsAdmin.setPassword(bCryptPasswordEncoder.encode("123456"));
        umsAdmin.setIcon("");
        umsAdmin.setEmail("");
        umsAdmin.setNickName("");
        umsAdmin.setNote("");
        umsAdmin.setCreateTime(new Date());
        umsAdmin.setLoginTime(new Date());
        umsAdmin.setStatus(0);

        int insert = umsAdminService.insert(umsAdmin);
        Assert.assertEquals(insert,1);
    }

    @Test
    public void testGetName(){
        UmsAdmin zhangsan = umsAdminService.get("zhangsan");
        System.out.println(zhangsan);
    }

    @Test
    public void test1(){
        List<UmsPermission> umsPermissions = umsPermissionMapper.selectAll();
        System.out.println(JSONObject.toJSON(testChild(umsPermissions, Long.valueOf(0))));
    }
    public List<UmsPermission> testChild(List<UmsPermission> umsPermissions,Long pid){
        List<UmsPermission> collect = umsPermissions.stream().filter(e -> e.getPid().equals(pid)).collect(Collectors.toList());
        if (!collect.isEmpty()) {
            collect.forEach(e->{
                e.setChild(testChild(umsPermissions,e.getId()));
            });
        }

        return collect;
    }
}
