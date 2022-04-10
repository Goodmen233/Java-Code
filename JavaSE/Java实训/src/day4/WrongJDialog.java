package day4;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class WrongJDialog extends JDialog {
	public WrongJDialog() {
		JLabel help = new JLabel();
		String s1 = "账号或密码错误，请重新登录！不知道密码？多看看源代码吧";
		String s2 = "居然让你发现的帮助界面！这是款半成品——飞机大战：boss与敌机平等的游戏，点击鼠标射击，";
		String massage = "<html><body>"
				+ s1 + "<br>" 
				+ s2 + "<br>" 
				+ "</body></html>";
		help.setText(massage);
		this.add(help);
		this.setVisible(true);
		this.setBounds(200, 200, 600, 200);
	}
}
