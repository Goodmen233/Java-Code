import java.util.Scanner;
public class StudentInformation {

	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("��˳������ѧ�ţ��������Ա𣬳ɼ����Ա���1��ʾ�У���0��ʾŮ");
		System.out.println("�������һ��ѧ������Ϣ��");
		s1.sNo = sc.nextInt();
		s1.sName = sc.next();
		s1.sSex = sc.nextInt();
		s1.sJava = sc.nextInt();
		System.out.println("������ڶ���ѧ������Ϣ��");
		s2.sNo = sc.nextInt();
		s2.sName = sc.next();
		s2.sSex = sc.nextInt();
		s2.sJava = sc.nextInt();
		System.out.println("��һ��ѧ������Ϣ��");
		s1.getNo();
		s1.getName();
		s1.getSex();
		s1.getJava();
		System.out.println("�ڶ���ѧ������Ϣ��");
		s2.getNo();
		s2.getName();
		s2.getSex();
		s2.getJava();
		System.out.println("����ѧ����ƽ���ɼ�Ϊ" + (s1.sJava + s2.sJava)/2);
		System.out.println("---------------------------------------------");
		Student s3 = new Student(65);
		Student s4 = new Student(99);
		Student s5 = new Student(25);
		int max = s1.sJava;
		int min = s1.sJava;
		int a[] = {s1.sJava ,s2.sJava ,s3.sJava ,s4.sJava ,s5.sJava};
		for(int i=0;i<5;i++) {
			if(max < a[i]) 
				max = a[i];
		}
		for(int i=0;i<5;i++) {
			if(min > a[i])
				min = a[i];
		}
		System.out.print("�����гɼ����ֵ����Сֵ�ֱ�Ϊ��" + max + " " + min);
	}

}
class Student{
	int sNo,sJava,sSex,sAge;
	String sName;
	void getNo(){
		System.out.println(this.sNo);
	}
	void getName() {
		System.out.println(this.sName);
	}
	void getSex() {
		System.out.println(this.sSex);
	}
	void getJava() {
		System.out.println(this.sJava);
	}
	void getAge() {
		System.out.println(this.sAge);
	}
	Student(int a){
		this.sJava = a;
	}
	Student(){
		
	}
}