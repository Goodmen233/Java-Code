package day1;

import java.util.Random;
import java.util.Scanner;

// �صȽ� ��ŷ����7����           1/10 0000
// һ�Ƚ� �ֽ���1000Ԫ    	50/10 0000
// ���Ƚ� 58Ԫ������ҫƤ��    1000/10 0000
// ���Ƚ� ��ֽһ��   		10000/10 0000
// ������  лл����
public class PriceDraw {
	public static void main(String[] args) {
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		while(true) {
			// ��ʾ��Ϣ
			System.out.print("����1��ʾ�齱һ�Σ�����0��ʾ�˳���");
			// �����û�����
			int num = sc.nextInt();
			if(num == 1) {
				int rNum = r.nextInt(100001);
				judgeNum(rNum);
			}else if(num == 0) {
				System.out.println("Exit!");
				break;
			}else {
				System.out.println("�ַ����Ϸ������������룡");
			}
		}
	}
	public static void judgeNum(int rNum) {
		if(rNum == 0) {
			System.out.println("��ϲ�㣡�鵽���صȽ�������ŷ����7����");
		}else if(rNum <= 50) {
			System.out.println("��ϲ�㣡�鵽��һ�Ƚ������ֽ���1000Ԫ ");
		}else if(rNum <= 1050) {
			System.out.println("��ϲ�㣡�鵽�˶��Ƚ�����58Ԫ������ҫƤ��");
		}else if(rNum <= 11050) {
			System.out.println("��ϲ�㣡�鵽�����Ƚ�������ֽһ��");
		}else {
			System.out.println("лл���룡");
		}
		
	}
}
