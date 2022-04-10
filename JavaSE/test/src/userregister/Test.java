package userregister;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		UserService us = new UserService();
		Scanner s = new Scanner(System.in);
		System.out.println("请输入你要注册的用户名和密码：");
		System.out.print("用户名：");
		String username = s.next();
		System.out.print("密码：");
		String password = s.next();
		//只能输入一次
		try {
			us.register(username, password);
		} catch (RegisterException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
