package snake;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameChoise extends JFrame {
	//������Ҫ����������Ѷȣ������Ѷ�
	JButton easy = new JButton("��ģʽ");
	JButton hard = new JButton("����ģʽ");
	JButton help = new JButton("����");
	//���췽��
	public GameChoise() {
		//������ 
		this.add(easy);
		this.add(hard);
		this.add(help);
		//��Ӽ����¼�
		easy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame("easy");
			}
		});
		hard.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainFrame mf = new MainFrame("hard");
			}
		});
		help.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				HelpJDialog helpJDialog = new HelpJDialog();
				
			}
		});
		//��������
		setLocation(400, 200);
		setLayout(new GridLayout(3,1));
		setVisible(true);
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
