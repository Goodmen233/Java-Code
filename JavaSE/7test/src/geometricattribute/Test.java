package geometricattribute;

public class Test {
	public static void main(String[] args) {
		MuchShape.myGet(new Syso() {

			public void get() {
				Shape s1 = new Circle(1);
				Shape s2 = new Box(5,6);
				Shape s3 = new Triangle(3,4,5);
				if(s1 instanceof Circle) {
					Circle c = (Circle) s1;
					System.out.println("���Բ���ܳ�������ǣ�" + c.getC() + " " +c.getV());
				}	
				if(s2 instanceof Box) {
					Box b = (Box) s2;
					System.out.println("������ε��ܳ�������ǣ�" + b.getC() + " " +b.getV());
				}	
				if(s3 instanceof Triangle) {
					Triangle t = (Triangle) s3;
					System.out.println("��������ε��ܳ�������ǣ�" + t.getC() + " " +t.getV());
				}	
			}
		});
		
	}
}