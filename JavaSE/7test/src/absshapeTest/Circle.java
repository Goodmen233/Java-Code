package absshapeTest;

public class Circle extends Shape {
	double radius;

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
