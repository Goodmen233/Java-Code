package com.ccb.test;

import com.ccb.entity.User;
import com.ccb.services.UserServices;
import com.ccb.services.impl.UserServicesImpl;
import org.junit.Test;

public class UserServicesTest {
    @Test
    public void test(){
        UserServices userServices = new UserServicesImpl();
        User user = new User(1, "zhangsan", "333", "zhangsan@qq.com");
        System.out.println(userServices.login(user));
    }
}
