package test2;

public abstract class Biology {
	public abstract void move();
}
class Dog extends Biology {
	// ʵ�ֳ�����ķ���
	public void move() {
		System.out.println("move!");
	}
	
}