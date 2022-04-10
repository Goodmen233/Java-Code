package day1;

import java.util.Random;
import java.util.Scanner;

public class DoubleBallPriceDraw {
	static int[] redDoubleBall = new int[6];
	static int blueDoubleBall;
	// 设置当期的奖池资金
	static int pricePool = 1000000000;
	// 设置当期的最高等奖奖金
	static int maxPrice = 20000000;
	
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		init();
		System.out.print("本期的红色球号码为： ");
		for(int i = 0; i < redDoubleBall.length; i++) {
			System.out.print(redDoubleBall[i] + " ");
		}
		System.out.println("本期的蓝色球号码为： " + blueDoubleBall);
		int[] userRedBall = new int[6];
		int userBlueBall = 0;
		System.out.println("请连续输入六个红色球号码(1~16)：");
		for(int i = 0; i < userRedBall.length; i++) {
			userRedBall[i] = sc.nextInt();
		}
		System.out.println("请输入蓝色球号码(1~33)：");
		userBlueBall = sc.nextInt();
		// 输入本期的中奖号码
		System.out.print("本期的红色球号码为： ");
		for(int i = 0; i < redDoubleBall.length; i++) {
			System.out.print(redDoubleBall[i] + " ");
		}
		System.out.println("本期的蓝色球号码为： " + blueDoubleBall);
		
		judge(userRedBall,userBlueBall);
	}
	
	// 生成本期双色球号码的方法
	public static void init() {
		Random r = new Random();
		for(int i = 0; i < redDoubleBall.length; i++) {
			redDoubleBall[i] = r.nextInt(34);
		}
		blueDoubleBall = r.nextInt(17);
	}
	
	// 判断中奖方法
	public static void judge(int[] userRedBall, int userBlueBall) {
		// 计算红球号码中几个的计数
		int rNum = 0;
		// 计算蓝球号码 中几个的计数
		int bNum = 0;
		for(int i = 0; i < redDoubleBall.length; i++) {
			if(userRedBall[i] == redDoubleBall[i]) {
				rNum++;
			}
		}
		if(userBlueBall == blueDoubleBall) bNum++;
		// 根据计数的量判断什么奖
		if(rNum == 6 && bNum == 1) {
			if(pricePool < 100000000) {
				double tempPrice = maxPrice * 0.7 + pricePool;
				if(tempPrice >= 5000000) tempPrice = 5000000;
				System.out.println("恭喜你中了一等奖，奖金为" + tempPrice + "元");
			}else {
				double tempPrice1 = maxPrice * 0.5 + pricePool;
				if(tempPrice1 >= 5000000) tempPrice1 = 5000000;
				double tempPrice2 = maxPrice * 0.2;
				if(tempPrice2 >= 5000000) tempPrice2 = 5000000;
				System.out.println("恭喜你中了一等奖，第一部分奖金为" + tempPrice1 + "元，二部分奖金为" + tempPrice2 + "元。");
			}
			
		}else if(rNum == 6 && bNum == 0) {
			double tempPrice = maxPrice * 0.3;
			System.out.println("恭喜你中了二等奖，奖金为" + tempPrice + "元");
		}else if(rNum ==5 && bNum == 1) {
			System.out.println("恭喜你中了三等奖，奖金为3000元");
		}else if((rNum == 5 && bNum == 0) || (rNum == 4 && bNum == 1)) {
			System.out.println("恭喜你中了四等奖，奖金为200元");
		}else if((rNum == 4 && bNum == 0) || (rNum == 3 && bNum == 1)) {
			System.out.println("恭喜你中了五等奖，奖金为10元");
		}else if((rNum == 2 && bNum == 1) || (rNum == 1 && bNum == 1) || (rNum == 0 && bNum == 1)) {
			System.out.println("恭喜你中了六等奖，奖金为5元");
		}else {
			System.out.println("谢谢参与！");
		}
	}
}
