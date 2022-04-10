package test01;
import java.util.*;

public class GenericStackPlus<E> {
	private LinkedList<E> linkedList;
	
    public GenericStackPlus() {
        linkedList = new LinkedList<E>();
    }
    public void push(E name) {

        //将元素加入串行前端
        linkedList.addFirst(name);
    }
	public E top() {        
	    //取得串行第一个元素
        return linkedList.getFirst();
    }
    public E pop() {
        //移出第一个元素
        return linkedList.removeFirst();
    }
    public boolean isEmpty() {
        //串行是否为空
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
