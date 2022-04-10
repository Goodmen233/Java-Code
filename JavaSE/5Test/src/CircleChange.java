



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
		System.out.println("半径，周长，面积是：" + this.radius + " " + getLength() + " " + getArea());
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
		System.out.println("表面积是；" + this.getArea() + " 体积是：" + this.geiTj());
	}
}

