package first;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class TestJLabelTextEvent extends JFrame{
	public TestJLabelTextEvent() {
		this.setVisible(true);
		this.setBounds(100, 100, 300, 200);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		TextField t = new TextField();
		JButton catchs = new JButton("捕获");
		JLabel label = new JLabel();
		Container c = this.getContentPane();
		c.setLayout(null);
		c.add(t);
		c.add(catchs);
		c.add(label);
		t.setBounds(75, 10, 150, 25);
		catchs.setBounds(110, 40, 75, 50);
		label.setBounds(75, 100, 150, 25);
		//添加监听事件
		catchs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(t.getText());
			}
		});
	}
	public static void main(String[] args) {
		new TestJLabelTextEvent();
	}
}
