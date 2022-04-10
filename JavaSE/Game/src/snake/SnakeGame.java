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

public class SnakeGame extends JPanel implements ActionListener, KeyListener {
	// ������Ϸ��Ҫ������
	// ��ȡͼƬ��Ϣ
	ImageIcon up = new ImageIcon(SnakeGame.class.getResource("./snaker/up.png"));
	ImageIcon down = new ImageIcon(SnakeGame.class.getResource("./snaker/down.png"));
	ImageIcon left = new ImageIcon(SnakeGame.class.getResource("./snaker/left.png"));
	ImageIcon right = new ImageIcon(SnakeGame.class.getResource("./snaker/right.png"));
	ImageIcon head = new ImageIcon(SnakeGame.class.getResource("./snaker/head.png"));
	ImageIcon body = new ImageIcon(SnakeGame.class.getResource("./snaker/body.png"));
	ImageIcon apple = new ImageIcon(SnakeGame.class.getResource("./snaker/apple.png"));
	ImageIcon boom = new ImageIcon(SnakeGame.class.getResource("./snaker/boom.png"));
	ImageIcon poison = new ImageIcon(SnakeGame.class.getResource("./snaker/poison.png"));
	ImageIcon background = new ImageIcon(SnakeGame.class.getResource("./snaker/background.png"));
	//��ҩ������ͼ��ImageIcon dead = new ImageIcon(SnakeGame.class.getResource("./snaker/dead.png"));
	// ��ʱ������
	Timer t = null;
	// �����
	Random random = new Random();

	// ��Ϸ��һЩ��������
	// �ߵ���������
	int[] snakeX = null;
	int[] snakeY = null;
	// ʳ�����������
	int appleX = 0;
	int appleY = 0;
	int poisonX = 0;
	int poisonY = 0;
	int boomX = 0;
	int boomY = 0;
	// �ж���Ϸ��ʼ�ı��
	boolean isStart = false;
	boolean isFail = false;
	// ��ʼ���Ⱥͷ���
	int len = 3;
	int score = 0;
	// ��ʼ����,R,L,U,D�����ĸ�����
	String drec = "R";
	// ��Ϸ�ȼ�, easy, hard
	String level = "easy";

	// ���췽������ʼ����
	public SnakeGame(String s) {
		// ��������������
		setFocusable(true);
		addKeyListener(this);
		level = s;
		// ������Ϸ�ٶ�
		if ("easy".equals(level)) {
			t = new Timer(100, this);
		} else if ("hard".equals(level)) {
			t = new Timer(50, this);
		}
		t.start();
	}

	// ����һ��������ʼ���ߺ�ʳ���λ��
	public void init() {
		snakeX = new int[145];
		snakeY = new int[145];
		// ��ʼ����Ϊ3���ߵ�λ��
		snakeX[0] = 25 + 3 * 25;
		snakeY[0] = 60 + 5 * 25;
		snakeX[1] = 25 + 2 * 25;
		snakeY[1] = 60 + 5 * 25;
		snakeX[2] = 25 + 1 * 25;
		snakeY[2] = 60 + 5 * 25;
		// ��ʼ��ʳ��
		appleX = 25 + random.nextInt(30) * 25;
		appleY = 60 + random.nextInt(29) * 25;
		boomX = 25 + random.nextInt(30) * 25;
		boomY = 60 + random.nextInt(29) * 25;
		poisonX = 25 + random.nextInt(30) * 25;
		poisonY = 60 + random.nextInt(29) * 25;
		// ��ʼ��Ϸ��ֵ
		isStart = false;
		isFail = false;
		len = 3;
		score = 0;
		drec = "R";
	}

