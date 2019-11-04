package com.li.myshops.config;

import com.li.myshops.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author dell
 * @author liyanming
 */
@Configuration
@EnableWebSecurity
// 增加了资源服务器配置
@EnableResourceServer
/**
 * 创建全局的方法拦截
 */
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {


    /**
     * 创建密码加密
     * @return
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 返回刚才配置的userdetalis
     * @return
     */
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    /**
     * 配置用户的权限信息
     * 将上面配置的用户的UserDetailsService注入
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

    /**
     * 用于支持密码模式
     * @return
     * @throws Exception
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .and()
                //禁用session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                // 增加了授权访问配置
                .antMatchers("/**").hasAuthority("USER");
                //.antMatchers("/user/logout").hasAuthority("USER");
    }
}
