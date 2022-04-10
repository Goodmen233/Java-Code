package com.ccb.dao;

import com.ccb.entity.User;

public interface UserDao {
    /**
     * 查询用户名是否存在
     * @param username
     * @return
     */
    public User queryUser(String username);

    /**
     * 查询用户的登录信息是否正确
     * @param username
     * @param password
     * @return
     */
    public User queryUser(String username, String password);

    /**
     * 保存注册用户的信息
     * @param user
     * @return
     */
    public int saveUser(User user);
}
