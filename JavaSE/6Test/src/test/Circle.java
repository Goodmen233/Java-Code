package test;

public class Circle {
	private double radius;

	// ���췽��
	Circle(double r) {
		this.radius = r;
	}

	Circle() {
		this.radius = 1;
	}

	// ����
	public double getArea() {
		return (3.14 * this.radius * this.radius);
	}

	public double getLength() {
		return (3.14 * this.radius * 2);
	}

	public void print() {
		System.out.println("�뾶���ܳ�������ǣ�" + this.radius + " " + getLength() + " " + getArea());
	}
	//setter and getter
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	// ��дtoString,equals����
	public boolean equals(Circle circle) {
		boolean flag = false;
		if(this.radius == circle.radius) {
			System.out.println("����Բ����ͬ��");
			return flag = true;
		}else {
			System.out.println("����Բ�ǲ�ͬ��");
			return flag;
		}
	}

	public String toString() {
		return "The radius of circle is " + this.radius;
	}
		
}