package com.ccb.services;

import com.ccb.entity.User;

public interface UserServices {
    public void register(User user);
    public User login(User user);
    public boolean isExitUser(String username);
}
