package com.li.myshops.fegin;

import com.li.myshops.config.FeignRequestInterceptor;
import com.li.myshops.entity.UmsAdmin;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author dell
 */
@FeignClient(value = "myshop-provider-biz",configuration = FeignRequestInterceptor.class)
public interface UmsAdminFegin {
    /**
     *根据用户名查询用户信息
     * @param name
     * @return
     */
    @GetMapping("/umsadmin/getUmsAdmin")
    UmsAdmin getByName(@RequestParam("name") String name);

    /**
     * 测试fegin接口
     * @return
     */
    @GetMapping("/umsadmin/test")
    String test();

}
