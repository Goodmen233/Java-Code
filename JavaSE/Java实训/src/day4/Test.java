package day4;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Test {
	public static void main(String[] args) {
//		Login login = new Login();
		JFrame j = new JFrame();
		j.add(new PlaneGame());
		j.setBounds(200, 200, 600, 900);
		j.setVisible(true);
		j.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
}
