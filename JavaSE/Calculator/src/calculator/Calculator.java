package calculator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Calculator extends Frame{
	TextField tf1 = new TextField(10);
    TextField tf2 = new TextField(10);
    TextField tf3 = new TextField(10);
    Label sub = new Label("-");
    Button button = new Button("=");
	
    public void loadCal(String s){
        //布局
        setLayout(new FlowLayout());
        add(tf1);
        add(sub);
        add(tf2);
        add(button);
        add(tf3);
        pack();
        setVisible(true);
        setBounds(100,10,10,300);
        //功能
        button.addActionListener(new ButtonListener());
        addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
        
	}
	
    private class ButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			//1、获得两个数
    		int n1 = Integer.valueOf(tf1.getText());
    		int n2 = Integer.valueOf(tf2.getText());
    		//2、减法运算后，放到第三个框
    		tf3.setText("" + (n1 - n2));
    		//3、清除前两个框
    		tf1.setText("");
    		tf2.setText("");
			
		}
	}
}