package stringlinkedlist;

public class Test {
	public static void main(String[] args) {
		StringLinkedList slist = new StringLinkedList();
		System.out.println(slist.isEmpty());
		slist.put("����һ");
		slist.put("���ڶ�");
		slist.put("������");
		slist.put("������");
		slist.put("������");
		slist.put("������");
		slist.put("������");
		slist.search("����һ");
		System.out.println(slist.isEmpty());
		System.out.println(slist.size());
		slist.del("������");
		slist.del(2);
		slist.output();
		
	}
}
