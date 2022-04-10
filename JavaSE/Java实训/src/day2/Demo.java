package day2;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
	// 存储账户信息
	static ArrayList<BankUser> userList = new ArrayList<BankUser>();
	// 记录当前登录成功的账户
	static BankUser usingAccount;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		init();
		while(true) {
			System.out.println("--------------------------------------");
			if(usingAccount == null) {
				System.out.println("欢饮使用xx银行系统");
			}else {
				System.out.println("欢迎" +  usingAccount.getAccount() + "使用xx银行系统");
			}				
			System.out.println("1.登录 2.用户信息查询 3.用户信息修改 4.查询余额");
			System.out.println("5.实现转账 6.取钱 7.存钱 8.注册 9.退出");
			System.out.print("请输入需要功能对应的数字：");
			int num = sc.nextInt();
			// 匹配数字
			switch (num) {
			case 1 : login(); break;
			case 2 :showMessege(); break;
			case 3 :alterMessege(); break;
			case 4 :showMoney(); break;
			case 5 :transferBills(); break;
			case 6 :getMoney(); break;
			case 7 :setMoney(); break;
			case 8 :register(); break;
			case 9 :exit(); break;
			default: System.out.println("输入不合法！重新输入！");
			}
		}
	}
	
	// 初始化银行账户对象
	public static void init() {
		userList.add(0, new BankUser("123", "132695", 21, "123", 1000));
		userList.add(1, new BankUser("456", "456123", 58, "456", 1000));
	}
	
	// 1.登录
	public static void login() {
		while(true) {
			System.out.print("请输入账号：");
			String account = sc.next();
			// 依次比较判断账号是否存在
			for(int i = 0; i < userList.size(); i++) {
				// 如果账号存在
				if(userList.get(i).getAccount().equals(account)) {
					do {
						//让用户输入密码
						System.out.print("请输入该账号的密码：");
						String password = sc.next();
						if(userList.get(i).getPassword().equals(password)) {
							System.out.println("登录成功！");
							usingAccount = userList.get(i);
							return;
						}else {
							System.out.println("密码错误，请重新输入！");
							System.out.print("退出更改请按1，重新输入随机输入：");
							int num = sc.nextInt();
							if(num == 1) return;
							else  continue;
						}
					}while(true);
				}
			}
			// 如果账号不存在
			System.out.println("账号不存在，请退出注册或重新输入！");
			System.out.print("退出注册请按1，重新输入请随机输入：");
			int num = sc.nextInt();
			if(num == 1) return;
			else  continue;
		}
	}
	
	// 2.查询用户信息
	public static void showMessege(){
		if(usingAccount != null) {
			System.out.println(usingAccount);
		}else {
			System.out.println("请先登录！");
		}
	}
	
	// 3.用户信息修改
	public static void alterMessege() {
		if(usingAccount != null) {
			System.out.println("请输入要修改的账户信息(目前只能修改年龄和密码和电话)：");
			System.out.println("修改年龄输入age,修改密码请输入password，修改电话输入tel");
			String s = sc.next();
			if("age".equals(s)) {
				System.out.print("请输入要修改的年龄：");
				int age = sc.nextInt();
				usingAccount.setAge(age);
				System.out.println("修改成功！");
			}else if("password".equals(s)) {
				System.out.print("请输入修改后的密码：");
				String password = sc.next();
				usingAccount.setPassword(password);
				System.out.println("修改成功！");
			}else if("tel".equals(s)) {
				System.out.println("请输入修改后的电话：");
				String tel = sc.next();
				usingAccount.setTel(tel);
				System.out.println("修改成功！");
			}else {
				System.out.println("输入不合法，修改失败");
			}	
		}else {
			System.out.println("请先登录！");
		}
	}
	
	// 4.查询余额
	public static void showMoney() {
		if(usingAccount != null) {
			System.out.println("当前账户的余额为：" + usingAccount.getMoney() + "元");
		}else {
			System.out.println("请先登录！");
		}
	}
	
	// 5.转账
	public static void transferBills() {
		if(usingAccount != null) {
			System.out.print("请输入要转账的账号(仅限在本银行的账号)：");
			String account = sc.next();
			// 查看输入的账号是否存在
			for(int i = 0; i < userList.size(); i++) {
				// 账号存在
				if(account.equals(userList.get(i).getAccount())) {
					System.out.print("输入要转账的数目：");
					int money = sc.nextInt();
					// 转的钱小于余额
					if(money < usingAccount.getMoney()) {
						usingAccount.setMoney(usingAccount.getMoney() - money);
						userList.get(i).setMoney(userList.get(i).getMoney() + money);
						System.out.println("转账成功！");
					}else System.out.println("余额不足，转账失败！");
						
				}
			}
			// 如果没有索引到账号。。
			//...
		}else {
			System.out.println("请先登录！");
		}
	}
	
	// 6.实现取钱
	public static void getMoney() {
		if(usingAccount != null) {
			System.out.print("请输入要取的钱：");
			int money = sc.nextInt();
			if(money < usingAccount.getMoney()) {
				usingAccount.setMoney(usingAccount.getMoney() - money);
				System.out.println("取钱成功！");
			}else 
				System.out.println("余额不足，取钱失败");
		}else {
			System.out.println("请先登录！");
		}
	}
	
	// 7.实现存钱
	public static void setMoney() {
		if(usingAccount != null) {
			System.out.print("请输入要存的钱：");
			int money = sc.nextInt();
			usingAccount.setMoney(usingAccount.getMoney() + money);
			System.out.println("存钱成功！");
		}else {
			System.out.println("请先登录！");
		}
	}
	
	// 8.注册
	public static void register() {
		while(true) {
			System.out.print("请输入注册的账号：");
			String account = sc.next();
			boolean isRepeat = false;
			// 依次比较判断账号是否存在
			for(int i = 0; i < userList.size(); i++) {
				// 如果账号存在
				if(userList.get(i).getAccount().equals(account)) {
					System.out.println("账号已存在，请重新输入一个账号");
					isRepeat = true;
					break;
				}
			}
			// 如果账号不是重复的，实现注册
			if(!isRepeat) {
				System.out.print("请设定该账号的密码：");
				String password = sc.next();
				userList.add(new BankUser(account, password));
				System.out.println("账号密码注册成功，其余信息登录后自行完善！");
				return;
			}
		}
	}
	
	// 9.退出
	public static void exit() {
		if(usingAccount != null) {
			System.out.println("退出成功！");
			usingAccount = null;
		}else {
			System.out.println("请先登录！");
		}
	}
	
	
	
	
}
