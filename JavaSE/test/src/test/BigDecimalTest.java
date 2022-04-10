package test;
import java.math.BigDecimal;
import java.util.*;
public class BigDecimalTest {
	public static void main(String[] args) {
		Random r = new Random();
		BigDecimal b = new BigDecimal(12.444444444444);
		BigDecimal a = new BigDecimal(12);
		BigDecimal c = b.add(a);
		System.out.println(c);
		
	}

}
