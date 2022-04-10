package test;

import java.util.Calendar;
import java.util.Date;

public class Date12Test {
	public static void main(String[] args) {
		// 1970.1.1 + 2020.12.8
		//Date date = new Date(2020, 12, 8);
		
		//Date date = new Date();
		
		Date date = new Date();
		
		System.out.println(date);
		
		Calendar rightNow = Calendar.getInstance();
		rightNow.setTime(date);
		rightNow.add(Calendar.MONTH, 12);
		Date date0 = rightNow.getTime(); 
		
		System.out.println(date0);
		
		
	}
}
