
public class CircleInformation {
	public static void main(String[] args) {
		
	}

}
  

class Circle{
	double radius;
	double area;
	double length;
	public  double getArea() {
		return (3.14*this.radius*this.radius);
	}
	public  double getLength() {
		return (3.14*this.radius*2);
	}
	public  void print(double r) {
		System.out.println("半径，周长，面积是：" + this.radius + " " + getLength() + " " + getArea());
	}
	Circle(double r){
		this.radius = r;
	}
	Circle(){
		this.radius = 1;
	}
}