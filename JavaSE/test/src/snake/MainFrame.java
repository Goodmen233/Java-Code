package snake;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	// �ṩ���췽����ɳ�ʼ��
	public MainFrame() {
		//����ڲ������������Ҫ��Ϸ����
		SnakeGame sg = new SnakeGame();
		Container c = this.getContentPane();
		c.add(sg);
		//���û�������
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(450, 200, 800, 800);
		setTitle("CCB'sSnake");
		setVisible(true);
	}
}
