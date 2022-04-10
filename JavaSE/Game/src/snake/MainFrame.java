package snake;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JDialog {
	ImageIcon imagHead = new ImageIcon(SnakeGame.class.getResource("./snaker/headhead.png"));
	// �ṩ���췽����ɳ�ʼ��
	public MainFrame(String s) {
		//����ڲ������������Ҫ��Ϸ����
		SnakeGame sg = new SnakeGame(s);
		Container c = this.getContentPane();
		c.add(sg);
		//���û�������
		this.setIconImage(imagHead.getImage());
		setBounds(450, 200, 800, 900);
		setTitle("CCB'sSnake");
		setVisible(true);
		sg.init();
	}
}
