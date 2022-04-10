package stringlinkedlist;

import java.util.*;

public class StringLinkedList {
	private LinkedList<String> linkedList;

	// 增加数据
	public void put(String s) {
		this.linkedList.add(s);
	}

	// 删除数据
	public void del(int index){
		if(index <= linkedList.size()) {
			linkedList.remove(linkedList.get(index));
		}else {
			System.out.println("下标越界，无法执行");
		}
	}
	
	public void del(String s) {
		if(linkedList.contains(s)) {
			linkedList.remove(s);
		}else {
			System.out.println("你输入的字符不在该链表内无法执行");
		}
	}
	// 取得数据个数
	public int size() {
		return linkedList.size();
	}
	
	// 判断是否为空
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	// 数据查询
	public void search(String s) {
		if(linkedList.contains(s)) {
			System.out.println("你要查找的元素在" + linkedList.indexOf(s) + "的位置");
		}
	}
	
	// 根据索引取得数据
	public void output() {
		for(int i = 0;i < linkedList.size();i++) {
			System.out.println("第" + (i + 1) + "个元素是：" + linkedList.get(i));
		}
	}

	// 构造方法
	public StringLinkedList() {
		this.linkedList = new LinkedList<String>();
	}
}
