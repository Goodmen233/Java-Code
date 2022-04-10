package test;

public class Test {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		Circle c2 = new Circle(20);
		System.out.println(c1);
		System.out.println(c2);
		c1.equals(c2);
		c2.setRadius(1);
		System.out.println(c2);
		c1.equals(c2);
		MyDate md1 = new MyDate();
		MyDate md2 = new MyDate(2019,2,10);
		System.out.println(md1);
		System.out.println(md2);
		md1.equals(md2);
		md2.setYear(1970);
		md2.setMonth(1);
		md2.setDay(1);
		System.out.println(md2);
		md1.equals(md2);
	}
}
