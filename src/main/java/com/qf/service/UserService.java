package com.qf.service;

import com.qf.pojo.User;
/**
 * 用户user的service接口
 * create by 郑大仙丶
 * 2019/7/15 15:06
 */
public interface UserService {

    // 根据用户名查询是否可用
    Integer checkUsername(String username);

    // 注册功能
    Integer register(User user);

    // 执行登录
    User login(String username, String password);
}
