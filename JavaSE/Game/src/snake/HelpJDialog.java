package snake;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class HelpJDialog extends JDialog {
	public HelpJDialog() {
		//设置提示面板
		JLabel help = new JLabel();
		//添加提示信息
		String s1 = "在这个游戏中有两个模式：";
		String s2 = "1、简单模式，这个模式中游戏速度适中，蛇可以穿墙，动到自己会变短;";
		String s3 = "2、困难模式，这个模式中游戏速度较快，蛇不可以穿墙，动到自己死亡。";
		String s4 = "两种游戏有三种食物，分别是苹果：吃到使之长度增加一；毒药：吃到使之长度减一；炸弹：吃到游戏结束";
		String massage = "<html><body>"
							+ s1 + "<br>" 
							+ s2 + "<br>" 
							+ s3 + "<br>" 
							+ s4 + "<br>"
							+ "</body></html>";
		help.setText(massage);
		//设置弹窗属性
		setVisible(true);
		add(help);
		setBounds(400, 300, 474, 144);
	}
}
