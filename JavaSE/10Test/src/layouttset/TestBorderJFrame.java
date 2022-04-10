package layouttset;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class TestBorderJFrame extends JFrame{
	public TestBorderJFrame() {
		setVisible(true);
		setTitle("边界式布局");
		setLayout(new BorderLayout());
		setBounds(100, 100, 500, 500);
		add(new JButton("NORTH"),BorderLayout.NORTH);
		add(new JButton("SOUTH"),BorderLayout.SOUTH);
		add(new JButton("WEST"),BorderLayout.WEST);
		add(new JButton("EAST"),BorderLayout.EAST);
		add(new JButton("CENTER"),BorderLayout.CENTER);
		//closing
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		TestBorderJFrame tbf = new TestBorderJFrame();
	}
}
