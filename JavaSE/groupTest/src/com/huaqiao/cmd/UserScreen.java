package com.huaqiao.cmd;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserScreen extends JPanel {

	private JFrame jf;
	private JButton lendB;
	private JButton returnB;
	private JButton reLogin;
	private JLabel jl1;
	private JLabel jl2;
	private User user;

	public UserScreen(User user) {
		// 设置画板
		this.user = user;
		jf = new JFrame();
		jf.setTitle("用户操作界面");
		jf.setSize(400, 625);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);

		// 设置画纸空布局
		this.setLayout(null);
		// 设置两个按钮三个标签和了两个文本框
		lendB = new JButton();
		returnB = new JButton();
		reLogin = new JButton();
		jl1 = new JLabel("用户" + this.user.getName() + "您好");
		jl2 = new JLabel("欢迎来到用户操作界面");
		lendB.setText("借书");
		returnB.setText("还书");
		reLogin.setText("退出登录");
		//设置三个按钮大小
		lendB.setSize(180, 45);
		returnB.setSize(180, 45);
		reLogin.setSize(180, 45);
		//设置三个按钮位置
		lendB.setLocation(100, 200);
		returnB.setLocation(100, 275);
		reLogin.setLocation(100, 350);
		jl1.setBounds(100, 50, 300, 40);
		jl2.setBounds(100, 100, 300, 40);
		this.add(lendB);
		this.add(returnB);
		this.add(reLogin);
		this.add(jl1);
		this.add(jl2);
		this.addListener();
		jf.add(this);

		// 画板设置可见放最后
		jf.setVisible(true);
	}

	public void addListener() {
//		安装适配器
		MouseAdapter mouseadapter = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 获取事件源
				JButton source = (JButton) e.getSource();
				String text = source.getText();
				
				if (text.equals("借书")) {
					// 跳转到借书界面
					new LendBookDemo(user);
				} else if (text.equals("还书")) {
					// 跳转到还书界面
					new ReturnBookDemo(user);
				}
				if (text.equals("退出登录")) {
					// 跳转到登录界面
					jf.setVisible(false);
					Login login = new Login();
					login.addListener();
				}
			}
		};
		// 为事件源添加监听器
		lendB.addMouseListener(mouseadapter);
		returnB.addMouseListener(mouseadapter);
		reLogin.addMouseListener(mouseadapter);
	}
}
