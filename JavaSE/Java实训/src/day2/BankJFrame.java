package day2;

import javax.swing.*;

public class BankJFrame extends JFrame {
	// ���췽��
	public BankJFrame() {
		// ��Ҫ�����
		JPanel bankJPanel = new JPanel();
		JButton login = new JButton("��¼");
		JButton showMessege= new JButton("�û���Ϣ��ѯ");
		JButton alterMessege = new JButton("�û���Ϣ����");
		JButton showMoney = new JButton("��ѯ���");
		JButton transferBills = new JButton("ת��");
		JButton getMoney = new JButton("ȡǮ");
		JButton setMoney = new JButton("��Ǯ");
		JButton register = new JButton("ע��");
		JButton exit = new JButton("�˳���¼");
		// ��Ӱ�ť
		
		// ʵ�ְ�ť����
		
		
		// ���ô�������
		this.setBounds(200, 200, 800, 800);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setTitle("��ӭʹ��xx����");
	}
}
