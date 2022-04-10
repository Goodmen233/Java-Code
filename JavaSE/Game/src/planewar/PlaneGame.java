package planewar;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.JPanel;

public class PlaneGame extends JPanel {
	// 定时器对象
	Timer t = new Timer();
	static Random r = new Random();
	// 存储敌机、蜜蜂和子弹的集合
	ArrayList<Bullet> buList = new ArrayList<Bullet>();
	ArrayList<FlyObject> flyList = new ArrayList<FlyObject>();
	// 存储死亡敌机、蜜蜂和打中子弹的集合
	ArrayList<FlyObject> flyListD = new ArrayList<FlyObject>();
	ArrayList<Bullet> buListD = new ArrayList<Bullet>();
	// 开始、暂停的标记
	boolean isStart;
	boolean isFail;
	// 需要的图片：背景
	static BufferedImage backgrounding;
	static BufferedImage start;
	static BufferedImage pause;
	static BufferedImage over;
	// 游戏对象，友机，敌机，boss
	static Plane plane;
	static Enemy enemy;
	// 静态代码块加载 游戏敌机，友机对象及图片
	static {
		plane = new Plane();
		try {
			backgrounding = ImageIO.read(new File("src/planewar/planer/background.png"));
			start = ImageIO.read(new File("src/planewar/planer/start.png"));
			pause = ImageIO.read(new File("src/planewar/planer/pause.png"));
			over = ImageIO.read(new File("src/planewar/planer/gameover.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// 分数
	int score;

	// 画图
	public void paint(Graphics g) {

		// 开始游戏界面
		if (isStart && isFail) {
			g.drawImage(backgrounding, 0, 0, null);
			g.drawImage(start, 0, 0, null);
		}
		// 开始游戏
		if (isStart && !isFail) {
			// 画游戏对象
			g.drawImage(backgrounding, 0, 0, null);
			// 画飞机
			g.drawImage(plane.getPlaneImg(), plane.x, plane.y, null);
			//画子弹
			for (int i = 0; i < buList.size(); i++) {
				g.drawImage(buList.get(i).getBulletImg(), buList.get(i).x, buList.get(i).y, null);
			}
			// 画飞行物
			for (int i = 0; i < flyList.size(); i++) {
				if(flyList.get(i) instanceof Bee) {
					Bee bee = (Bee) flyList.get(i);
					g.drawImage(bee.getImg(), bee.x, bee.y, null);
				// 敌机，爆炸效果
				}else if (flyList.get(i) instanceof Enemy) {
					Enemy enemy = (Enemy) flyList.get(i);
					g.drawImage(enemy.getImg(), enemy.x, enemy.y, null);
				}
			}
		}
		// 游戏暂停
		if (!isStart && !isFail) {
			g.drawImage(pause, 0, 0, null);
		}
		// 游戏失败
		if (!isStart && isFail) {
			g.drawImage(over, 0, 0, null);
		}
		// 画分数和生命
		g.setColor(Color.RED);
		g.setFont(new Font("arial", Font.BOLD, 15));
		g.drawString("Score:" + score, 10, 40);
		g.drawString("Life:" + plane.life, 10, 70);

//------清除死亡集合--------------------------------------
		flyList.removeAll(flyListD);
	}

	// 游戏初始化
	public void init() {
		plane.x = 200;
		plane.y = 700;
		plane.life = 3;
		score = 0;
		isStart = true;
		isFail = true;
		buList = new ArrayList<Bullet>();
		flyList = new ArrayList<FlyObject>();
		flyListD = new ArrayList<FlyObject>();
		buListD = new ArrayList<Bullet>();
	}

	// 构造方法
	public PlaneGame() {
		this.setFocusable(true);
		init();
		// 定时器任务，并添加进入定时器
		TimerTask tt = new TimerTask() {
			public void run() {
				repaint();
				if (isStart && !isFail) {
//------------------准备对象---------------------------------
					int temp = r.nextInt();
					// 让飞机动起来
					plane.run(temp);
					// 随机生成敌机
					if (temp % 25 == 0) {
						flyList.add(new Enemy(r.nextInt(400 - 50), 0));
					}
					// 随机生成蜜蜂
					if(temp % 50 == 0) {
						flyList.add(new Bee(r.nextInt(400 - 60), 0, temp));
					}
//------------------移动对象---------------------------------					
					// 敌机,蜜蜂下移
					for (int i = 0; i < flyList.size(); i++) {
						flyList.get(i).move();
					}
					// 子弹上移
					for (int i = 0; i < buList.size(); i++) {
						buList.get(i).move();
					}
//------------------判定子弹打中飞行物---------------------------					
					// 子弹打到打到蜜蜂或敌机，生命减一。
					for (int i = 0; i < buList.size(); i++) {
						for (int j = 0; j < flyList.size(); j++) {
							if (flyList.get(j).x <= buList.get(i).x
									&& buList.get(i).x <= flyList.get(j).x + flyList.get(j).width) {
								if (flyList.get(j).y <= buList.get(i).y
										&& buList.get(i).y <= flyList.get(j).y + flyList.get(j).height) {
									// 飞行物的生命减去子弹的威力,子弹也减少生命
									flyList.get(j).life -= buList.get(i).getPower();
									// 子弹进入报废集合
									buListD.add(buList.get(i));
								}
							}
						}
					}
					// 清除子弹集合
					buList.removeAll(buListD);
//------------------判断死亡事件-------------------------------					
					// 飞行物死亡，分数加1，添加进死亡集合。并且如果是蜜蜂，加成；如果是敌机，敌机爆炸效果
					for (int i = 0; i < flyList.size(); i++) {
						if (flyList.get(i).life <= 0) {
							flyListD.add(flyList.get(i));
							score ++;
							// 蜜蜂，加成
							if(flyList.get(i) instanceof Bee) {
								Bee bee = (Bee) flyList.get(i);
								// 加生命
								if(bee.getType() == 1) {
									plane.life += 1;
								// 双发子弹	
								}else if(bee.getType() == 2) {
									
								}
							// 敌机，爆炸效果
							}else if (flyList.get(i) instanceof Enemy) {
								Enemy enemy = (Enemy) flyList.get(i);
								try {
									enemy.setImg(ImageIO.read(new File("src/planewar/planer/airplane_boom.png")));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							}
						}
					}
					
					// 友机生命为0，结束
					if(plane.life <= 0) {
						isStart = false;
						isFail = true;
						// mysql存储分数
						if(score > Login.usingPlayer.getScore()) {
							String sql = "update user set score=? where name=?";
							GokJDBCUtil.update(sql, score, Login.usingPlayer.getName());
						}
						new Leaderboard();
					}
//------------------友机事件------------------------------------	
					// 友机碰到飞行物，生命减一
					for (int i = 0; i < flyList.size(); i++) {
						if(plane.x - flyList.get(i).width < flyList.get(i).x && flyList.get(i).x < plane.x + plane.width) {
							if(plane.y - flyList.get(i).height < flyList.get(i).y && flyList.get(i).y < plane.y + plane.height) {
								plane.life -= 1;
								flyList.get(i).life -= 1;
							}
						}
					}
					
				}
				
				// 加分数
				if ("scoreful".equals(MainJFrame.level)) {
					score += 1;
				// 正常模式
				} else if ("normal".equals(MainJFrame.level)) {
					
				}	
			}
		
		};
		
		t.schedule(tt, 1000, 100);
		// 添加鼠标监听
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseMoved(MouseEvent e) {
				// 友机的坐标等于鼠标坐标
				plane.x = e.getX() - plane.width / 2;
				plane.y = e.getY() - plane.height / 2;
			}

		});
		// 鼠标监听
		this.addMouseListener(new MouseAdapter() {
			// 点击生成子弹
			public void mouseClicked(MouseEvent e) {
				buList.add(new Bullet(plane));
			}
//			// 鼠标进来继续
//			public void mouseEntered(MouseEvent e) {
//				if (!isStart && !isFail) {
//					// 使之开始
//					isStart = true;
//				}
//			}
//			// 鼠标离开暂停
//			public void mouseExited(MouseEvent e) {
//				if (isStart && !isFail) {
//					// 使之暂停
//					isStart = false;
//				}
//			}
			
		});
		// 添加键盘监听
		this.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				// 空格暂停或开始
				int keycode = e.getKeyCode();
				if (keycode == KeyEvent.VK_SPACE) {
					// 开始游戏界面
					if (isStart && isFail) {
						// 使之开始
						isFail = false;
					}
					// 开始游戏
					else if (isStart && !isFail) {
						// 使之暂停
						isStart = false;
					}
					// 游戏暂停
					else if (!isStart && !isFail) {
						// 使之开始
						isStart = true;
					}
					// 游戏失败
					else if (!isStart && isFail) {
						// 使之初始化
						init();
					}
				}
			
			}
		});
	}

}
