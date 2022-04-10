package test01;
import java.util.*;

public class GenericStackPlus<E> {
	private LinkedList<E> linkedList;
	
    public GenericStackPlus() {
        linkedList = new LinkedList<E>();
    }
    public void push(E name) {

        //��Ԫ�ؼ��봮��ǰ��
        linkedList.addFirst(name);
    }
	public E top() {        
	    //ȡ�ô��е�һ��Ԫ��
        return linkedList.getFirst();
    }
    public E pop() {
        //�Ƴ���һ��Ԫ��
        return linkedList.removeFirst();
    }
    public boolean isEmpty() {
        //�����Ƿ�Ϊ��
        return linkedList.isEmpty();
    }
    public static void main(String[] args) {
    	GenericStackPlus<Object> sstack=new GenericStackPlus();
    	sstack.push(11);
    	sstack.push("String");
    	sstack.push(14);
    	
    	while(!sstack.isEmpty()){
    		System.out.println(sstack.pop());
    	}    	
    }
}
