package test;

import java.util.ArrayList;
import java.util.Collection;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		System.out.println(al.size());
		al.add(new Integer(10));
		System.out.println(al.size());
	}
}
