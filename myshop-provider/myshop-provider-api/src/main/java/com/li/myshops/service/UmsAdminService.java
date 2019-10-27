package com.li.myshops.service;

import com.li.myshops.entity.UmsAdmin;

public interface UmsAdminService {
    /**
     * 新增用户
     * @param umsAdmin
     * @return
     */
    Integer insert(UmsAdmin umsAdmin);

    /**
     * 根据用户名，获取用户信息
     * @param name
     * @return
     */
    UmsAdmin get(String name);
}
