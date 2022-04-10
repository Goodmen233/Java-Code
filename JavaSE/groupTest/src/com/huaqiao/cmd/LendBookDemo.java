package com.huaqiao.cmd;

import java.awt.*;
import java.util.List;
import java.awt.event.*;
import javax.swing.*;

public class LendBookDemo {

	private JFrame jf;
	private JPanel jp;

	private JButton Bid;
	private JButton Bname;
	private JButton Bauthor;
	private JButton Blend;

	private JLabel Lid;
	private JLabel Lname;
	private JLabel Lauthor;
	private JLabel Llend;

	private JTextField Tid;
	private JTextField Tname;
	private JTextField Tauthor;
	private JTextField Tlend;

	private JTable jTable;
	private JScrollPane js;
	private String name[] = { "id", "bookname", "author", "addtime", "leftnumber" };
	private Object[][] array = null;

	public LendBookDemo(User user) {// 构造方法
		// TODO Auto-generated constructor stub
		jf = new JFrame("欢迎用户：" + user.getName() + "——借书界面");
		jf.setSize(950, 700);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setResizable(false);
		jp = new JPanel();
		jp.setLayout(null);// 设置空布局

		Lid = new JLabel("输入查询书的id：");
		Lid.setBounds(50, 10, 150, 50);
		Lid.setFont(new Font("宋体", Font.PLAIN, 14));
		Lname = new JLabel("输入查询书的书名：");
		Lname.setBounds(50, 90, 150, 50);
		Lname.setFont(new Font("宋体", Font.PLAIN, 14));
		Lauthor = new JLabel("输入查询书的作者：");
		Lauthor.setBounds(525, 10, 150, 50);
		Lauthor.setFont(new Font("宋体", Font.PLAIN, 14));
		Llend = new JLabel("输入你要借的书的id：");
		Llend.setBounds(525, 90, 150, 50);
		Llend.setFont(new Font("宋体", Font.PLAIN, 14));

		Tid = new JTextField();
		Tid.setBounds(50, 50, 300, 50);
		Tname = new JTextField();
		Tname.setBounds(50, 130, 300, 50);
		Tauthor = new JTextField();
		Tauthor.setBounds(525, 50, 300, 50);
		Tlend = new JTextField();
		Tlend.setBounds(525, 130, 300, 50);

		Bid = new JButton("确定");
		Bid.setBounds(380, 55, 60, 40);
		Bid.setFont(new Font("宋体", Font.PLAIN, 13));
		Bname = new JButton("确定");
		Bname.setBounds(380, 135, 60, 40);
		Bname.setFont(new Font("宋体", Font.PLAIN, 13));
		Bauthor = new JButton("确定");
		Bauthor.setBounds(855, 55, 60, 40);
		Bauthor.setFont(new Font("宋体", Font.PLAIN, 13));
		Blend = new JButton("确定");
		Blend.setBounds(855, 135, 60, 40);
		Blend.setFont(new Font("宋体", Font.PLAIN, 13));

		// 初始化所有借阅历史
		List<Books> list = Util.lendableBooks();
		int size = list.size();
		if (size != 0) {
			array = new Object[size][5];
			for (int i = 0; i < list.size(); i++) {
				array[i][0] = list.get(i).getId();
				array[i][1] = list.get(i).getBookname();
				array[i][2] = list.get(i).getAuthor();
				array[i][3] = list.get(i).getAddtime();
				array[i][4] = list.get(i).getLeftnumber();
			}
		} else {
			array = new Object[1][5];
			for (int i = 0; i < 5; i++) {
				array[0][i] = 0;
			}
		}
		jTable = new JTable(array, name);
		jTable.setPreferredScrollableViewportSize(new Dimension(850, 450));
		js = new JScrollPane(jTable);
		js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		js.setViewportView(jTable);
		js.setBounds(50, 200, 850, 450);
		
		// 点击面板还原可以借的书
		jp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jp.remove(js);
				List<Books> list = Util.lendableBooks();
				int size = list.size();
				if (size != 0) {
					array = new Object[size][5];
					for (int i = 0; i < list.size(); i++) {
						array[i][0] = list.get(i).getId();
						array[i][1] = list.get(i).getBookname();
						array[i][2] = list.get(i).getAuthor();
						array[i][3] = list.get(i).getAddtime();
						array[i][4] = list.get(i).getLeftnumber();
					}
				} else {
					array = new Object[1][5];
					for (int i = 0; i < 5; i++) {
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
				Tid.setText("");
			}
		});
		
