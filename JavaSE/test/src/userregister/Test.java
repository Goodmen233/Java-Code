package userregister;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		UserService us = new UserService();
		Scanner s = new Scanner(System.in);
		System.out.println("��������Ҫע����û��������룺");
		System.out.print("�û�����");
		String username = s.next();
		System.out.print("���룺");
		String password = s.next();
		//ֻ������һ��
		try {
			us.register(username, password);
		} catch (RegisterException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
