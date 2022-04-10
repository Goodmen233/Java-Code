package test2;

public abstract class Biology {
	public abstract void move();
}
class Dog extends Biology {
	// 实现抽象类的方法
	public void move() {
		System.out.println("move!");
	}
	
}