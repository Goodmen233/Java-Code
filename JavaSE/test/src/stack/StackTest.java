package stack;
import java.util.*;
public class StackTest {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.print("��������Ҫ������ջ������");
		int a = s.nextInt();
		Stack stack = new Stack(a);
		try {
			stack.push(new Animal());
			stack.push(new Animal() + " " + stack.index);
			stack.push(new Animal() + " " + stack.index);
			stack.push(new Animal() + " " + stack.index);
			stack.push(new Animal() + " " + stack.index);
			stack.push(new Animal() + " " + stack.index);
			stack.push(new Animal() + " " + stack.index);
			stack.push(new Animal() + " " + stack.index);
			stack.push(new Animal() + " " + stack.index);
			stack.push(new Animal() + " " + stack.index);
			stack.push(new Animal() + " " + stack.index);
		}catch(StackOperationException e) {
			System.out.println(e.getMessage());
		}
		stack.check();
	}
}
