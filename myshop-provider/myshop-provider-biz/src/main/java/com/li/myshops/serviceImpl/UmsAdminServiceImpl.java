package com.li.myshops.serviceImpl;

import com.li.myshops.entity.UmsAdmin;
import com.li.myshops.mapper.UmsAdminMapper;
import com.li.myshops.service.UmsAdminService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;

@Service
public class UmsAdminServiceImpl implements UmsAdminService {
    @Resource
    private UmsAdminMapper umsAdminMapper;
    @Resource
    private BCryptPasswordEncoder passwordEncoder;
    @Override
    public Integer insert(UmsAdmin umsAdmin) {
        umsAdmin.setPassword(passwordEncoder.encode(umsAdmin.getPassword()));
        return umsAdminMapper.insert(umsAdmin);
    }

    @Override
    public UmsAdmin get(String name) {
        //tkmybatis的条件构造器
        Example example = new Example(UmsAdmin.class);
        example.createCriteria().andEqualTo("username",name);
        return umsAdminMapper.selectOneByExample(example);
    }
}
