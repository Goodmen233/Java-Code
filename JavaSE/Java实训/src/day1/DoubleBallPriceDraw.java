package day1;

import java.util.Random;
import java.util.Scanner;

public class DoubleBallPriceDraw {
	static int[] redDoubleBall = new int[6];
	static int blueDoubleBall;
	// ���õ��ڵĽ����ʽ�
	static int pricePool = 1000000000;
	// ���õ��ڵ���ߵȽ�����
	static int maxPrice = 20000000;
	
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		
		init();
		System.out.print("���ڵĺ�ɫ�����Ϊ�� ");
		for(int i = 0; i < redDoubleBall.length; i++) {
			System.out.print(redDoubleBall[i] + " ");
		}
		System.out.println("���ڵ���ɫ�����Ϊ�� " + blueDoubleBall);
		int[] userRedBall = new int[6];
		int userBlueBall = 0;
		System.out.println("����������������ɫ�����(1~16)��");
		for(int i = 0; i < userRedBall.length; i++) {
			userRedBall[i] = sc.nextInt();
		}
		System.out.println("��������ɫ�����(1~33)��");
		userBlueBall = sc.nextInt();
		// ���뱾�ڵ��н�����
		System.out.print("���ڵĺ�ɫ�����Ϊ�� ");
		for(int i = 0; i < redDoubleBall.length; i++) {
			System.out.print(redDoubleBall[i] + " ");
		}
		System.out.println("���ڵ���ɫ�����Ϊ�� " + blueDoubleBall);
		
		judge(userRedBall,userBlueBall);
	}
	
	// ���ɱ���˫ɫ�����ķ���
	public static void init() {
		Random r = new Random();
		for(int i = 0; i < redDoubleBall.length; i++) {
			redDoubleBall[i] = r.nextInt(34);
		}
		blueDoubleBall = r.nextInt(17);
	}
	
	// �ж��н�����
	public static void judge(int[] userRedBall, int userBlueBall) {
		// �����������м����ļ���
		int rNum = 0;
		// ����������� �м����ļ���
		int bNum = 0;
		for(int i = 0; i < redDoubleBall.length; i++) {
			if(userRedBall[i] == redDoubleBall[i]) {
				rNum++;
			}
		}
		if(userBlueBall == blueDoubleBall) bNum++;
		// ���ݼ��������ж�ʲô��
		if(rNum == 6 && bNum == 1) {
			if(pricePool < 100000000) {
				double tempPrice = maxPrice * 0.7 + pricePool;
				if(tempPrice >= 5000000) tempPrice = 5000000;
				System.out.println("��ϲ������һ�Ƚ�������Ϊ" + tempPrice + "Ԫ");
			}else {
				double tempPrice1 = maxPrice * 0.5 + pricePool;
				if(tempPrice1 >= 5000000) tempPrice1 = 5000000;
				double tempPrice2 = maxPrice * 0.2;
				if(tempPrice2 >= 5000000) tempPrice2 = 5000000;
				System.out.println("��ϲ������һ�Ƚ�����һ���ֽ���Ϊ" + tempPrice1 + "Ԫ�������ֽ���Ϊ" + tempPrice2 + "Ԫ��");
			}
			
		}else if(rNum == 6 && bNum == 0) {
			double tempPrice = maxPrice * 0.3;
			System.out.println("��ϲ�����˶��Ƚ�������Ϊ" + tempPrice + "Ԫ");
		}else if(rNum ==5 && bNum == 1) {
			System.out.println("��ϲ���������Ƚ�������Ϊ3000Ԫ");
		}else if((rNum == 5 && bNum == 0) || (rNum == 4 && bNum == 1)) {
			System.out.println("��ϲ�������ĵȽ�������Ϊ200Ԫ");
		}else if((rNum == 4 && bNum == 0) || (rNum == 3 && bNum == 1)) {
			System.out.println("��ϲ��������Ƚ�������Ϊ10Ԫ");
		}else if((rNum == 2 && bNum == 1) || (rNum == 1 && bNum == 1) || (rNum == 0 && bNum == 1)) {
			System.out.println("��ϲ���������Ƚ�������Ϊ5Ԫ");
		}else {
			System.out.println("лл���룡");
		}
	}
}
