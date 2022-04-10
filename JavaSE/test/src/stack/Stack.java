package stack;

public class Stack {
	Object[] stack;
	int index = 0;

	// 构造方法
	public Stack() {
		stack = new Object[10];
	}

	public Stack(int a) {
		stack = new Object[a];
	}

	// 方法
	public void push(Object obj) throws StackOperationException {
		if (index >= stack.length) {
			throw new StackOperationException("栈已满，无法继续放入！");
		} else {
				stack[index++] = obj;
		  }
	}

	public void pop() throws StackOperationException {
		if (index <= 0)
			throw new StackOperationException("栈无元素，无法弹栈！");
		else {
			stack[--index] = null;
		}
	}

	public void check() {
		for(int i = 0;i < stack.length;i++) {
			System.out.println(stack[i] + " ");
		}
	}
}
