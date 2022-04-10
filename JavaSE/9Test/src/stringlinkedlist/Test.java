package stringlinkedlist;

public class Test {
	public static void main(String[] args) {
		StringLinkedList slist = new StringLinkedList();
		System.out.println(slist.isEmpty());
		slist.put("星期一");
		slist.put("星期二");
		slist.put("星期三");
		slist.put("星期四");
		slist.put("星期五");
		slist.put("星期六");
		slist.put("星期日");
		slist.search("星期一");
		System.out.println(slist.isEmpty());
		System.out.println(slist.size());
		slist.del("星期六");
		slist.del(2);
		slist.output();
		
	}
}
