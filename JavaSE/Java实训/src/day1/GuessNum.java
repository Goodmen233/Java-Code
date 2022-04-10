package day1;

import java.util.Random;
import java.util.Scanner;

public class GuessNum {
	public static void main(String[] args) {
		// 生成随机数
		Random r = new Random();
		int rNum = r.nextInt(101);
		
		Scanner sc = new Scanner(System.in);
		// 统计用户猜的次数
		int count = 0;
		
		while(true) {
			System.out.print("Please input a number:");
			int num = sc.nextInt();
			if(num == rNum) {
				System.out.println("Congratulation! The number is " + rNum);
				System.out.println("The total is " + (++count));
				break;
			}
			count++;
			System.out.println("Wrong! Please try again!");
		}
	}
}
