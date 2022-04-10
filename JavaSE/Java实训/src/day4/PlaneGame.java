package day4;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
// ͼֱ�ӻ���jframe�л�������jpanel���Խ����˫���壬�л�ֽˢ�µ�ʱ���в��񣬿������������ֱ�ӻ��廻���۶�컹�����Ӿ��ն�
public class PlaneGame extends JPanel {
	Random r = new Random();
	public static BufferedImage background;
	public static BufferedImage boss;
	public static BufferedImage hero;
	public static BufferedImage bullet;
	public static BufferedImage airplane;
	static {
		try {
			background = ImageIO.read(new File("src/day4/img/background.png"));
			boss = ImageIO.read(new File("src/day4/img/boss.png"));
			hero = ImageIO.read(new File("src/day4/img/hero0.gif"));
			bullet = ImageIO.read(new File("src/day4/img/bullet.png"));
			airplane = ImageIO.read(new File("src/day4/img/airplane.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// boss������
	int bossX = 100;
	int bossY = 0;
	// �ҷ��ɻ�������
	int heroX = 0;
	int heroY = 0;
	// �л�������
	int planeX = r.nextInt(46) * 10;
	int planeY = 0;
	// ���ڵ��ļ���
	ArrayList<Point> buList = new ArrayList<Point>();
	// ��л��ļ���
	ArrayList<Point> enList = new ArrayList<Point>();
	// ��ʱ������
	Timer t = new Timer(); 
	// ��ֽ
	JPanel con = new JPanel();
	// �ж��Ƿ�ʼ�ı�־
	boolean isStart = true;
	// �޵а��ݲ�����
	//boolean isFail = false;
	// �÷�
	int score = 0;
	
	public PlaneGame() {
		// ������ʱ������
		TimerTask tt = new TimerTask() {
			public void run() {
				if(isStart = true) {
					// �л�����
					planeY += 10;
					if(planeY > 900) planeY = 0;
					// boss����
					bossY += 10;
					if(bossY > 900) bossY = 0;
					// ��������
					for(int i = 0; i < buList.size(); i++) {
						buList.get(i).y -= 50;
					}
					// �ӵ��򵽵л����л�����
					for(int i = 0; i < buList.size(); i++) {
						if((planeX < buList.get(i).x) && (buList.get(i).x < planeX + 49) && (planeY < buList.get(i).y + 36) && (planeY > buList.get(i).y)) {
							planeX = r.nextInt(46) * 10;
							planeY = 0;
							score++;
						}
					}
					// �ӵ���boss��boss����
					for(int i = 0; i < buList.size(); i++) {
						if((bossX < buList.get(i).x) && (buList.get(i).x < bossX + 208) && (bossY < buList.get(i).y + 200) && (bossY > buList.get(i).y)) {
							bossX = r.nextInt(46) * 10;
							bossY = 0;
							score++;
						}
					}
					
				}
				repaint();
			}
			
		};
		// ��ʱ��ÿ1000����ִ��һ��
		t.schedule(tt, 1000, 500);
		// �ɻ���������ƶ�
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				heroX = e.getX();
				heroY = e.getY();
			}
		});
		// ��������䵼��
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				buList.add(new Point(e.getX() + 50, e.getY() - 10));
			}
		});
		// ��������
		this.add(con);
//		this.setTitle("�ɻ���ս");
//		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(200, 200, 486, 900);
		this.setVisible(true);
	}
	
	// ��ͼ
	public void paint(Graphics g) {
		g.drawImage(background, 0, 0, null);
//		g.drawImage(boss, bossX, bossY, null);
//		g.drawImage(airplane, planeX, planeY, null);
//		g.drawImage(hero, heroX, heroY, null);
//		for(int i = 0; i < buList.size(); i++) {
//			g.drawImage(bullet, buList.get(i).x, buList.get(i).y, null);
//		}
//		// ���÷�
//		g.setColor(Color.RED);
//		g.setFont(new Font("arial", Font.BOLD, 15));
//		g.drawString("Score:" + score, 10, 50);
	}
}
