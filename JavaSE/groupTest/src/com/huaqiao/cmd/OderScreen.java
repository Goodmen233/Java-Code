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

public class OderScreen extends JPanel {

	private JFrame jf;
	private JButton checkHis;
	private JButton adminUpdate;
	private JButton reLogin;
	private JLabel tips1;
	private JLabel tips2;
	private User user;

	public OderScreen(User user) {
		// 设置画板
		this.user = user;
		jf = new JFrame();
		jf.setTitle("图书管理界面");
		jf.setSize(400, 500);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);

		// 设置画纸空布局
		this.setLayout(null);
		// 设置两个按钮三个标签和了两个文本框
		checkHis = new JButton();
		adminUpdate = new JButton();
		reLogin = new JButton();
		tips1 = new JLabel("管理员" + this.user.getName() + "您好");
		tips2 = new JLabel("欢迎来到图书管理界面");
		checkHis.setText("查询借阅历史");
		adminUpdate.setText("修改用户/图书信息");
		reLogin.setText("退出登录");
		//设置按钮大小
		checkHis.setSize(180, 45);
		adminUpdate.setSize(180, 45);
		reLogin.setSize(180, 45);
		//设置四个按钮位置
		checkHis.setLocation(100, 200);
		adminUpdate.setLocation(100, 275);
		reLogin.setLocation(100, 350);
		tips1.setBounds(100, 50, 300, 40);
		tips2.setBounds(100, 100, 300, 40);
		this.add(checkHis);
		this.add(adminUpdate);
		this.add(reLogin);
		this.add(tips1);
		this.add(tips2);
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
				
				if (text.equals("查询借阅历史")) {
					// 进入查询历史界面
					new CheckHistory(user);
				}else if (text.equals("修改用户/图书信息")) {
					// 进入修改界面
					new AdminUpdate(user);
				}else if (text.equals("退出登录")) {
					// 当前窗口消失，回到登录界面
					jf.setVisible(false);
					new Login().addListener();
				}
			}
		};
		// 为事件源添加监听器
		checkHis.addMouseListener(mouseadapter);
		adminUpdate.addMouseListener(mouseadapter);
		reLogin.addMouseListener(mouseadapter);
	}
}
