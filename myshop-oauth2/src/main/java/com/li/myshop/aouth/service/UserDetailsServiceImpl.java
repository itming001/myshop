package com.li.myshop.aouth.service;

import com.google.common.collect.Lists;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 此注解用于注入此方法类
 * @author liyanming
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //此集合为权限集合
        List<GrantedAuthority> grantedAuthorities= Lists.newArrayList();
        GrantedAuthority user = new SimpleGrantedAuthority("USER");
        grantedAuthorities.add(user);
        /**
         * 用户名
         * 密码
         * 权限集合
         */
        return new User("liyanming","$2a$10$v1pHUMX6nxXsC1TJYer1l.MJE54csu0V1OFBL3NAkMsr2wr6UtNH6",grantedAuthorities);
    }
}
