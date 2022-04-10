package layouttset;

import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;



public class TestGridJFrame extends JFrame{
	public TestGridJFrame() {
		setLayout(new GridLayout(3,2));
		setVisible(true);
		setTitle("表格式布局");
		add(new JButton("SOUTH"));
		add(new JButton("NORTH"));
		add(new JButton("WEST"));
		add(new JButton("EAST"));
		add(new JButton("CENTER"));
		//closing
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		TestGridJFrame tgf = new TestGridJFrame();
	}
}
