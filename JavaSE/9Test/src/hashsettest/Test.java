package hashsettest;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Set<Circle> hashset = new HashSet<Circle>();
		hashset.add(new Circle());
		hashset.add(new Circle(1));
		hashset.add(new Circle(1));
		hashset.add(new Circle());
		hashset.add(new Circle(3));
		hashset.add(new Circle(3));
		hashset.add(new Circle(4));
		hashset.add(new Circle(8));
		Iterator<Circle> it = hashset.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
