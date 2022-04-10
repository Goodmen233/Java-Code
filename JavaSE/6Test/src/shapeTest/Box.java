package shapeTest;

public class Box extends Shape {
	double length, width;

	public double getArea() {
		return area = (this.length * this.width);
	}

	// 构造方法
	public Box() {

	}

	public Box(double length, double width) {
		this.length = length;
		this.width = width;
	}
}
