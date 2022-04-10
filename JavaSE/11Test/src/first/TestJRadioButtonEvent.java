package first;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.WindowConstants;

public class TestJRadioButtonEvent extends JFrame{
	public TestJRadioButtonEvent() {
		this.setVisible(true);
		this.setBounds(100, 100, 200, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		JRadioButton green = new JRadioButton("green");
		JRadioButton yellow = new JRadioButton("yellow");
		TextField t1 = new TextField("None is selected");
		Container c = this.getContentPane();
		ButtonGroup bg = new ButtonGroup();
		bg.add(green);
		bg.add(yellow);
		c.add(green);
		c.add(yellow);
		c.add(t1);
		//Ìí¼Ó¼àÌýÊÂ¼þ
		green.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String s = green.getText();
				t1.setText(s + " is selected");
			}
		});
		yellow.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String s = yellow.getText();
				t1.setText(s + " is selected");
			}
		});
	}
	
	public static void main(String[] args) {
		new TestJRadioButtonEvent();
	}
}
