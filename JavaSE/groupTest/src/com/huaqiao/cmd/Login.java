package com.huaqiao.cmd;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JPanel {
	private JFrame jf;
	private JButton jb1;
	private JButton jb2;
	private JTextField jt1;
	private JPasswordField jt2;
	private JLabel jl1;
	private JLabel jl2;
	private JLabel title;
	String text1;
	String text2;
	String text3;

	public Login() {
		// 设置画板
		jf = new JFrame();
		jf.setTitle("登录界面");
		jf.setSize(640, 500);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);

		// 设置画纸空布局
		this.setLayout(null);

		// 设置两个按钮三个标签和了两个文本框
		jb1 = new JButton();
		jb2 = new JButton();
		jl1 = new JLabel("账号:");
		jl2 = new JLabel("密码:");
		title = new JLabel("欢迎来到图书管理系统！");
		jt1 = new JTextField();
		jt2 = new JPasswordField();
		jb1.setText("登录");
		jb2.setText("注册");
		jb1.setSize(60, 45);
		jb2.setSize(60, 45);
		jb1.setLocation(220, 300);
		jb2.setLocation(380, 300);
		jl1.setBounds(200, 120, 60, 40);
		jl2.setBounds(200, 190, 60, 40);
		title.setBounds(250, 50, 200, 40);
		title.setFont(new Font("宋体", Font.PLAIN, 16));
		jt1 = new JTextField();
		jt1.setBounds(240, 120, 200, 40);
		jt2 = new JPasswordField();
		jt2.setBounds(240, 190, 200, 40);
		this.add(jb1);
		this.add(jb2);
		this.add(jl1);
		this.add(jl2);
		this.add(title);
		this.add(jt1);
		this.add(jt2);
		jf.add(this);

		// 画板设置可见放最后
		jf.setVisible(true);
	}
// ----------------------监听事件---------------------------------
	public void addListener() {
		MouseAdapter mouseadapter = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// 获取事件源
				JButton source1 = (JButton) e.getSource();
				text1 = source1.getText();
				text2 = jt1.getText();
				text3 = jt2.getText();
				String code = text3;
				if (text1.equals("登录")) {
					int userid = 0;
					
					try {
						 userid = Integer.parseInt(text2);
						 User user = Util.login(userid, code);					
							if (user == null) {
								// 弹窗提示信息
								JOptionPane.showMessageDialog(null, "用户名或密码有误");
								jt1.setText("");
								jt2.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "登陆成功");
								jf.setVisible(false);
								if ("管理员".equals(user.getType()))
									new OderScreen(user);
								else if ("用户".equals(user.getType())) 
									new UserScreen(user);
							}
					}catch(NumberFormatException e1) {
						JOptionPane.showMessageDialog(null, "输入不合法,账号必须是数字");
					}
				} else if (text1.equals("注册")) {// 注册按钮被点击了
					//1.让登录框消失(设置不可见)
					jf.setVisible(false);
					//2.弹出注册框、
					new Register();
				}
			}
		};
		// 为事件源添加监听器
		jb1.addMouseListener(mouseadapter);
		jb2.addMouseListener(mouseadapter);
	}

	public static void main(String[] args) {
		Login panel = new Login();
		panel.addListener();
	}
}
