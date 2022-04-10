package frame;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
	//��ť		
	static Button start = new Button("start");
	static Button cotinue = new Button("continue");	
	static Button score = new Button("score");
	static Button exist = new Button("exist");
	static Button end = new Button("end");
	static Button b1 = new Button("b1");

	public MyFrame() {
		this(Color.black,1);
	}
	
	//��ʽ����
	public MyFrame(Color color,int no) {
		super("��ʽ����");
		if(no == 1) {
			setLayout(new FlowLayout());
		}
		if(no == 2) {
			setLayout(new FlowLayout(FlowLayout.LEFT));
		}
		if(no == 3) {
			setLayout(new FlowLayout(FlowLayout.RIGHT));
		}
		
		setBounds(20, 30, 30, 20);
		setVisible(true);
		setBackground(color);
		add(start);
		add(cotinue);
		add(score);
		add(exist);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	//����������
	public MyFrame(Color color) {
		super("�����ϱ���");
		setBounds(20, 30, 30, 20);
		setVisible(true);
		setBackground(color);
		add(start,BorderLayout.EAST);
		add(cotinue,BorderLayout.CENTER);
		add(score,BorderLayout.NORTH);
		add(exist,BorderLayout.SOUTH);
		add(end,BorderLayout.WEST);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	//��񲼾�
	public MyFrame(Color color,int hang,int lie) {
		setLayout(new GridLayout(2,3));
		setBounds(20, 30, 30, 20);
		setVisible(true);
		setBackground(color);
		add(start);
		add(cotinue);
		add(score);
		add(exist);
		add(end);
		add(b1);
		//�Զ�ѡ��õĲ���
		pack();
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}
