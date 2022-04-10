package shapeTest;

public class TestShape {
	static double totalArea;
	
	public static double countArea(Shape s) {
		return totalArea += s.area;
	}
	
	public static void main(String[] args) {
		Shape s1 = new Circle(1);
		Shape s2 = new Box(2,3);
		Shape s3 = new Triangle(1,2,3);
		Shape s4 = new Trapezoid(4,5,3);
		s1.getArea();
		s2.getArea();
		s3.getArea();
		s4.getArea();
		countArea(s1);
		countArea(s2);
		countArea(s3);
		countArea(s4);
		System.out.println("总面积是：" + totalArea);
	}
}
