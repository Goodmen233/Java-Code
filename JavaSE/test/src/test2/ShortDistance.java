package test2;

import java.util.Scanner;

public class ShortDistance {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 界面
		System.out.print("请输入路口的数量：");
		int n = sc.nextInt();
		System.out.print("请输入路口的通路数量：");
		int m = sc.nextInt();
		int[][] road = new int[n][n];
		while (true){
			System.out.println("请依次输入几号路口到几号路口的时间(输入三个0代表结束)：");
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
	
	// 实现最短时间方法，有向图
	public static void countShortDistance(int[][] road, int n, int m) {
		//tmin来记录每一次比较中的最小值，c来记录每一次最小值的列数，temp[]数组拷贝上次比较的残留值
		int tmin = 100;
		int c = 0;
		int[] temp = new int[n];
		
		//比较次数
		for(int i = 0; i  < (n - 1); i++) {
			//因为第一次比较的情况特殊，单独拿出来
			if(i == 0) {
				// 更新temp数据，把第一行的数据拷贝
				for(int j = 0; j < n; j++) {
					temp[j] = road[i][j];
				}
				// 在temp数组中找出最小值并记录在c和tmin
				for(int j = 0; j < n; j++) {
					if(temp[j] != 0 && temp[j] < tmin) {
						tmin = temp[j];
						c = j;
					}
				}
				//把最小值清除，不然影响后面的判断
				temp[c] = 0;
			}else {
				// 从第二次判断之后都是一样的过程：
				// 从上次保留的c的行中不为零的数值与tmin相加相加，与上次保存的temp数组依次比较，相加数值比较小时temp对应的值改变，再次选出比较小的c
				for(int j = 0; j < n; j++) {
					// 判断c行中的数值不为0并且已经选出的最短时间的点对应的列不考虑
					if(road[c][j] != 0 && j != c) {
						int a = road[c][j] + tmin;
						// 如果之前保留的数值不是零并且相加后的值小于对应的temp数组的值，改变值
						if(temp[j] != 0 && a < temp[j]) {
							temp[j] = a;
						}
						//如果temp对应的值为零，直接改变值
						if(temp[j] == 0) {
							temp[j] = a;
						}
					}
				}
				// 改变完temp的值后初始化tmin
				tmin = 100;
				// 循环找出当前temp的最小值，并记录
				for(int j = 0; j < n; j++) {
					if(temp[j] != 0 && temp[j] < tmin) {
						tmin = temp[j];
						c = j;
					}
				}
				//把最小值清除，不然影响后面的判断
				temp[c] = 0;
			}
			// 输出每个路径的最短时间
			System.out.println("初始点到" + (c + 1) + "号路口的最短时间为" + tmin);	
		}
		
	}
}
