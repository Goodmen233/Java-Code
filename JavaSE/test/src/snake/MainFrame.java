package snake;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	// 提供构造方法完成初始化
	public MainFrame() {
		//获得内部容器并添加主要游戏界面
		SnakeGame sg = new SnakeGame();
		Container c = this.getContentPane();
		c.add(sg);
		//设置基本属性
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(450, 200, 800, 800);
		setTitle("CCB'sSnake");
		setVisible(true);
	}
}
