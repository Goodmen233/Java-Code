package datesubject;

public class Test {
	public static void main(String[] args) {
		try {
			MyDate d1 = new MyDate(-1,13,32);
		} catch (InvalidDateException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		try {
			MyDate d2 = new MyDate();
			d2.setDay(100);
		} catch (InvalidDateException e1) {
			// TODO �Զ����ɵ� catch ��
			e1.printStackTrace();
		}
		
	}
}
