package impleshapeTest;

public class TestShape {
	static double totalArea;
	
	public static double countArea(Shape s) {
		return totalArea += s.getArea();
	}
	
	public static void main(String[] args) {
		Shape s1 = new Circle(1);
		Shape s2 = new Box(2,3);
		Shape s3 = new Triangle(1,2,3);
		Shape s4 = new Trapezoid(4,5,3);
		countArea(s1);
		countArea(s2);
		countArea(s3);
		countArea(s4);
		System.out.println("总面积是：" + totalArea);
	}
}
