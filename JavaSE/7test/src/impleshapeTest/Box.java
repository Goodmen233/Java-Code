package impleshapeTest;

public class Box implements Shape {
	double length, width;
	double area;
	
	public double getArea() {
		return area = (this.length * this.width);
	}

	// ���췽��
	public Box() {

	}

	public Box(double length, double width) {
		this.length = length;
		this.width = width;
	}
}
