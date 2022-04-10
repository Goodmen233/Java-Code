
package frame;
import java.util.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFrame {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入你要的窗口模式 (其中，1表示流式布局，2表示东西南北中，3表示表格式布局)");
		int no = s.nextInt();
		while(true) {
			if(no == 1) {
				System.out.println("请输入你要的流式布局模式（其中，1表示居中，2表示靠左，3表示靠右）");
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
				System.out.println("你输入的信息有误！请重兴选择");
		}
	}
}
