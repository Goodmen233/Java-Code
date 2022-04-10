package com.huaqiao.cmd;

import java.awt.*;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;

public class ReturnBookDemo {

	private JFrame jf;
	private JPanel jp;
	private JButton Bbook;
	private JLabel Lbook;
	private JLabel tip;
	private JTextField Tbook;

	private JTable jTable;
	private JScrollPane js;
	private String name[] = { "id", "lendtime", "returntime", "state", "readername", "readerid" };
	private Object[][] array = null;

	public ReturnBookDemo(User user) {// 构造方法
		jf = new JFrame("欢迎用户：" + user.getName() + "——还书界面");
		jf.setSize(950, 700);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setResizable(false);
		jp = new JPanel();
		jp.setLayout(null);

		Lbook = new JLabel("请输入要还的图书id：");
		Lbook.setBounds(50, 30, 200, 50);
		Lbook.setFont(new Font("宋体", Font.PLAIN, 16));

		tip = new JLabel("你当前可还的书有：");
		tip.setBounds(50, 140, 200, 50);
		tip.setFont(new Font("宋体", Font.PLAIN, 16));

		Tbook = new JTextField();
		Tbook.setBounds(50, 80, 300, 50);

		Bbook = new JButton("确定");
		Bbook.setBounds(380, 85, 60, 40);
		Bbook.setFont(new Font("宋体", Font.PLAIN, 13));

		// 初始化可还书的记录
		List<IOBook> list = Util.returnableBooks(user);
		int size = list.size();
		if (size != 0) {
			array = new Object[size][6];
			for (int i = 0; i < list.size(); i++) {
				array[i][0] = list.get(i).getId();
				array[i][1] = list.get(i).getLendtime();
				array[i][2] = list.get(i).getReturntime();
				array[i][3] = list.get(i).getState();
				array[i][4] = list.get(i).getReadername();
				array[i][5] = list.get(i).getReaderid();
			}
		} else {
			array = new Object[1][6];
			for (int i = 0; i < 6; i++) {
				array[0][i] = 0;
			}
		}
		jTable = new JTable(array, name);
		jTable.setPreferredScrollableViewportSize(new Dimension(850, 450));
		js = new JScrollPane(jTable);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		js.setViewportView(jTable);
		js.setBounds(50, 200, 850, 450);

		Bbook.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				try {
					int a = Integer.valueOf(Tbook.getText());
					
					if (Util.returnBooks(a, user.getUserid()))
						JOptionPane.showMessageDialog(null, "666牛啤太叼了秀鸭你竟然还书成功了!!!!");
					else
						JOptionPane.showMessageDialog(null, "很遗憾，还书失败，你是不是哪个地方搞错了？", "错误", 0);
					jp.remove(js);
					List<IOBook> list = Util.returnableBooks(user);
					int size = list.size();
					if (size != 0) {
						array = new Object[size][6];
						for (int i = 0; i < list.size(); i++) {
							array[i][0] = list.get(i).getId();
							array[i][1] = list.get(i).getLendtime();
							array[i][2] = list.get(i).getReturntime();
							array[i][3] = list.get(i).getState();
							array[i][4] = list.get(i).getReadername();
							array[i][5] = list.get(i).getReaderid();
						}
					} else {
						array = new Object[1][6];
						for (int i = 0; i < 6; i++) {
							array[0][i] = 0;
						}
					}
					jTable = new JTable(array, name);
					jTable.setPreferredScrollableViewportSize(new Dimension(850, 450));
					js = new JScrollPane(jTable);
					js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					js.setViewportView(jTable);
					js.setBounds(50, 200, 850, 450);
					// 相当于更新
					jp.add(js);
					Tbook.setText("");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "请输入相应的数字还书");
				}
				
			}
		});

		jp.add(Bbook);
		jp.add(Lbook);
		jp.add(Tbook);
		jp.add(tip);

		jp.add(js);

		jf.add(jp);
		jf.setVisible(true);

	}
}
