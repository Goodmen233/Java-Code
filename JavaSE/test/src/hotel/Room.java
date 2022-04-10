package hotel;

public class Room {
	int no;
	String type;
	boolean flag;

	// 构造方法
	public Room() {
		this(11, "低级房", true);
	}

	public Room(int no, String type, boolean flag) {
		this.no = no;
		this.type = type;
		this.flag = flag;
	}
}
