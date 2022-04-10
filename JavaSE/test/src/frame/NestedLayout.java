package frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NestedLayout {
	public static void main(String[] args) {
		Frame frame = new Frame("HelloWorld!");
		frame.setBounds(300,400,400,300);
		frame.setBackground(Color.black);
		frame.setVisible(true);
		frame.setLayout(new GridLayout(2,1));
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//¿ØÖÆÃæ°å
		Panel p1 = new Panel(new BorderLayout());
		Panel p2 = new Panel(new GridLayout(2,1));
		Panel p3 = new Panel(new BorderLayout());
		Panel p4 = new Panel(new GridLayout(2,2));
		
		frame.add(p1);
		frame.add(p3);
		p1.add(p2,BorderLayout.CENTER);
		p3.add(p4,BorderLayout.CENTER);
		
		p1.add(new Button("¿ªÊ¼"),BorderLayout.EAST);
		p1.add(new Button("½áÊø"),BorderLayout.WEST);
		p2.add(new Button("´æµµ1"));
		p2.add(new Button("´æµµ2"));
		p3.add(new Button("¿ªÊ¼2"),BorderLayout.EAST);
		p3.add(new Button("½áÊø3"),BorderLayout.WEST);
		p4.add(new Button("´æµµ3"));
		p4.add(new Button("´æµµ4"));
		p4.add(new Button("´æµµ5"));
		p4.add(new Button("´æµµ6"));
		
		
	}
}
