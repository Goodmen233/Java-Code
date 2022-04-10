package day1;

import java.util.Random;
import java.util.Scanner;

// 特等奖 北欧豪华7日游           1/10 0000
// 一等奖 现金红包1000元    	50/10 0000
// 二等奖 58元王者荣耀皮肤    1000/10 0000
// 三等奖 抽纸一包   		10000/10 0000
// 其他奖  谢谢参与
public class PriceDraw {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		while(true) {
			// 提示信息
			System.out.print("输入1表示抽奖一次，输入0表示退出：");
			// 接受用户输入
			int num = sc.nextInt();
			if(num == 1) {
				int rNum = r.nextInt(100001);
				judgeNum(rNum);
			}else if(num == 0) {
				System.out.println("Exit!");
				break;
			}else {
				System.out.println("字符不合法，请重新输入！");
			}
		}
	}
	public static void judgeNum(int rNum) {
		if(rNum == 0) {
			System.out.println("恭喜你！抽到了特等奖——北欧豪华7日游");
		}else if(rNum <= 50) {
			System.out.println("恭喜你！抽到了一等奖——现金红包1000元 ");
		}else if(rNum <= 1050) {
			System.out.println("恭喜你！抽到了二等奖——58元王者荣耀皮肤");
		}else if(rNum <= 11050) {
			System.out.println("恭喜你！抽到了三等奖——抽纸一包");
		}else {
			System.out.println("谢谢参与！");
		}
		
	}
}
