
public class VBox {

	public static void main(String[] args) {
		Box b = new Box();
		b.setBox(10,5,6);
		System.out.println("���������ĳ������߷ֱ�Ϊ��" + b.length + " " + b.width + " " + b.heigth);
		System.out.println(b.volume());
	}
}
class Box{
	int length,width,heigth;
	public void setBox(int a,int b,int c){
		this.length = a;
		this.width = b;
		this.heigth = c;
	}
	int volume() {
		return (length*width*heigth);
	}
}