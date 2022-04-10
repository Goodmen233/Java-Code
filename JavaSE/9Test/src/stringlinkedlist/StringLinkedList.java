package stringlinkedlist;

import java.util.*;

public class StringLinkedList {
	private LinkedList<String> linkedList;

	// ��������
	public void put(String s) {
		this.linkedList.add(s);
	}

	// ɾ������
	public void del(int index){
		if(index <= linkedList.size()) {
			linkedList.remove(linkedList.get(index));
		}else {
			System.out.println("�±�Խ�磬�޷�ִ��");
		}
	}
	
	public void del(String s) {
		if(linkedList.contains(s)) {
			linkedList.remove(s);
		}else {
			System.out.println("��������ַ����ڸ��������޷�ִ��");
		}
	}
	// ȡ�����ݸ���
	public int size() {
		return linkedList.size();
	}
	
	// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return linkedList.isEmpty();
	}
	
	// ���ݲ�ѯ
	public void search(String s) {
		if(linkedList.contains(s)) {
			System.out.println("��Ҫ���ҵ�Ԫ����" + linkedList.indexOf(s) + "��λ��");
		}
	}
	
	// ��������ȡ������
	public void output() {
		for(int i = 0;i < linkedList.size();i++) {
			System.out.println("��" + (i + 1) + "��Ԫ���ǣ�" + linkedList.get(i));
		}
	}

	// ���췽��
	public StringLinkedList() {
		this.linkedList = new LinkedList<String>();
	}
}
