package stack;

public class Stack {
	Object[] stack;
	int index = 0;

	// ���췽��
	public Stack() {
		stack = new Object[10];
	}

	public Stack(int a) {
		stack = new Object[a];
	}

	// ����
	public void push(Object obj) throws StackOperationException {
		if (index >= stack.length) {
			throw new StackOperationException("ջ�������޷��������룡");
		} else {
				stack[index++] = obj;
		  }
	}

	public void pop() throws StackOperationException {
		if (index <= 0)
			throw new StackOperationException("ջ��Ԫ�أ��޷���ջ��");
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
