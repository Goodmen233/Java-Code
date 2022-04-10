package test;

public class Test3 {
	
	public static void main(String[] args) {
		int i = 10;
		changeI(i);
		System.out.println(i);
	}
	
	public static void changeI(int i) {
		for(int j = 0; j < 10; j++) {
			i++;
		}
		System.out.println(i);
	}
	
	
}
class Cat{
	private int age;
	private String name;
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}