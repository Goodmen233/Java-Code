
public class StuTest {

	public static void main(String[] args) {
		Student s1 = new Student();
		Student s2 = new Student("�̳Ǳ�",2001,8,25);
		Student s3 = new Student("����",new MyDate());
		Student s4 = new Student("����",new MyDate(2009,4,1));
		s1.print();
		s2.print();
		s3.print();
		s4.print();
	}

}
