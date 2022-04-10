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
	// ��¼����������������ӭ��¼��ǩ���û�����ǩ�������ǩ�������ı���������ť,һ�����
	JLabel welc = new JLabel("��ӭ�����޵а�ɻ���ս��¼����");
	JLabel user = new JLabel("�û���");
	JLabel pass = new JLabel("����");
	
	JTextField usertext = new JTextField();
	JPasswordField passtext = new JPasswordField();
	
	JButton login = new JButton("��¼");
	JButton cancel = new JButton("ȡ��");
	
	JPanel con = new JPanel();
	
	// ��¼���˺ź�����
	static String localUser = "123";
	static String localPass = "123";
	
	public Login() {
		// ����������ԣ�������
		con.setLayout(null);
		con.add(welc);
		con.add(user);
		con.add(pass);
		con.add(usertext);
		con.add(passtext);
		con.add(login);
		con.add(cancel);
		
		// ���ø������λ��
		welc.setBounds(200, 0, 200, 100);
		user.setBounds(50, 110, 100, 50);
		pass.setBounds(50, 250, 100, 50);
		usertext.setBounds(200, 110, 200, 50);
		passtext.setBounds(200, 250, 200, 50);
		login.setBounds(350, 350, 100, 50);
		cancel.setBounds(500, 350, 100, 50);
		
		// ����ť��Ӽ���
		login.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String usering = usertext.getText();
				String passing = passtext.getText();
				if(localUser.equals(usering) && localPass.equals(passing)) {
					// �˺�������ȷ��������Ϸ����
					PlaneGame planeGame = new PlaneGame();
				}else {
					// �˺Ż�������󣬵���������ʾ����
					WrongJDialog wrongJDialog = new WrongJDialog();
				}
			}
		});
		
		// ȡ����ť�˳�
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		// ��������
		this.setTitle("�ɻ���ս��¼����");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(200, 200, 600, 500);
		this.setResizable(false);
		this.add(con); 
		this.setVisible(true);
	} 
}
