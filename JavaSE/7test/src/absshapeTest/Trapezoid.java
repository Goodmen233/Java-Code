package absshapeTest;

public class Trapezoid extends Shape {
	double height, superLength, subLength;

	public double getArea() {
		return area = ((superLength + subLength) * height / 2);
	}

	// ���췽��
	public Trapezoid() {

	}

	public Trapezoid(double height, double superLength, double subLength) {
		this.height = height;
		this.superLength = superLength;
		this.subLength = subLength;
	}
}
