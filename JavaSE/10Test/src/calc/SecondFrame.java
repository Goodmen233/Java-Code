package calc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class SecondFrame extends JFrame{
	public SecondFrame() {
		setVisible(true);
		setBounds(100, 100, 100, 100);
		setTitle("计算器");
		setLayout(new BorderLayout());
		//组件
		JTextField tf1 = new JTextField();
		JPanel p1 = new JPanel(new FlowLayout());
		JPanel p2 = new JPanel(new GridLayout(4,4));
		JButton bCancel = new JButton("Cancel");
		JButton bClear = new JButton("Clear");
		JButton badd = new JButton("+");
		JButton bsub = new JButton("-");
		JButton bmul = new JButton("*");
		JButton bdivi = new JButton("/");
		JButton bequal = new JButton("=");
		JButton bpoint = new JButton(".");
		//往p1，p2添加组件
		p1.add(bCancel);
		p1.add(bClear);
		
		for(int i = 0; i < 10;i++) {
			p2.add(new JButton(String.valueOf(i)));
		}
		p2.add(bpoint);
		p2.add(badd);
		p2.add(bsub);
		p2.add(bmul);
		p2.add(bdivi);
		p2.add(bequal);
		
		add(tf1,BorderLayout.NORTH);
		add(p1,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		pack();
		//closing
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		SecondFrame sf = new SecondFrame();
	}
}
