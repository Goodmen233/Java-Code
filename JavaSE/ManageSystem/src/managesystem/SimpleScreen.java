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
		System.out.println("����ݶ�Ӧ�������������Ҫ�Ĺ��ܣ�");
		System.out.println("1��������Ʒ");
		System.out.println("2��ɾ����Ʒ");
		System.out.println("3��������Ʒ");
		System.out.println("4���ı���Ʒ");
		System.out.println("5���鿴���е���Ʒ");
		System.out.println("6���˳�ϵͳ");
		System.out.println();
		System.out.println("************************************");
		while (true) {
			System.out.print("����������Ҫ�Ĺ��ܣ�");
			int userNum = sc.nextInt();
			if (userNum == 1) {
				System.out.print("������Ҫ���ҵ���Ʒ���ƣ�");
				String name = sc.next();
				try {
					goods.search(name);
				} catch (CantFindGoodsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else if (userNum == 2) {
				System.out.print("������Ҫɾ������Ʒ���ƣ�");
				String name = sc.next();
				try {
					goods.remove(name);
				} catch (CantFindGoodsException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			} else if (userNum == 3) {
				System.out.print("������Ҫ���ӵ���Ʒ���ƣ�");
				String name = sc.next();
				System.out.print("������������Ʒ�ļ۸�");
				int price = sc.nextInt();
				goods.add(name, price);
			} else if (userNum == 4) {
				System.out.print("������Ҫ�޸ĵ���Ʒ���ƣ�");
				String name = sc.next();
				System.out.print("������Ҫ�ı���Ʒ�ļ۸�");
				int price = sc.nextInt();
				goods.change(name, price);
			} else if (userNum == 5) {
				System.out.println("���ڵ���Ʒ�У�");
				Set goodsSet = goods.map.keySet();
				Iterator it = goodsSet.iterator();
				while (it.hasNext()) {
					String name = (String) it.next();
					System.out.println(name + " " + goods.map.get(name));
				}
			} else if (userNum == 6) {
				System.exit(0);
			} else
				System.out.println("��������ַ����Ϸ������������룡");

		}
	}
}