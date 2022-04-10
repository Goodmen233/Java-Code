package datesubject;

public class Test {
	public static void main(String[] args) {
		try {
			MyDate d1 = new MyDate(-1,13,32);
		} catch (InvalidDateException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		try {
			MyDate d2 = new MyDate();
			d2.setDay(100);
		} catch (InvalidDateException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		
	}
}
