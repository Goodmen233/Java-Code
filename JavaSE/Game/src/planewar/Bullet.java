package planewar;

import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet extends FlyObject {
	private BufferedImage bulletImg;
	// 子弹的威力
	private int power;
	// 子弹移动速度
	private int ySpeed;

	public Bullet(Plane plane) {
		try {
			bulletImg = ImageIO.read(new File("src/planewar/planer/bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.life = this.power;
		this.power = 1;
		this.ySpeed = 10;
		// 调整子弹位置
		this.x = plane.x + plane.width / 2;
		this.y = plane.y;
	}

	/**
	 * @return the bulletImg
	 */
	public BufferedImage getBulletImg() {
		return bulletImg;
	}

	/**
	 * @param bulletImg the bulletImg to set
	 */
	public void setBulletImg(BufferedImage bulletImg) {
		this.bulletImg = bulletImg;
	}

	/**
	 * @return the power
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @param power the power to set
	 */
	public void setPower(int power) {
		this.power = power;
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
	 * 子弹往上移动
	 */
	public void move() {
		this.y -= ySpeed;
	}
}