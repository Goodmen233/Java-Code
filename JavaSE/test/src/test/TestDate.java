package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	public static void main(String[] args) throws ParseException {
		String s = "3+4";
		char c = s.charAt(1);
		char ch = s.substring(1, 2).charAt(0);
		System.out.printf("%c %c", c, ch);
		
	}
}
