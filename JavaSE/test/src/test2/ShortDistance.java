package test2;

import java.util.Scanner;

public class ShortDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// ����
		System.out.print("������·�ڵ�������");
		int n = sc.nextInt();
		System.out.print("������·�ڵ�ͨ·������");
		int m = sc.nextInt();
		int[][] road = new int[n][n];
		while (true){
			System.out.println("���������뼸��·�ڵ�����·�ڵ�ʱ��(��������0�������)��");
			int row = sc.nextInt();
			int column = sc.nextInt();
			int t = sc.nextInt();
			if(row == 0 && column == 0 && t == 0) {
				break;
			}
			road[row - 1][column - 1] = t;
			
		}
//		int n = 5,m = 5;
//		int[][] road = {{0,3,4,0,0},{0,0,6,10,0},{0,0,0,3,2},{0,0,0,0,2},{0,0,0,0,0}};
		countShortDistance(road, n, m);
	}
	
	// ʵ�����ʱ�䷽��������ͼ
	public static void countShortDistance(int[][] road, int n, int m) {
		//tmin����¼ÿһ�αȽ��е���Сֵ��c����¼ÿһ����Сֵ��������temp[]���鿽���ϴαȽϵĲ���ֵ
		int tmin = 100;
		int c = 0;
		int[] temp = new int[n];
		
		//�Ƚϴ���
		for(int i = 0; i  < (n - 1); i++) {
			//��Ϊ��һ�αȽϵ�������⣬�����ó���
			if(i == 0) {
				// ����temp���ݣ��ѵ�һ�е����ݿ���
				for(int j = 0; j < n; j++) {
					temp[j] = road[i][j];
				}
				// ��temp�������ҳ���Сֵ����¼��c��tmin
				for(int j = 0; j < n; j++) {
					if(temp[j] != 0 && temp[j] < tmin) {
						tmin = temp[j];
						c = j;
					}
				}
				//����Сֵ�������ȻӰ�������ж�
				temp[c] = 0;
			}else {
				// �ӵڶ����ж�֮����һ���Ĺ��̣�
				// ���ϴα�����c�����в�Ϊ�����ֵ��tmin�����ӣ����ϴα����temp�������αȽϣ������ֵ�Ƚ�Сʱtemp��Ӧ��ֵ�ı䣬�ٴ�ѡ���Ƚ�С��c
				for(int j = 0; j < n; j++) {
					// �ж�c���е���ֵ��Ϊ0�����Ѿ�ѡ�������ʱ��ĵ��Ӧ���в�����
					if(road[c][j] != 0 && j != c) {
						int a = road[c][j] + tmin;
						// ���֮ǰ��������ֵ�����㲢����Ӻ��ֵС�ڶ�Ӧ��temp�����ֵ���ı�ֵ
						if(temp[j] != 0 && a < temp[j]) {
							temp[j] = a;
						}
						//���temp��Ӧ��ֵΪ�㣬ֱ�Ӹı�ֵ
						if(temp[j] == 0) {
							temp[j] = a;
						}
					}
				}
				// �ı���temp��ֵ���ʼ��tmin
				tmin = 100;
				// ѭ���ҳ���ǰtemp����Сֵ������¼
				for(int j = 0; j < n; j++) {
					if(temp[j] != 0 && temp[j] < tmin) {
						tmin = temp[j];
						c = j;
					}
				}
				//����Сֵ�������ȻӰ�������ж�
				temp[c] = 0;
			}
			// ���ÿ��·�������ʱ��
			System.out.println("��ʼ�㵽" + (c + 1) + "��·�ڵ����ʱ��Ϊ" + tmin);	
		}
		
	}
}
