package planewar;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

public class LevelChoiseJFrame extends JFrame {
	public LevelChoiseJFrame() {
		// 需要两个按钮
		JRadioButton scoreful = new JRadioButton("加分数");
		JRadioButton normal = new JRadioButton("正常模式");
		ButtonGroup bg = new ButtonGroup();
		bg.add(scoreful);
		bg.add(normal);
		// 选择简单，level变成easy
		scoreful.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainJFrame.level = "scoreful";
			}
		});
		// 选择困难
		normal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainJFrame.level = "lifeful";
			}
		});
		
		// 添加按钮
		this.add(scoreful);
		this.add(normal);
		this.setLayout(new FlowLayout());
		this.setVisible(true);
		this.setBounds(700, 200, 200, 100);
	}
}
