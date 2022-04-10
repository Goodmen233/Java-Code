package snake;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class SnakeGame extends JPanel implements ActionListener,KeyListener {
	//������Ϸ��Ҫ������
	//��ȡͼƬ��Ϣ
	ImageIcon up = new ImageIcon(SnakeGame.class.getResource("./snaker/up.jpg"));
	ImageIcon down = new ImageIcon(SnakeGame.class.getResource("./snaker/down.jpg"));
	ImageIcon left = new ImageIcon(SnakeGame.class.getResource("./snaker/left.jpg"));
	ImageIcon right = new ImageIcon(SnakeGame.class.getResource("./snaker/right.jpg"));
	ImageIcon head = new ImageIcon(SnakeGame.class.getResource("./snaker/head.jpg"));
	ImageIcon body = new ImageIcon(SnakeGame.class.getResource("./snaker/bodynone.jpg"));
	ImageIcon food = new ImageIcon(SnakeGame.class.getResource("./snaker/food.jpg"));
	
	//��ʱ������
	Timer t = new Timer(100,this);
	//�����
	Random random = new Random();
	
	//��Ϸ��һЩ��������
	//�ߵ���������
	int[] snakeX = null;
	int[] snakeY = null;
	//ʳ�����������
	int foodX = 0;
	int foodY = 0;
	//�ж���Ϸ��ʼ�ı��
	boolean isStart = false;
	boolean isFail = false;
	//��ʼ���Ⱥͷ���
	int len = 3;
	int score = 0;
	//��ʼ����,R,L,U,D�����ĸ�����
	String drec = "R";	
	//��Ϸ�ȼ�, easy, hard
	String level = "easy";
	//��Ϸ�ٶȣ�
	
	//���췽������ʼ����
	public SnakeGame() {
		//��������������
		setFocusable(true);
		addKeyListener(this);
		//���÷�����ʼ���ߺ�ʳ���λ��
		this.init();
		//��ʱ������ˢ�½���
		t.start();
	}
	
	//����һ��������ʼ���ߺ�ʳ���λ��
	public void init() {
		snakeX = new int[145];
		snakeY = new int[145];
		//��ʼ����Ϊ3���ߵ�λ��
		snakeX[0] = 25 + 3 * 25;
		snakeY[0] = 60 + 5 * 25;
		snakeX[1] = 25 + 2 * 25;
		snakeY[1] = 60 + 5 * 25;
		snakeX[2] = 25 + 1 * 25;
		snakeY[2] = 60 + 5 * 25;
		//��ʼ��ʳ��
		foodX = 25 + random.nextInt(31) * 25;
		foodY = 60 + random.nextInt(30) * 25;
		//��ʼ��Ϸ��ֵ
		isStart = false;
		isFail = false;
		len = 3;
		score = 0;
		drec = "R";
	}
	
	//���ʻ�ͼ,����ͼ�����
	public void paint(Graphics g) {
		//������
		head.paintIcon(this, g, 40, 10);
		//����Ϸ��
		g.setColor(Color.WHITE);
		g.fillRect(25, 60, 750, 725);
		
		//�жϣ�����ͷ
		if(drec == "R") {
			right.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if(drec == "L") {
			left.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if(drec == "U") {
			up.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if(drec == "D") {
			down.paintIcon(this, g, snakeX[0], snakeY[0]);
		}
		//ѭ����������
		for(int i = 1; i < len; i++) {
			body.paintIcon(this, g, snakeX[i], snakeY[i]);
		}
		//��ʳ��
		food.paintIcon(this, g, foodX, foodY);
		//�жϻ�û��ʼ����ָ��λ����ʾ�����ַ�����Press space to start/pause!
		if(! isStart) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Press space to start/pause!", 200, 350);
		}
		//�ж����ʧ�ܣ���ָ��λ����ʾ�����ַ���:Press space to replay!
		if(isFail) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Press space to replay!", 200, 350);
		}
		//�������ͳ�����ʾ��
		g.setColor(Color.RED);
		g.setFont(new Font("arial", Font.BOLD, 15));
		g.drawString("Score:" + score, 600, 30);
		g.drawString("length:" + len, 600, 45);
	}
	
	//�¼���������ʱ��ˢ��ҳ��
	@Override
	public void actionPerformed(ActionEvent e) {
		//����ģʽ���Դ�ǽ�������Լ�֮�������û��
		if("easy".equals(level)) {
			//�жϿ�ʼ��û��ʧ�ܣ��߶�����
			if(isStart && ! isFail) {
				//Ϊʲô����ͷ�᲻������������������������������������������������������������������������������������������������������������������������������
				
				//��ͷ��
				if("R".equals(drec)) {
					snakeX[0] += 25;
					//���Խ�磬��ǽ
					if(snakeX[0] >= 775) snakeX[0] = 25; 
				}else if("L".equals(drec)) {
					snakeX[0] -= 25;
					//���Խ�磬��ǽ
					if(snakeX[0] <= 25) snakeX[0] = 775;
				}else if("U".equals(drec)) {
					snakeY[0] -= 25;
					//���Խ�磬��ǽ
					if(snakeY[0] <= 60) snakeY[0] = 785;
				}else if("D".equals(drec)) {
					snakeY[0] += 25;
					//���Խ�磬��ǽ
					if(snakeY[0] >= 785) snakeY[0] = 60;
				}
				//����
				for(int i = len - 1; i > 0; i--) {
					snakeX[i] = snakeX[i - 1];
					snakeY[i] = snakeY[i - 1];
				}
			}
			//����ͷλ�õ���ʳ�ʳ���������ã�����+1,����+1
			
			//���߶������壬������ʧ
			
			//�жϳ���Ϊ�೤ʱ���سɹ�
		}
		//����ģʽ�����Դ�ǽ�������Լ�����
		
		
		
		
		//�ػ�
		repaint();
	}
	
	//���̼����¼�
	@Override
	public void keyPressed(KeyEvent e) {
		//��ȡ���̰���
		int keycode = e.getKeyCode();
		//���̰���Ϊ�ո�ʱ��Ӧ���¼�
		if(keycode == KeyEvent.VK_SPACE) {
			//�����Ϸû�п�ʼʹ֮��ʼ
			isStart = ! isStart;
			//���������ʧ�ܣ�ʹ֮ûʧ��
			if(isFail) isFail = ! isFail;
		}
		//���̰���Ϊ�����ʱ��Ӧ���¼�
		if(keycode == KeyEvent.VK_RIGHT && ! "L".equals(drec)) drec = "R";
		if(keycode == KeyEvent.VK_LEFT && ! "R".equals(drec)) drec = "L";
		if(keycode == KeyEvent.VK_UP && ! "D".equals(drec)) drec = "U";
		if(keycode == KeyEvent.VK_DOWN && ! "U".equals(drec)) drec = "D";
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO �Զ����ɵķ������
		
	}
	
	
	
	
	
	
}
