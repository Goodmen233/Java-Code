
package frame;
import java.util.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFrame {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("��������Ҫ�Ĵ���ģʽ (���У�1��ʾ��ʽ���֣�2��ʾ�����ϱ��У�3��ʾ���ʽ����)");
		int no = s.nextInt();
		while(true) {
			if(no == 1) {
				System.out.println("��������Ҫ����ʽ����ģʽ�����У�1��ʾ���У�2��ʾ����3��ʾ���ң�");
				int num = s.nextInt();
				if(num == 1) {
					MyFrame frame = new MyFrame(Color.blue,1);
					return;
				}
				if(num == 2) {
					MyFrame frame = new MyFrame(Color.blue,2);
					return;
				}
				if(num == 3) {
					MyFrame frame = new MyFrame(Color.blue,3);
					return;
				}
			}
			if(no == 2) {
				MyFrame frame = new MyFrame(Color.BLACK);
				return;
			}
			if(no == 3) {
				MyFrame frame = new MyFrame(Color.BLACK,3,2);
				return;
			}else
				System.out.println("���������Ϣ����������ѡ��");
		}
	}
}
