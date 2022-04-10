package temp;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class WhoGame extends JFrame {
	// ���
	JPanel whoGame = new JPanel();
	JButton start = new JButton("��ʼ");
	JButton stop = new JButton("ֹͣ");
	JTextField show = new JTextField("default");
	String[] name = {"С��", "����", "����", "����", "С��"};
	Timer t = new Timer();
	Random r = new Random();
	boolean isStart = false;
	// ��ʼ����
	public WhoGame() {
		// ��Ӱ�ť
		whoGame.add(start);
		whoGame.add(show);
		whoGame.add(stop);
		whoGame.setLayout(null);
		start.setBounds(100, 100, 100, 50);
		show.setBounds(200, 100, 100, 50);
		stop.setBounds(300, 100, 100, 50);
		// ��ť��Ӽ���
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStart = true;
			}
		});
		stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isStart = false;
			}
		});
		// ��ʱ��ˢ��
		TimerTask tt = new TimerTask() {
			public void run() {
				if(isStart) {
					int i = r.nextInt(name.length);
					String usingName = name[i];
					show.setText(usingName);
				}
			}
			
		};
		t.schedule(tt, 1000, 100);
		// ���ô�������
		this.setTitle("������Ϸ");
		this.add(whoGame);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(200, 200, 600, 400);
		this.setResizable(false);
		this.setVisible(true);
	}
}
