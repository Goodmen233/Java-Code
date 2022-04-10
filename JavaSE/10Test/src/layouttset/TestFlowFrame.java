package layouttset;

import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class TestFlowFrame extends JFrame{
	public TestFlowFrame() {
		setVisible(true);
		setBounds(100, 100, 100, 300);
		setTitle("流动式布局");
		setLayout(new FlowLayout());
		add(new JButton("button1"));
		add(new JButton("button2"));
		add(new TextField("text 1"));
		add(new TextField("text 2"));
		//closing
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		TestFlowFrame tff = new TestFlowFrame();
	}
}
