package com.ccb.reflect;

public class ReflectTest {
	public static void main(String[] args) {
		Class<Cat> cat = Cat.class;
		Class[] c1 = cat.getInterfaces();
		Class c2 = cat.getSuperclass();
		for(Class c : c1) {
			System.out.println(c);
		}
		System.out.println(c2);
	}
}