	// ���ʻ�ͼ,����ͼ�����
	public void paint(Graphics g) {
		// ������
		head.paintIcon(this, g, 40, 10);
		// ����Ϸ��
		/*
		 * ��ɫ���� g.setColor(Color.WHITE); g.fillRect(25, 60, 750, 725);
		 */
		background.paintIcon(this, g, 25, 60);
		// �жϣ�����ͷ
		if (drec == "R") {
			right.paintIcon(this, g, snakeX[0], snakeY[0]);
		} else if (drec == "L") {
			left.paintIcon(this, g, snakeX[0], snakeY[0]);
		} else if (drec == "U") {
			up.paintIcon(this, g, snakeX[0], snakeY[0]);
		} else if (drec == "D") {
			down.paintIcon(this, g, snakeX[0], snakeY[0]);
		}
		// ѭ����������
		for (int i = 1; i < len; i++) {
			body.paintIcon(this, g, snakeX[i], snakeY[i]);
		}
		// ��ʳ��
		apple.paintIcon(this, g, appleX, appleY);
		boom.paintIcon(this, g, boomX, boomY);
		poison.paintIcon(this, g, poisonX, poisonY);
		// �жϻ�û��ʼ����ָ��λ����ʾ�����ַ�����Press space to start/pause!
		if (!isStart) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Press space to start/pause!", 200, 350);
		}
		// �ж����ʧ�ܣ���ָ��λ����ʾ�����ַ���:Press space to replay!
		if (isFail) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Press space to replay!", 200, 350);
		}
		// �������ͳ�����ʾ��
		g.setColor(Color.RED);
		g.setFont(new Font("arial", Font.BOLD, 15));
		g.drawString("Score:" + score, 600, 30);
		g.drawString("length:" + len, 600, 45);
		//������ж�����
		/*if(len == 0) {
			dead.paintIcon(this, g, snakeX[0], snakeY[0]);
		}*/
	}

	// �¼���������ʱ��ˢ��ҳ��
	@Override
	public void actionPerformed(ActionEvent e) {
		// ����ģʽ���Դ�ǽ�������Լ�֮�������û��
		if ("easy".equals(level)) {
			// �жϿ�ʼ��û��ʧ�ܣ��߶�����
			if (isStart && !isFail) {
				// ����
				for (int i = len - 1; i > 0; i--) {
					snakeX[i] = snakeX[i - 1];
					snakeY[i] = snakeY[i - 1];
				}
				// ��ͷ��
				if ("R".equals(drec)) {
					snakeX[0] += 25;
					// ���Խ�磬��ǽ
					if (snakeX[0] >= 775)
						snakeX[0] = 25;
				} else if ("L".equals(drec)) {
					snakeX[0] -= 25;
					// ���Խ�磬��ǽ
					if (snakeX[0] < 25)
						snakeX[0] = 775;
				} else if ("U".equals(drec)) {
					snakeY[0] -= 25;
					// ���Խ�磬��ǽ
					if (snakeY[0] < 60)
						snakeY[0] = 785;
				} else if ("D".equals(drec)) {
					snakeY[0] += 25;
					// ���Խ�磬��ǽ
					if (snakeY[0] >= 785)
						snakeY[0] = 60;
				}

			}
			// �Ե�ƻ����ʳ���������ã�����+1,����+1
			if (snakeX[0] == appleX && snakeY[0] == appleY) {
				appleX = 25 + random.nextInt(30) * 25;
				appleY = 60 + random.nextInt(29) * 25;
				// ��ʳ�������������һ������������
				for (int i = 0; i < len; i++) {
					while (appleX == snakeX[i] && appleY == snakeY[i]) {
						appleX = 25 + random.nextInt(30) * 25;
						appleY = 60 + random.nextInt(29) * 25;
					}
				}
				len++;
				score++;
			}
			// �Ե���ҩ��ʳ���������ã�����-1������-1
			if (snakeX[0] == poisonX && snakeY[0] == poisonY) {
				poisonX = 25 + random.nextInt(30) * 25;
				poisonY = 60 + random.nextInt(29) * 25;
				// ��ʳ�������������һ������������
				for (int i = 0; i < len; i++) {
					while (poisonX == snakeX[i] && poisonY == snakeY[i]) {
						poisonX = 25 + random.nextInt(30) * 25;
						poisonY = 60 + random.nextInt(29) * 25;
					}
				}
				len--;
				score--;
			}
			// �Ե�ը������Ϸ����
			if (snakeX[0] == boomX && snakeY[0] == boomY) {
				isFail = true;
			}
			// ���߶������壬������ʧ
			for (int i = 1; i < len; i++) {
				if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
					for (int j = i; j < len; j++) {
						len = i;
					}
				}
			}
			//���ȼ�Ϊ0��ʧ��
			if(len <= 0) {
				isFail = true;
			}
			// �жϳ���Ϊ�೤ʱ���سɹ�
			
		}

		// ����ģʽ�����Դ�ǽ�������Լ�����
		if ("hard".equals(level)) {
			// �жϿ�ʼ��û��ʧ�ܣ��߶�����
			if (isStart && !isFail) {
				// ����
				for (int i = len - 1; i > 0; i--) {
					snakeX[i] = snakeX[i - 1];
					snakeY[i] = snakeY[i - 1];
				}
				// ��ͷ��
				if ("R".equals(drec)) {
					snakeX[0] += 25;
					// ���Խ�磬ʧ��
					if (snakeX[0] >= 775) {
						isFail = true;
					}
				} else if ("L".equals(drec)) {
					snakeX[0] -= 25;
					// ���Խ�磬ʧ��
					if (snakeX[0] < 25)
						isFail = true;
				} else if ("U".equals(drec)) {
					snakeY[0] -= 25;
					// ���Խ�磬ʧ��
					if (snakeY[0] < 60)
						isFail = true;
				} else if ("D".equals(drec)) {
					snakeY[0] += 25;
					// ���Խ�磬ʧ��
					if (snakeY[0] >= 785)
						isFail = true;
				}

			}
			// �Ե�ƻ����ʳ���������ã�����+1,����+1
			if (snakeX[0] == appleX && snakeY[0] == appleY) {
				appleX = 25 + random.nextInt(30) * 25;
				appleY = 60 + random.nextInt(29) * 25;
				// ��ʳ�������������һ������������
				for (int i = 0; i < len; i++) {
					while (appleX == snakeX[i] && appleY == snakeY[i]) {
						appleX = 25 + random.nextInt(30) * 25;
						appleY = 60 + random.nextInt(29) * 25;
					}
				}
				len++;
				score++;
			}
			// �Ե���ҩ��ʳ���������ã�����-1������-1
			if (snakeX[0] == poisonX && snakeY[0] == poisonY) {
				poisonX = 25 + random.nextInt(30) * 25;
				poisonY = 60 + random.nextInt(29) * 25;
				// ��ʳ�������������һ������������
				for (int i = 0; i < len; i++) {
					while (poisonX == snakeX[i] && poisonY == snakeY[i]) {
						poisonX = 25 + random.nextInt(30) * 25;
						poisonY = 60 + random.nextInt(29) * 25;
					}
				}
				len--;
				score--;
			}
			// �Ե�ը������Ϸ����
			if (snakeX[0] == boomX && snakeY[0] == boomY) {
				isFail = true;
				
				
			}
			// ���߶������壬������ʧ
			for (int i = 1; i < len; i++) {
				if (snakeX[0] == snakeX[i] && snakeY[0] == snakeY[i]) {
					for (int j = i; j < len; j++) {
						len = i;
					}
				}
			}
			// �жϳ���Ϊ�೤ʱ���سɹ�
		}
		// �ػ�
		repaint();
	}

	// ���̼����¼�
	@Override
	public void keyPressed(KeyEvent e) {
		// ��ȡ���̰���
		int keycode = e.getKeyCode();
		// ���̰���Ϊ�ո�ʱ��Ӧ���¼�
		if (keycode == KeyEvent.VK_SPACE) {
			// �����Ϸû�п�ʼʹ֮��ʼ
			isStart = !isStart;
			// ���������ʧ�ܣ�ʹ֮ûʧ��
			if (isFail) {
				isFail = !isFail;
				init();
			}

		}
		// ���̰���Ϊ�����ʱ��Ӧ���¼�
		if (keycode == KeyEvent.VK_RIGHT && !"L".equals(drec))
			drec = "R";
		if (keycode == KeyEvent.VK_LEFT && !"R".equals(drec))
			drec = "L";
		if (keycode == KeyEvent.VK_UP && !"D".equals(drec))
			drec = "U";
		if (keycode == KeyEvent.VK_DOWN && !"U".equals(drec))
			drec = "D";
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
