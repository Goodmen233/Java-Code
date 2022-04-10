package day2;

import javax.swing.*;

public class BankJFrame extends JFrame {
	// 构造方法
	public BankJFrame() {
		// 需要的组件
		JPanel bankJPanel = new JPanel();
		JButton login = new JButton("登录");
		JButton showMessege= new JButton("用户信息查询");
		JButton alterMessege = new JButton("用户信息更改");
		JButton showMoney = new JButton("查询余额");
		JButton transferBills = new JButton("转账");
		JButton getMoney = new JButton("取钱");
		JButton setMoney = new JButton("存钱");
		JButton register = new JButton("注册");
		JButton exit = new JButton("退出登录");
		// 添加按钮
		
		// 实现按钮功能
		
		
		// 设置窗口属性
		this.setBounds(200, 200, 800, 800);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("欢迎使用xx银行");
	}
}
