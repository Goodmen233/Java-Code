package planewar;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

public class Plane extends FlyObject {
	private int fire;
	// 飞机图片
	private List<BufferedImage> planeImgList;
	private BufferedImage planeImg;
	// 构造方法初始化图片
	public Plane() {
		this.x = 190;
		this.y = 700;
		this.life = 3;
		try {
			planeImgList = new ArrayList<BufferedImage>();
			planeImgList.add(ImageIO.read(new File("src/planewar/planer/hero1.png")));
			planeImgList.add(ImageIO.read(new File("src/planewar/planer/hero2.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		planeImg = planeImgList.get(0);
		this.width = planeImg.getWidth();
		this.height = planeImg.getHeight();
		
	}
	/**
	 * @return the planeImgList
	 */
	public List<BufferedImage> getPlaneImgList() {
		return planeImgList;
	}
	/**
	 * @param planeImgList the planeImgList to set
	 */
	public void setPlaneImgList(List<BufferedImage> planeImgList) {
		this.planeImgList = planeImgList;
	}
	
	/**
	 * @return the planeImg
	 */
	public BufferedImage getPlaneImg() {
		return planeImg;
	}
	/**
	 * @param planeImg the planeImg to set
	 */
	public void setPlaneImg(BufferedImage planeImg) {
		this.planeImg = planeImg;
	}
	@Override
	public void move() {
		
	}
	// 飞机喷气
	public void run(int temp) {
		if(temp / 5 % 2 == 0) {
			this.setPlaneImg(this.getPlaneImgList().get(0));
		}else {
			this.setPlaneImg(this.getPlaneImgList().get(1));
		}
	}
}
