package impleshapeTest;

public class Circle implements Shape {
	double radius;
	double area;

	public double getArea() {
		return this.area = (Math.PI * this.radius * this.radius);
	}

	// ���췽��
	public Circle() {

	}

	public Circle(double radius) {
		this.radius = radius;
	}
}
