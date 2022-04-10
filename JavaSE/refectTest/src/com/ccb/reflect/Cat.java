package com.ccb.reflect;

public class Cat extends Animal implements Moveable{
	private String name;
	private int age;
	int foot;
	// getter and setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getFoot() {
		return foot;
	}
	public void setFoot(int foot) {
		this.foot = foot;
	}
	// 构造方法
	public Cat(String name, int age, int foot) {
		super();
		this.name = name;
		this.age = age;
		this.foot = foot;
	}
	public Cat() {
		super();
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + ", foot=" + foot + "]";
	}
	// move方法
	public void move() {
		System.out.println("move!!!");
	}
	protected void move(int n) {
		for(int i = 0; i < n; i++) {
			System.out.println("move!!!");
		}
	}
}
