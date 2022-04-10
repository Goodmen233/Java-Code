package com.huaqiao.cmd;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;
import javax.swing.*;

public class CheckHistory {
	
	private JFrame jf;
	private JPanel jp;
	private JButton Buser;//用户后面的确定按钮
	private JButton Bbook;//书籍后面的确定按钮
	private JLabel Luser;//"用户名id"
	private JLabel Lbook;//"图书id"
	private JTextField Tuser;//用户id的文本框
	private JTextField Tbook;//图书id的文本框
	private JTable jTable;
	private JScrollPane js;
	private String name[]= {"id","lendtime","returntime","state","readername","readerid"};
	private Object[][] array = null;
	
	public CheckHistory(User user) {//构造方法
		// TODO Auto-generated constructor stub
		jf = new JFrame("欢迎管理员：" + user.getName() + "——查看历史借阅记录");
		jf.setSize(950, 700);
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jf.setResizable(false);
		jp = new JPanel();
		jp.setLayout(null);//设置空布局
		
		Luser = new JLabel("用户id：");
		Luser.setBounds(50, 30, 120, 50);
		Luser.setFont(new Font("宋体", Font.PLAIN, 16));
		
		Lbook = new JLabel("图书id：");
		Lbook.setBounds(525, 30, 120, 50);
		Lbook.setFont(new Font("宋体", Font.PLAIN, 16));
		
		Tuser = new JTextField();//用户id文本框
		Tuser.setBounds(50, 80, 300, 50);
		
		Tbook = new JTextField();//图书id文本框
		Tbook.setBounds(525, 80, 300, 50);
		
		Buser = new JButton("确定");
		Buser.setBounds(380, 85, 60, 40);
		Buser.setFont(new Font("宋体", Font.PLAIN, 13));
		
		Bbook = new JButton("确定");
		Bbook.setBounds(855, 85, 60, 40);
		Bbook.setFont(new Font("宋体", Font.PLAIN, 13));

		//初始化所有借阅历史
		List<IOBook> list = Util.history();
		int size = list.size();
		if(size != 0) {
			array = new Object[size][6];
			for(int i = 0;i < list.size();i++) {	
					array[i][0] = list.get(i).getId();
					array[i][1] = list.get(i).getLendtime();
					array[i][2] = list.get(i).getReturntime();
					array[i][3] = list.get(i).getState();
					array[i][4] = list.get(i).getReadername();
					array[i][5] = list.get(i).getReaderid();
			}
		}else {
			array = new Object[1][6];
			for(int i = 0;i<6;i++) {
				array[0][i] = 0;
			}
		}
		jTable = new JTable(array,name);
		jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		jTable.setPreferredScrollableViewportSize(new Dimension(850, 450));
		js = new JScrollPane(jTable);
	    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    js.setViewportView(jTable);
		js.setBounds(50, 200, 850, 450);
		
		//用户id按钮点击监听
		Buser.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String input = Tuser.getText();
				if(! "".equals(input)) {
					int id = 0;
					try {
						id = Integer.valueOf(input);
						jp.remove(js);
						List<IOBook> list = Util.namedHis("readerid",id);
						int size = list.size();
						if(size != 0) {
							array = new Object[size][6];
							for(int i = 0;i < list.size();i++) {
									array[i][0] = list.get(i).getId();
									array[i][1] = list.get(i).getLendtime();
									array[i][2] = list.get(i).getReturntime();
									array[i][3] = list.get(i).getState();
									array[i][4] = list.get(i).getReadername();
									array[i][5] = list.get(i).getReaderid();
							}
						}else {
							array = new Object[1][6];
							for(int i = 0;i<6;i++) {
								array[0][i] = 0;
							}
						}
						jTable = new JTable(array,name);
						jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						jTable.setPreferredScrollableViewportSize(new Dimension(850, 450));
						js = new JScrollPane(jTable);
					    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					    js.setViewportView(jTable);
						js.setBounds(50, 200, 850, 450);
						//相当于更新
						jp.add(js);
						Tuser.setText("");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "用户id只能为数字");
						Tuser.setText("");
					}
				}else JOptionPane.showMessageDialog(null, "输入内容不能空");
			}
		});
		
		// 图书id按钮点击监听
		Bbook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String input = Tbook.getText();
				if(! "".equals(input)) {
					int id = 0;
					try {
						id = Integer.valueOf(input);
						jp.remove(js);
						List<IOBook> list = Util.namedHis("id",id);
						int size = list.size();
						if(size != 0) {
							array = new Object[size][6];
							for(int i = 0;i < list.size();i++) {
									array[i][0] = list.get(i).getId();
									array[i][1] = list.get(i).getLendtime();
									array[i][2] = list.get(i).getReturntime();
									array[i][3] = list.get(i).getState();
									array[i][4] = list.get(i).getReadername();
									array[i][5] = list.get(i).getReaderid();
							}
						}else {
							array = new Object[1][6];
							for(int i = 0;i<6;i++) {
								array[0][i] = 0;
							}
						}
						jTable = new JTable(array,name);
						jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
						jTable.setPreferredScrollableViewportSize(new Dimension(850, 450));
						js = new JScrollPane(jTable);
					    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
					    js.setViewportView(jTable);
						js.setBounds(50, 200, 850, 450);
						//相当于更新
						jp.add(js);
						Tbook.setText("");
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "用户id只能为数字");
						Tuser.setText("");
					}
				}else JOptionPane.showMessageDialog(null, "输入内容不能空");
			}
		});
		
		// 管理员点击面板刷新原始数据
		jp.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				jp.remove(js);
				List<IOBook> list = Util.history();
				int size = list.size();
				if(size != 0) {
					array = new Object[size][6];
					for(int i = 0;i < list.size();i++) {	
							array[i][0] = list.get(i).getId();
							array[i][1] = list.get(i).getLendtime();
							array[i][2] = list.get(i).getReturntime();
							array[i][3] = list.get(i).getState();
							array[i][4] = list.get(i).getReadername();
							array[i][5] = list.get(i).getReaderid();
					}
				}else {
					array = new Object[1][6];
					for(int i = 0;i<6;i++) {
						array[0][i] = 0;
					}
				}
				jTable = new JTable(array,name);
				jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				jTable.setPreferredScrollableViewportSize(new Dimension(850, 450));
				js = new JScrollPane(jTable);
			    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			    js.setViewportView(jTable);
				js.setBounds(50, 200, 850, 450);
				//相当于更新
				jp.add(js);
				Tbook.setText("");
			}
		});
		
		jp.add(Bbook);
		jp.add(Lbook);
		jp.add(Tbook);
		jp.add(Buser);
		jp.add(Luser);
		jp.add(Tuser);
		jp.add(js);
		
		jf.add(jp);
		jf.setVisible(true);
		
	}
	
}
