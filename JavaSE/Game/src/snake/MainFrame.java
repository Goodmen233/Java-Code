package snake;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JDialog {
	ImageIcon imagHead = new ImageIcon(SnakeGame.class.getResource("./snaker/headhead.png"));
	// 提供构造方法完成初始化
	public MainFrame(String s) {
		//获得内部容器并添加主要游戏界面
		SnakeGame sg = new SnakeGame(s);
		Container c = this.getContentPane();
		c.add(sg);
		//设置基本属性
		this.setIconImage(imagHead.getImage());
		setBounds(450, 200, 800, 900);
		setTitle("CCB'sSnake");
		setVisible(true);
		sg.init();
	}
}
