package planewar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class MainJFrame extends JFrame {
	// 等级分两种，默认简单
	static String level = "easy"; 
	// 构造方法
	public MainJFrame(){
		// 设置组件
		JMenuBar menu = new JMenuBar();
		
		JMenu menus = new JMenu("菜单");
		JMenu about = new JMenu("关于");
		
		JMenuItem leaderboard = new JMenuItem("排行榜");
		JMenuItem level = new JMenuItem("游戏等级");
		
		JMenuItem write = new JMenuItem("作者");
		
		menu.add(menus);
		menu.add(about);
		
		menus.add(leaderboard);
		menus.add(level);
		
		about.add(write);
		
		// 设置菜单栏的排行榜
		leaderboard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Leaderboard();
			}
		});
		// 设置菜单栏的游戏等级选择
		level.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new LevelChoiseJFrame();
			}
		});
		
		
		// 关于的作者框显示作者信息
		JOptionPane writerTips = new JOptionPane();
		write.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				writerTips.showMessageDialog(write,"CCB");
			}
		});
		
		// 添加游戏面板
		PlaneGame pg = new PlaneGame();
		pg.setFocusable(true);
		this.add(new PlaneGame());
		// 设置窗口属性
		this.setJMenuBar(menu);
		this.setBounds(700, 200, 400, 654);
		this.setTitle(Login.usingPlayer.getName() + "--飞机大战");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		
	}
	
}
