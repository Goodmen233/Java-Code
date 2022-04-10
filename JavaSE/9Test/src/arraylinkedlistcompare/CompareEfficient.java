package arraylinkedlistcompare;

import java.util.*;

public class CompareEfficient {
	public static void main(String[] args) {
		List aList = new ArrayList();
		List lList = new LinkedList();
		// ��ArrayList�����Ԫ��
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
		// ��LinkedList���Ԫ��
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
		//����ȡ��ArrayList������Ԫ������Ҫ��ʱ��
		double t1 = System.currentTimeMillis();
		for(Object o : aList) {
			System.out.println(o);
		}
		double t2 = System.currentTimeMillis();
		System.out.println("��ArrayListȡ��Ԫ�������ʱ��Ϊ��" + (t2 - t1));
		//����ȡ��LinkedList������Ԫ������Ҫ��ʱ��
		double t3 = System.currentTimeMillis();
		for(Object o : lList) {
			System.out.println(o);
		}
		double t4 = System.currentTimeMillis();
		System.out.println("��LinkedListȡ��Ԫ�������ʱ��Ϊ��" + (t4 - t3));
	}
}
