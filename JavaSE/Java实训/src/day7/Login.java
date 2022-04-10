package day7;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import util.GokJDBCUtil;

public class Login extends JFrame {
	Player usingPlayer = null;
	// 登录界面所需的组件，欢迎登录标签，用户名标签，密码标签，两个文本框，两个按钮,一个面板
	JLabel welc = new JLabel("欢迎来到无敌版飞机大战登录界面");
	JLabel user = new JLabel("用户名");
	JLabel pass = new JLabel("密码");
	
	JTextField usertext = new JTextField();
	JPasswordField passtext = new JPasswordField();
	
	JButton login = new JButton("登录");
	JButton register = new JButton("注册");
	
	JPanel con = new JPanel();
	
	// 登录的账号和密码
	static String localUser = "123";
	static String localPass = "123";
	
	public Login() {
		// 设置面板属性，添加组件
		con.setLayout(null);
		con.add(welc);
		con.add(user);
		con.add(pass);
		con.add(usertext);
		con.add(passtext);
		con.add(login);
		con.add(register);
		
		// 设置各组件的位置
		welc.setBounds(200, 0, 200, 100);
		user.setBounds(50, 110, 100, 50);
		pass.setBounds(50, 250, 100, 50);
		usertext.setBounds(200, 110, 200, 50);
		passtext.setBounds(200, 250, 200, 50);
		login.setBounds(350, 350, 100, 50);
		register.setBounds(500, 350, 100, 50);
		
		// 登录按钮
		login.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String name = usertext.getText();
				String password = passtext.getText();
				String sql = "select * from user where name=? and password=?";
				usingPlayer = GokJDBCUtil.queryForObject(sql, Player.class, name, password);
				if(usingPlayer != null) {
					new LoginJDialog(true);
				}else {
					new LoginJDialog(false);
				}
			}
		});
		
		// 注册按钮
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = usertext.getText();
				String password = passtext.getText();
				String sql = "select * from user where name=?";
				usingPlayer = GokJDBCUtil.queryForObject(sql, Player.class, name);
				if(usingPlayer == null) {
					// 用户名没有重复，可以注册
					
				}else {
					
				}
			}
		});
		// 设置属性
		this.setTitle("飞机大战登录界面");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(200, 200, 600, 500);
		this.setResizable(false);
		this.add(con);
		this.setVisible(true);
	}
}
