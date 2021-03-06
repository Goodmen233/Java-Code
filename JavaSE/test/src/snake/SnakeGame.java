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
	//设置游戏需要的属性
	//获取图片信息
	ImageIcon up = new ImageIcon(SnakeGame.class.getResource("./snaker/up.jpg"));
	ImageIcon down = new ImageIcon(SnakeGame.class.getResource("./snaker/down.jpg"));
	ImageIcon left = new ImageIcon(SnakeGame.class.getResource("./snaker/left.jpg"));
	ImageIcon right = new ImageIcon(SnakeGame.class.getResource("./snaker/right.jpg"));
	ImageIcon head = new ImageIcon(SnakeGame.class.getResource("./snaker/head.jpg"));
	ImageIcon body = new ImageIcon(SnakeGame.class.getResource("./snaker/bodynone.jpg"));
	ImageIcon food = new ImageIcon(SnakeGame.class.getResource("./snaker/food.jpg"));
	
	//定时器对象
	Timer t = new Timer(100,this);
	//随机数
	Random random = new Random();
	
	//游戏的一些基本属性
	//蛇的坐标数组
	int[] snakeX = null;
	int[] snakeY = null;
	//食物的坐标数组
	int foodX = 0;
	int foodY = 0;
	//判断游戏开始的标记
	boolean isStart = false;
	boolean isFail = false;
	//初始长度和分数
	int len = 3;
	int score = 0;
	//初始方向,R,L,U,D代表四个方向
	String drec = "R";	
	//游戏等级, easy, hard
	String level = "easy";
	//游戏速度，
	
	//构造方法赋初始属性
	public SnakeGame() {
		//设置面板基本属性
		setFocusable(true);
		addKeyListener(this);
		//调用方法初始化蛇和食物的位置
		this.init();
		//定时器启动刷新界面
		t.start();
	}
	
	//定义一个方法初始化蛇和食物的位置
	public void init() {
		snakeX = new int[145];
		snakeY = new int[145];
		//初始长度为3的蛇的位置
		snakeX[0] = 25 + 3 * 25;
		snakeY[0] = 60 + 5 * 25;
		snakeX[1] = 25 + 2 * 25;
		snakeY[1] = 60 + 5 * 25;
		snakeX[2] = 25 + 1 * 25;
		snakeY[2] = 60 + 5 * 25;
		//初始化食物
		foodX = 25 + random.nextInt(31) * 25;
		foodY = 60 + random.nextInt(30) * 25;
		//初始游戏的值
		isStart = false;
		isFail = false;
		len = 3;
		score = 0;
		drec = "R";
	}
	
	//画笔画图,负责图像界面
	public void paint(Graphics g) {
		//画标题
		head.paintIcon(this, g, 40, 10);
		//画游戏框
		g.setColor(Color.WHITE);
		g.fillRect(25, 60, 750, 725);
		
		//判断，画蛇头
		if(drec == "R") {
			right.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if(drec == "L") {
			left.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if(drec == "U") {
			up.paintIcon(this, g, snakeX[0], snakeY[0]);
		}else if(drec == "D") {
			down.paintIcon(this, g, snakeX[0], snakeY[0]);
		}
		//循环，画蛇身
		for(int i = 1; i < len; i++) {
			body.paintIcon(this, g, snakeX[i], snakeY[i]);
		}
		//画食物
		food.paintIcon(this, g, foodX, foodY);
		//判断还没开始，在指定位置显示提醒字符串：Press space to start/pause!
		if(! isStart) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Press space to start/pause!", 200, 350);
		}
		//判断如果失败，在指定位置显示提醒字符串:Press space to replay!
		if(isFail) {
			g.setColor(Color.BLACK);
			g.setFont(new Font("arial", Font.BOLD, 30));
			g.drawString("Press space to replay!", 200, 350);
		}
		//画分数和长度提示：
		g.setColor(Color.RED);
		g.setFont(new Font("arial", Font.BOLD, 15));
		g.drawString("Score:" + score, 600, 30);
		g.drawString("length:" + len, 600, 45);
	}
	
	//事件监听，定时器刷新页面
	@Override
	public void actionPerformed(ActionEvent e) {
		//简易模式可以穿墙，动到自己之后的身体没了
		if("easy".equals(level)) {
			//判断开始且没有失败，蛇动起来
			if(isStart && ! isFail) {
				//为什么这样头会不见！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！
				
				//蛇头动
				if("R".equals(drec)) {
					snakeX[0] += 25;
					//如果越界，穿墙
					if(snakeX[0] >= 775) snakeX[0] = 25; 
				}else if("L".equals(drec)) {
					snakeX[0] -= 25;
					//如果越界，穿墙
					if(snakeX[0] <= 25) snakeX[0] = 775;
				}else if("U".equals(drec)) {
					snakeY[0] -= 25;
					//如果越界，穿墙
					if(snakeY[0] <= 60) snakeY[0] = 785;
				}else if("D".equals(drec)) {
					snakeY[0] += 25;
					//如果越界，穿墙
					if(snakeY[0] >= 785) snakeY[0] = 60;
				}
				//蛇身动
				for(int i = len - 1; i > 0; i--) {
					snakeX[i] = snakeX[i - 1];
					snakeY[i] = snakeY[i - 1];
				}
			}
			//当蛇头位置等于食物，食物坐标重置，蛇身+1,分数+1
			
			//当蛇动到身体，身体消失
			
			//判断长度为多长时闯关成功
		}
		//困难模式不可以穿墙，动到自己死亡
		
		
		
		
		//重画
		repaint();
	}
	
	//键盘监听事件
	@Override
	public void keyPressed(KeyEvent e) {
		//获取键盘按键
		int keycode = e.getKeyCode();
		//键盘按键为空格时响应的事件
		if(keycode == KeyEvent.VK_SPACE) {
			//如果游戏没有开始使之开始
			isStart = ! isStart;
			//如果现在是失败，使之没失败
			if(isFail) isFail = ! isFail;
		}
		//键盘按键为方向键时响应的事件
		if(keycode == KeyEvent.VK_RIGHT && ! "L".equals(drec)) drec = "R";
		if(keycode == KeyEvent.VK_LEFT && ! "R".equals(drec)) drec = "L";
		if(keycode == KeyEvent.VK_UP && ! "D".equals(drec)) drec = "U";
		if(keycode == KeyEvent.VK_DOWN && ! "U".equals(drec)) drec = "D";
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO 自动生成的方法存根
		
	}
	
	
	
	
	
	
}