		// 输入书的id查询书籍
		Bid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// id是否为数字
				try {
					int id = Integer.valueOf(Tid.getText());
					jp.remove(js);
					List<Books> list = Util.keyCheck(id);
					int size = list.size();
					if (size != 0) {
						array = new Object[size][5];
						for (int i = 0; i < list.size(); i++) {
							array[i][0] = list.get(i).getId();
							array[i][1] = list.get(i).getBookname();
							array[i][2] = list.get(i).getAuthor();
							array[i][3] = list.get(i).getAddtime();
							array[i][4] = list.get(i).getLeftnumber();
						}
					} else {
						array = new Object[1][5];
						for (int i = 0; i < 5; i++) {
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
					Tid.setText("");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "id只能为数字");
				}
				
			}
		});

		// 输入书的名称查询
		Bname.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp.remove(js);
				List<Books> list = Util.keyCheck("bookname", Tname.getText());

				int size = list.size();
				if (size != 0) {
					array = new Object[size][5];
					for (int i = 0; i < list.size(); i++) {
						array[i][0] = list.get(i).getId();
						array[i][1] = list.get(i).getBookname();
						array[i][2] = list.get(i).getAuthor();
						array[i][3] = list.get(i).getAddtime();
						array[i][4] = list.get(i).getLeftnumber();
					}
				} else {
					array = new Object[1][5];
					for (int i = 0; i < 5; i++) {
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
				Tname.setText("");
			}
		});

		// 书的作者查询
		Bauthor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jp.remove(js);
				List<Books> list = Util.keyCheck("author", Tauthor.getText());
				int size = list.size();
				if (size != 0) {
					array = new Object[size][5];
					for (int i = 0; i < list.size(); i++) {
						array[i][0] = list.get(i).getId();
						array[i][1] = list.get(i).getBookname();
						array[i][2] = list.get(i).getAuthor();
						array[i][3] = list.get(i).getAddtime();
						array[i][4] = list.get(i).getLeftnumber();
					}
				} else {
					array = new Object[1][5];
					for (int i = 0; i < 5; i++) {
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
				Tauthor.setText("");
			}
		});
		
		// 借书按钮实现
		Blend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int id = Integer.valueOf(Tlend.getText());
					
					if (Util.lendBooks(id, user)) 
						JOptionPane.showMessageDialog(null, "极其热烈地恭喜您借书取得成功啦!!!!");
					else
						JOptionPane.showMessageDialog(null, "借书失败，你是不是哪个地方搞错了？", "错误", 0);
					
					jp.remove(js);//更新数据，移除原来的数据
					List<Books> list = Util.lendableBooks();
					int size = list.size();
					if (size != 0) {
						array = new Object[size][5];
						for (int i = 0; i < list.size(); i++) {
							array[i][0] = list.get(i).getId();
							array[i][1] = list.get(i).getBookname();
							array[i][2] = list.get(i).getAuthor();
							array[i][3] = list.get(i).getAddtime();
							array[i][4] = list.get(i).getLeftnumber();
						}
					} else {
						array = new Object[1][5];
						for (int i = 0; i < 5; i++) {
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
					Tlend.setText("");
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "只能输入对应数字借书");
				}
				
			}
		});
		jp.add(Bauthor);
		jp.add(Lauthor);
		jp.add(Tauthor);

		jp.add(Bname);
		jp.add(Lname);
		jp.add(Tname);

		jp.add(Bid);
		jp.add(Lid);
		jp.add(Tid);

		jp.add(Blend);
		jp.add(Llend);
		jp.add(Tlend);

		jp.add(js);

		jf.add(jp);
		jf.setVisible(true);

	}
}
