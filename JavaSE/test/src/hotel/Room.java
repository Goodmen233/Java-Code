package hotel;

public class Room {
	int no;
	String type;
	boolean flag;

	// ���췽��
	public Room() {
		this(11, "�ͼ���", true);
	}

	public Room(int no, String type, boolean flag) {
		this.no = no;
		this.type = type;
		this.flag = flag;
	}
}
