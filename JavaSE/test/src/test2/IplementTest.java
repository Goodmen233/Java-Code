package test2;

public class IplementTest extends Object{
	public static void main(String[] args) {
		Sum s = new Sum() {
			public void sum(int a, int b) {
				System.out.println(a + b);
			}
		};
		s.sum(1, 5);
	}
}

interface Sum {
	void sum(int a, int b);
}

