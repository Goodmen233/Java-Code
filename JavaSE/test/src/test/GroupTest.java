package test;

public class GroupTest {
	public static void main(String[] args) {
		String s = "向软件工程师进发的小白";
		boolean flag = s.isEmpty();
		Cat cat = new Cat();
		cat.move();
	}
}

class Cat{
	String name;
	/**
	 * 输出猫在移动的信息
	 */
	public void move() {
		System.out.println(this.name + " is move!");
	}
	@Override
	public String toString() {
		return "Cat [name=" + name + "]";
	}
	
}