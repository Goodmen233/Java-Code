package managesystem;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class SimpleScreen {
	public static void main(String[] args) {
		Goods goods = new Goods();
		Scanner sc = new Scanner(System.in);
		System.out.println("************************************");
		System.out.println();
		System.out.println("请根据对应的序号输入你想要的功能：");
		System.out.println("1、查找商品");
		System.out.println("2、删除商品");
		System.out.println("3、增加商品");
		System.out.println("4、改变商品");
		System.out.println("5、查看所有的商品");
		System.out.println("6、退出系统");
		System.out.println();
		System.out.println("************************************");
		while (true) {
			System.out.print("现在输入你要的功能：");
			int userNum = sc.nextInt();
			if (userNum == 1) {
				System.out.print("请输入要查找的商品名称：");
				String name = sc.next();
				try {
					goods.search(name);
				} catch (CantFindGoodsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (userNum == 2) {
				System.out.print("请输入要删除的商品名称：");
				String name = sc.next();
				try {
					goods.remove(name);
				} catch (CantFindGoodsException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			} else if (userNum == 3) {
				System.out.print("请输入要增加的商品名称：");
				String name = sc.next();
				System.out.print("请输入增加商品的价格：");
				int price = sc.nextInt();
				goods.add(name, price);
			} else if (userNum == 4) {
				System.out.print("请输入要修改的商品名称：");
				String name = sc.next();
				System.out.print("请输入要改变商品的价格：");
				int price = sc.nextInt();
				goods.change(name, price);
			} else if (userNum == 5) {
				System.out.println("现在的商品有：");
				Set goodsSet = goods.map.keySet();
				Iterator it = goodsSet.iterator();
				while (it.hasNext()) {
					String name = (String) it.next();
					System.out.println(name + " " + goods.map.get(name));
				}
			} else if (userNum == 6) {
				System.exit(0);
			} else
				System.out.println("你输入的字符不合法，请重新输入！");

		}
	}
}