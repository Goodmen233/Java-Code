package test2;

import java.awt.Component;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.MouseInputAdapter;

public class Dneme {
	private static JButton jb1=new JButton();
	private static JButton jb2=new JButton();
	private static JTextField jt=new JTextField();
	JPanel jp = new JPanel();
	private Timer timer=new Timer();
	private Random random=new Random();
	String[] a={"貓","狗","豬","牛"};

	

	// 設置適配器
	public void addlistener() {
		MouseAdapter mouseadapter = new MouseAdapter() {
			// 点击两下停不了
			public void mouseClicked(MouseEvent e) {
				 JButton source=(JButton)e.getSource();
		    	 String text=source.getText();
				if ("開始點名".equals(text)) {
					timer = new Timer();
					TimerTask task = new TimerTask() {
						public void run() {
							// TODO
							int t=random.nextInt(a.length);
							jt.setText(a[t]);
						}
					};
					timer.schedule(task, 100, 100);
				} else {
					timer.cancel();
				}
			}
		};
		//安裝監聽器
		jb1.addMouseListener(mouseadapter);
		jb2.addMouseListener(mouseadapter);
	}

	public static void main(String[] args) {
		JFrame jf = new JFrame();
		jf.setTitle("點名游戲");
		jf.setSize(625, 400);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setResizable(false);
		Dneme d=new Dneme();
		d.jp.setLayout(null);
		d.jb1 = new JButton("開始點名");
		d.jb2 = new JButton("停止");
		d.jb1.setFont(new Font("微软雅黑", Font.BOLD, 10));// 设置按钮的字体粗细和大小
		d.jb2.setFont(new Font("微软雅黑", Font.BOLD, 10));// 设置按钮的字体粗细和大小
		d.jb1.setBounds(300, 300, 100, 50);// 設置按钮大小和位置
		d.jb2.setBounds(400, 300, 60, 50);// 設置按钮大小和位置
		d.jt.setBounds(200,100,200,100);//設置文本框位置
		d.jp.add(jb1);
		d.jp.add(jb2);
		d.jp.add(jt);
		jf.add(d.jp);
		d.addlistener();
		jf.setVisible(true);

	}
}
