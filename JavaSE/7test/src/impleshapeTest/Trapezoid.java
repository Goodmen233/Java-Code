package impleshapeTest;

public class Trapezoid implements Shape {
	double height, superLength, subLength;
	double area;
	
	public double getArea() {
		return area = ((superLength + subLength) * height / 2);
	}

	// 构造方法
	public Trapezoid() {

	}

	public Trapezoid(double height, double superLength, double subLength) {
		this.height = height;
		this.superLength = superLength;
		this.subLength = subLength;
	}
}
