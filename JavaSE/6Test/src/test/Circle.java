package test;

public class Circle {
	private double radius;

	// 构造方法
	Circle(double r) {
		this.radius = r;
	}

	Circle() {
		this.radius = 1;
	}

	// 方法
	public double getArea() {
		return (3.14 * this.radius * this.radius);
	}

	public double getLength() {
		return (3.14 * this.radius * 2);
	}

	public void print() {
		System.out.println("半径，周长，面积是：" + this.radius + " " + getLength() + " " + getArea());
	}
	//setter and getter
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// 重写toString,equals方法
	public boolean equals(Circle circle) {
		boolean flag = false;
		if(this.radius == circle.radius) {
			System.out.println("两个圆是相同的");
			return flag = true;
		}else {
			System.out.println("两个圆是不同的");
			return flag;
		}
	}

	public String toString() {
		return "The radius of circle is " + this.radius;
	}
		
}