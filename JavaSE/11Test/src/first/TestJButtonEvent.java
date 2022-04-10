package first;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;



public class TestJButtonEvent extends JFrame{
	public TestJButtonEvent() {
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setBounds(200, 200, 200, 300);
		Container c = this.getContentPane();
		c.setLayout(null);
		JButton Button1 = new JButton("Button1");
		JButton Button2 = new JButton("Button2");
		JLabel l = new JLabel("no clicking");
		c.add(l);
		c.add(Button1);
		c.add(Button2);
		Button1.setBounds(10, 30, 80, 30);
		Button2.setBounds(100, 30, 80, 30);
		l.setBounds(50, 55, 100, 30);
		//Ìí¼Ó¼àÌýÊÂ¼þ
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = Button1.getText();
				l.setText(s + " is click!");
			}
		});
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s = Button2.getText();
				l.setText(s + " is click!");
			}
		});
		
	
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		new TestJButtonEvent();
	}
}
