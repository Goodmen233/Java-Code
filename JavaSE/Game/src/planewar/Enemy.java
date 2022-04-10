package planewar;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Enemy extends FlyObject {
	private int enemyLife;
	private BufferedImage Img;
	private int ySpeed;
	public Enemy() {
		
	}
	public Enemy(int x, int y) {
		this.x = x;
		this.y = y;
		this.life = 1;
		ySpeed = 4;
		try {
			Img = ImageIO.read(new File("src/planewar/planer/airplane.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.height = Img.getHeight();
		this.width = Img.getWidth();
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
	 * @return the enemyImg
	 */
	public BufferedImage getImg() {
		return Img;
	}
	/**
	 * @param enemyImg the enemyImg to set
	 */
	public void setImg(BufferedImage Img) {
		this.Img = Img;
	}
	/**
	 * 敌机下移
	 */
	public void move() {
		this.y += this.getySpeed();
	}
}
