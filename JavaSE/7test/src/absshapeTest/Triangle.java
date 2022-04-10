package absshapeTest;

public class Triangle extends Shape {
	double a, b, c;
	double l = (a + b + c) / 2;

	public double getArea() {
		return area = (Math.sqrt(l * (l - a) * (l - b) * (l - c)));
	}

	// 构造方法
	public Triangle() {

	}

	public Triangle(double a,double b,double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}
