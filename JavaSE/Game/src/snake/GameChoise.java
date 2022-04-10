package snake;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameChoise extends JFrame {
	//设置需要的组件，简单难度，困难难度
	JButton easy = new JButton("简单模式");
	JButton hard = new JButton("困难模式");
	JButton help = new JButton("帮助");
	//构造方法
	public GameChoise() {
		//添加组件 
		this.add(easy);
		this.add(hard);
		this.add(help);
		//添加监听事件
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
		//设置属性
		setLocation(400, 200);
		setLayout(new GridLayout(3,1));
		setVisible(true);
		pack();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
