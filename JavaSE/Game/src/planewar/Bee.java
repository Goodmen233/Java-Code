package planewar;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bee extends FlyObject {
	private int xSpeed;
	private int ySpeed;
	private int type;//1表示增加生命，2表示双发
	private BufferedImage Img;
	public Bee() {
		
	}
	public Bee(int x, int y, int type) {
		this.x = x;
		this.y = y;
		this.life = 1;
		this.ySpeed = 5;
		this.xSpeed = 3;
		// 判断加成类型
		if(type % 2 == 0) {
			this.type = 1;
		}else {
			this.type = 2;
		}
		try {
			Img = ImageIO.read(new File("src/planewar/planer/bee.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.height = Img.getHeight();
		this.width = Img.getWidth();
	}
	/**
	 * @return the xSpeed
	 */
	public int getxSpeed() {
		return xSpeed;
	}
	/**
	 * @param xSpeed the xSpeed to set
	 */
	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}
	/**
	 * @return the ySpeed
	 */
	public int getySpeed() {
		return ySpeed;
	}
	/**
	 * @param ySpeed the ySpeed to set
	 */
	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the beeImg
	 */
	public BufferedImage getImg() {
		return Img;
	}
	/**
	 * @param beeImg the beeImg to set
	 */
	public void setImg(BufferedImage Img) {
		this.Img = Img;
	}
	/**
	 * 蜜蜂左右移动，上下移动，快出边界时返回
	 */
	public void move() {
		this.y += this.getySpeed();
		this.x += this.getxSpeed();
		// 如果出界回来
		if(this.x + 70 >= 400) {
			this.setxSpeed(-this.getxSpeed());
		}else if(this.x <= 0) {
			this.setxSpeed(-this.getxSpeed());
		}
	}
}
