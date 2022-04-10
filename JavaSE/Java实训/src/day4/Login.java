package day4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Login extends JFrame {
	// 登录界面所需的组件，欢迎登录标签，用户名标签，密码标签，两个文本框，两个按钮,一个面板
	JLabel welc = new JLabel("欢迎来到无敌版飞机大战登录界面");
	JLabel user = new JLabel("用户名");
	JLabel pass = new JLabel("密码");
	
	JTextField usertext = new JTextField();
	JPasswordField passtext = new JPasswordField();
	
	JButton login = new JButton("登录");
	JButton cancel = new JButton("取消");
	
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
		con.add(cancel);
		
		// 设置各组件的位置
		welc.setBounds(200, 0, 200, 100);
		user.setBounds(50, 110, 100, 50);
		pass.setBounds(50, 250, 100, 50);
		usertext.setBounds(200, 110, 200, 50);
		passtext.setBounds(200, 250, 200, 50);
		login.setBounds(350, 350, 100, 50);
		cancel.setBounds(500, 350, 100, 50);
		
		// 给按钮添加监听
		login.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String usering = usertext.getText();
				String passing = passtext.getText();
				if(localUser.equals(usering) && localPass.equals(passing)) {
					// 账号密码正确，进入游戏界面
					PlaneGame planeGame = new PlaneGame();
				}else {
					// 账号或密码错误，弹出错误提示窗口
					WrongJDialog wrongJDialog = new WrongJDialog();
				}
			}
		});
		
		// 取消按钮退出
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
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
