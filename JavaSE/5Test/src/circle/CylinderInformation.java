package circle;

public class CylinderInformation {

	public static void main(String[] args) {
		Cylinder y1 = new Cylinder();
		Cylinder y2 = new Cylinder(100,20);
		y1.print();
		y2.print();

	}

}
class Cylinder{
	double height,radius;
	Cylinder(){
		this.height = 1;
		this.radius = 1;
	}
	Cylinder(double a,double b){
		this.height = a;
		this.radius = b;
	}
	public  void setRadius(double a) {
		this.radius = a;
	}
	public double getRadius() {
		return this.radius;
	}
	public double getArea() {
		return 3.14*this.radius*this.radius;
	}
	public double getTj() {
		return 3.14*this.radius*this.radius*this.height;
	}
	public void print() {
		System.out.println(" 半径为：" + this.radius + " 高为" + this.height + " 面积为" + getArea() + " 体积为" + getTj());
	}
}