
package hotel;

public class Hotel {
	Room[][] room = new Room[3][4];

	// ���췽��
	public Hotel() {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				if (i == 0) {
					int t = (i + 1) * 10 + j + 1;
					room[i][j] = new Room(t, "�ͼ���", true);
				}
				if (i == 1) {
					int t = (i + 1) * 10 + j + 1;
					room[i][j] = new Room(t, "�м���", true);
				}
				if (i == 2) {
					int t = (i + 1) * 10 + j + 1;
					room[i][j] = new Room(t, "�߼���", true);
				}
			}
		}
	}

	public void book(int no) {
		int i = no / 10;
		int j = no % (i * 10);
		if (room[i-1][j-1].flag) {
			room[i-1][j-1].flag = false;
		}else 
			System.out.println("�Բ��𣬷����ѱ�Ԥ����");
	}

	public void cancel(int no) {
		int i = no / 10;
		int j = no % (i * 10);
		room[i-1][j-1].flag = true;
	}

	public void check() {
		for (int i = 0; i < room.length; i++) {
			for (int j = 0; j < room[i].length; j++) {
				System.out.println(room[i][j].no + " " + room[i][j].type + " " + room[i][j].flag);
			}
			System.out.println();
		}
	}
}

