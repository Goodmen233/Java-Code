package temp;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class LoginJFrame extends JFrame {
	// ��Ҫһ��panel,������ǩ�������ı�����������ť
	JLabel userName = new JLabel("�û���");
	JLabel password = new JLabel("����");
	JLabel welcome = new JLabel("��ӭʹ��");
	JTextField user = new JTextField();
	JTextField passw = new JTextField();
	JButton login = new JButton("��¼");
	JButton register = new JButton("ע��");
	JPanel j = new JPanel();
	
	public LoginJFrame() {
		// ������
		this.add(j);
		j.setSize(400, 300);
		j.add(welcome);
		j.add(userName);
		j.add(password);
		j.add(user);
		j.add(passw);
		j.add(login);
		j.add(register);
		j.setLayout(null);
		welcome.setBounds(150, 10, 200, 10);
		userName.setBounds(50, 50, 50, 10);
		password.setBounds(50, 100, 50, 10);
		user.setBounds(100, 50, 200, 20);
		passw.setBounds(100, 100, 200, 20);
		//		login.setBounds(200, 200, 100, 100);
		login.setBounds(300, 150, 100, 100);
		register.setBounds(500, 150, 100, 100);
		// ��������ʱ��ʼ����
		this.setTitle("��¼");
		this.setBounds(100, 100, 700, 300);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		this.setLayout(manager);
	}
	
	
}
