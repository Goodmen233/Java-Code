package phoneClass;

public class cellphone {

	public static void main(String[] args) {
				 phone p=new phone();
				 p.setBrand("Huawei");
			     p.setos("android");
			     p.settype("P30pro");
			     p.setcolor("red");
				 
				 
				 System.out.println("�ֻ�Ʒ����"+p.brand);
				 System.out.println("�ֻ��ͺ���"+p.type);
				 System.out.println("�ֻ�ϵͳ��"+p.os);
				 System.out.println("�ֻ���ɫ��"+p.color);
				 p.about();
				 p.call();
				 p.play();
			}
		}


class phone{
	    String brand,os,type,color;
		String setBrand(String bra) {
				this.brand=bra;
				return bra;
		}
		String setos(String os) {
			    this.os=os;
			    return os;
		}
		String settype(String type) {
			    this.type=type;
			    return type;
		}
		String setcolor(String c) {
			    this.color=c;
			    return c;
		}
		void about() {
			System.out.println(brand+" "+type+" "+os+" "+color);
			
		}
		void call() {
			System.out.println("��绰");
		}
		void play() {
			System.out.println("��������Ϸ");
		}
}


