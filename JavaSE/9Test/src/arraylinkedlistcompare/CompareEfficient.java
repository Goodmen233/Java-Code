package arraylinkedlistcompare;

import java.util.*;

public class CompareEfficient {
	public static void main(String[] args) {
		List aList = new ArrayList();
		List lList = new LinkedList();
		// 往ArrayList中添加元素
		aList.add(new Circle());
		aList.add(new Circle());
		aList.add(new Circle());
		aList.add(new Circle());
		aList.add(new Circle());
		aList.add(new Circle());
		aList.add(new Circle());
		aList.add(new Circle());
		aList.add(new Employee());
		aList.add(new Employee());
		aList.add(new Employee());
		// 往LinkedList添加元素
		lList.add(new Circle());
		lList.add(new Circle());
		lList.add(new Circle());
		lList.add(new Circle());
		lList.add(new Circle());
		lList.add(new Circle());
		lList.add(new Circle());
		lList.add(new Circle());
		lList.add(new Employee());
		lList.add(new Employee());
		lList.add(new Employee());
		//计算取出ArrayList中所有元素所需要的时间
		double t1 = System.currentTimeMillis();
		for(Object o : aList) {
			System.out.println(o);
		}
		double t2 = System.currentTimeMillis();
		System.out.println("从ArrayList取出元素所需的时间为：" + (t2 - t1));
		//计算取出LinkedList中所有元素所需要的时间
		double t3 = System.currentTimeMillis();
		for(Object o : lList) {
			System.out.println(o);
		}
		double t4 = System.currentTimeMillis();
		System.out.println("从LinkedList取出元素所需的时间为：" + (t4 - t3));
	}
}
