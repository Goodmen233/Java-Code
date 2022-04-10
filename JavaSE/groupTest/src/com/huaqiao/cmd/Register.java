package com.huaqiao.cmd;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Register extends JPanel {
	JButton register;
	JButton cancel;
	JButton back;
	JTextField userid;
	JTextField password;
	JTextField name;
	JTextField tel;
	JTextField sex;
	JLabel idTip;
	JLabel passTip;
	JLabel welTip;
	JLabel nameTip;
	JLabel telTip;
	JLabel sexTip;
	JFrame jframe;

	public Register() {
		jframe = new JFrame("学生注册界面");
		register = new JButton("注册");
		cancel = new JButton("取消");
		back = new JButton("返回");
		idTip = new JLabel("用户账号");
		passTip = new JLabel("密码");
		welTip = new JLabel("欢迎注册");
		nameTip = new JLabel("学生姓名");
		telTip = new JLabel("电话号码");
		sexTip = new JLabel("性别");
		userid = new JTextField();
		password = new JTextField();
		name = new JTextField();
		tel = new JTextField();
		sex = new JTextField();
		this.setLayout(null);
		register.setBounds(150, 260, 80, 30);
		cancel.setBounds(250, 260, 80, 30);
		back.setBounds(50, 260, 80, 30);
		idTip.setBounds(20, 100, 100, 40);
		passTip.setBounds(20, 130, 100, 40);
		welTip.setBounds(130, 40, 300, 40);
		nameTip.setBounds(20, 162, 300, 40);
		telTip.setBounds(20, 190, 300, 40);
		sexTip.setBounds(20, 220, 300, 40);
		userid.setBounds(100, 110, 100, 20);
		password.setBounds(100, 140, 100, 20);
		name.setBounds(100, 170, 100, 20);
		tel.setBounds(100, 200, 100, 20);
		sex.setBounds(100, 230, 100, 20);
		this.add(register);
		this.add(cancel);
		this.add(back);
		this.add(idTip);
		this.add(passTip);
		this.add(welTip);
		this.add(nameTip);
		this.add(telTip);
		this.add(sexTip);
		this.add(userid);
		this.add(password);
		this.add(name);
		this.add(tel);
		this.add(sex);
		this.addListener();
		welTip.setFont(new Font("微软雅黑", Font.ITALIC, 30));
		jframe.add(this);
		jframe.setSize(400, 500);
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jframe.setVisible(true);
	}
	
// ------------------------------添加监听-----------------------------------
	public void addListener() {
		MouseAdapter mouseadapter = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 如果点击注册按钮
				if (((JButton) e.getSource()).getText().equals("注册")) {
					// 获得输入框内容
					String str1 = userid.getText();
					String str2 = password.getText();
					String str3 = name.getText();
					String str4 = tel.getText();
					String str5 = sex.getText();

					// 如果用戶输入内容不为空,判断是否注册成功（" ",""不一样，文本框为空是"",表示" ".）
					if (!str1.equals("") && !str2.equals("") && !str3.equals("") 
							&& !str4.equals("")&& !str5.equals("")){
						// 用户的性别必须是男或者女
						if("男".equals(str5) || "女".equals(str5)) {	
							int id = 0;
							try {
								id = Integer.parseInt(str1);
								// 判断注册是否成功的标记
								boolean isSucc = Util.register(id, str2, str3, str4, str5);
								// 注册成功
								if(isSucc) {
									userid.setText("");
									password.setText("");
									name.setText("");
									tel.setText("");
									sex.setText("");
									JOptionPane.showMessageDialog(null, "注册成功");
								}else JOptionPane.showMessageDialog(null, "账号重复，请重新输入");
							} catch (Exception e2) {
								JOptionPane.showMessageDialog(null, "注册的账号必须是数字");
								userid.setText("");
							}
						// 注册失败
						}else {
							JOptionPane.showMessageDialog(null, "用户性别只能是男或女，请重新输入");
						}
					// 如果用戶输入内容有的为空，提示
					} else {
						JOptionPane.showMessageDialog(null, "请填写完所有信息");
					}
				}
				
				
				// 返回按钮当前注册界面消失，弹窗登录界面
				if (((JButton) e.getSource()).getText().equals("返回")) {
					jframe.setVisible(false);
					Login login = new Login();
					login.addListener();
				}
				
				
				
				// 关闭程序
				if (((JButton) e.getSource()).getText().equals("取消")) {
					System.exit(0);
				}
				
			}
		};
		register.addMouseListener(mouseadapter);
		cancel.addMouseListener(mouseadapter);
		back.addMouseListener(mouseadapter);
	}
}
