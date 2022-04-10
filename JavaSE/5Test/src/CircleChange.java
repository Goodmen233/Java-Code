



public class CircleChange {
	public static void main(String[] args) {
		Cylinder y1=new Cylinder();
		Cylinder y2=new Cylinder(100,new Circle(20));
		y1.print();
		y2.print();
	}

}
  

class Circle{
	double radius;
	Circle(double r){
		this.radius = r;
	}
	Circle(){
		this.radius = 1;
	}
	public  double getArea() {
		return (3.14*this.radius*this.radius);
	}
	public  double getLength() {
		return (3.14*this.radius*2);
	}
	public  void print() {
		System.out.println("�뾶���ܳ�������ǣ�" + this.radius + " " + getLength() + " " + getArea());
	}
	
}
class Cylinder{
	double height;
	Circle circle;
	Cylinder(){
		this(1,new Circle());
	}
	Cylinder(double height,Circle circle){
		this.height = height;
		this.circle = circle;
	}
	public double getArea() {
		return circle.getArea() * 2 + circle.getLength() * this.height;
	}
	public double geiTj() {
		return circle.getArea() * height;
	}
	public void print() {
		System.out.println("������ǣ�" + this.getArea() + " ����ǣ�" + this.geiTj());
	}
}

