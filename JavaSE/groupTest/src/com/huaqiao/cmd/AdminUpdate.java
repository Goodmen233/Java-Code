package com.huaqiao.cmd;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AdminUpdate extends JFrame{
	private JPanel jp;
	private JLabel updateB;
	private JLabel updateU;
	private JLabel refresh;
	private JLabel about;
	private JButton add;
	private JButton Bdelete;
	private JButton Bupdate;
	private JButton Udelete;
	private JButton Uupdate;
	private JScrollPane js;
	private JTable jTable;
	private String book[] = {"id","bookname","author","addtime","leftnumber"};//书籍的表头
	private String user[] = {"userid","code","type","name","phone","sex"};//用户的表头
	private Object[][] array = null;
	// 判断当前所在页面时修改书籍页面（flag= "book"）还是修改用户页面（flag = "user"）
	private String flag = "book";
	
	
	public AdminUpdate(User user0) {//构造方法
		// TODO Auto-generated constructor stub
		this.setTitle("欢迎管理员：" + user0.getName() + "——修改信息界面");
		this.setSize(950, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setResizable(false);
		jp = new JPanel();
		//bgJLabel = new JLabel(background);
		jp.setOpaque(false);
		jp.setLayout(null);//设置空布局
		
		updateB = new JLabel("修改图书信息",JLabel.CENTER);
		updateU = new JLabel("修改用户信息",JLabel.CENTER);
		refresh = new JLabel("刷新",JLabel.CENTER);
		about = new JLabel("关于",JLabel.CENTER);
		add = new JButton("添加图书");
		Bdelete = new JButton("删除书籍");
		Bupdate= new JButton("修改书籍信息");
		Udelete = new JButton("删除用户");
		Uupdate= new JButton("修改用户信息");
		
		add.setBounds(75, 180, 100, 50);
		Bdelete.setBounds(75, 360, 100, 50);//修改书籍界面的删除按钮
		Bupdate.setBounds(75, 540, 100, 50);//修改书籍界面的修改按钮
		Udelete.setBounds(75, 360, 100, 50);//修改用户界面的删除按钮
		Uupdate.setBounds(75, 540, 100, 50);//修改用户界面的修改按钮
		
		updateB.setBounds(75, 0, 100, 50);
		updateU.setBounds(275, 0, 100, 50);
		refresh.setBounds(475, 0, 100, 50);
		about.setBounds(675, 0, 100, 50);
		
		
//----------------初始时候默认界面为修改图书的界面---------------------------------------------		
		flag = "book";
		List<Books> list = Util.selectB();
		int size = list.size();
		if(size!=0) {
			array = new Object[size][5];
			for(int i =0;i<size;i++) {
				array[i][0] = list.get(i).getId();
				array[i][1] = list.get(i).getBookname();
				array[i][2] = list.get(i).getAuthor();
				array[i][3] = list.get(i).getAddtime();
				array[i][4] = list.get(i).getLeftnumber();
			}
		}else {
			JOptionPane.showMessageDialog(null, "书库无书，请先添加书籍");
		}
		jTable = new JTable(array,book);
		jTable.setPreferredScrollableViewportSize(new Dimension(500, 600));
		js = new JScrollPane(jTable);
	    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    js.setViewportView(jTable);
		js.setBounds(275, 130, 500, 500);
		
		jp.removeAll();
		jp.add(Bupdate);
		jp.add(add);
		jp.add(Bdelete);
		jp.add(js);
		jp.add(about);
		jp.add(refresh);
		jp.add(updateB);
		jp.add(updateU);
		repaint();
//--------------------------------------------------------------------------------
		
		updateB.setOpaque(true);
		updateB.setBackground(Color.lightGray);
		updateU.setOpaque(true);
		updateU.setBackground(Color.lightGray);
		refresh.setOpaque(true);
		refresh.setBackground(Color.lightGray);
		about.setOpaque(true);
		about.setBackground(Color.lightGray);
		
		jp.add(about);
		jp.add(refresh);
		jp.add(updateB);
		jp.add(updateU);
		this.add(jp);
		this.setVisible(true);
		
		
		//按钮事件监听的代码区域
		refresh.addMouseListener(new MouseAdapter() {//刷新Label，点击刷新当前页面的表格
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if("book".equals(flag)) {//刷新book页面的表格
					jp.remove(js);
					List<Books> list = Util.selectB();
					int size = list.size();
					if(size!=0) {//书库有书
						array = new Object[size][5];
						for(int i =0;i<size;i++) {
							array[i][0] = list.get(i).getId();
							array[i][1] = list.get(i).getBookname();
							array[i][2] = list.get(i).getAuthor();
							array[i][3] = list.get(i).getAddtime();
							array[i][4] = list.get(i).getLeftnumber();
						}
					}else {//书库无书
						JOptionPane.showMessageDialog(null, "书库无书，请先添加书籍");
					}
					jTable = new JTable(array,book);
					jTable.setPreferredScrollableViewportSize(new Dimension(500, 600));
					js = new JScrollPane(jTable);
				    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				    js.setViewportView(jTable);
					js.setBounds(275, 130, 500, 500);
					jp.add(js);
				}else if("user".equals(flag)) {//刷新user页面的表格
					jp.remove(js);
					List<User> list = Util.selectU();
					int size = list.size();
					if(size!=0) {//存在用户
						array = new Object[size][6];
						for(int i =0;i<size;i++) {
							array[i][0] = list.get(i).getUserid();
							array[i][1] = list.get(i).getCode();
							array[i][2] = list.get(i).getType();
							array[i][3] = list.get(i).getName();
							array[i][4] = list.get(i).getPhone();
							array[i][5] = list.get(i).getSex();
						}
					}else {//不存在用户
						JOptionPane.showMessageDialog(null, "无用户，请先注册用户");
					}
					jTable = new JTable(array,user);
					jTable.setPreferredScrollableViewportSize(new Dimension(500, 600));
					js = new JScrollPane(jTable);
				    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				    js.setViewportView(jTable);
					js.setBounds(275, 130, 500, 500);
					jp.add(js);
				}
			}
		});

		about.addMouseListener(new MouseAdapter() {//关于Label，点击弹出开发者窗口
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "开发团队：长名队（cmd）");
			}
		});
		
		updateB.addMouseListener(new MouseAdapter() {//修改书籍Label，点击弹出“增加书籍”、“删除书籍”、“修改书籍信息”三个按钮以及所有书籍的列表
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				flag = "book";
				jp.remove(js);
				List<Books> list = Util.selectB();
				int size = list.size();
				if(size!=0) {
					array = new Object[size][5];
					for(int i =0;i<size;i++) {
						array[i][0] = list.get(i).getId();
						array[i][1] = list.get(i).getBookname();
						array[i][2] = list.get(i).getAuthor();
						array[i][3] = list.get(i).getAddtime();
						array[i][4] = list.get(i).getLeftnumber();
					}
				}else {
					JOptionPane.showMessageDialog(null, "书库无书，请先添加书籍");
				}
				jTable = new JTable(array,book);
				jTable.setPreferredScrollableViewportSize(new Dimension(500, 600));
				js = new JScrollPane(jTable);
			    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			    js.setViewportView(jTable);
				js.setBounds(275, 130, 500, 500);
				
				jp.removeAll();
				jp.add(Bupdate);
				jp.add(add);
				jp.add(Bdelete);
				jp.add(js);
				jp.add(about);
				jp.add(refresh);
				jp.add(updateB);
				jp.add(updateU);
				repaint();
			}
		});
		updateU.addMouseListener(new MouseAdapter() {//修改用户Label，点击弹出“删除用户”、“修改用户信息”按钮，并且弹出所有用户列表
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				flag = "user";
				js.remove(jp);
				List<User> list = Util.selectU();
				int size = list.size();
				if(size!=0) {
					array = new Object[size][6];
					for(int i =0;i<size;i++) {
						array[i][0] = list.get(i).getUserid();
						array[i][1] = list.get(i).getCode();
						array[i][2] = list.get(i).getType();
						array[i][3] = list.get(i).getName();
						array[i][4] = list.get(i).getPhone();
						array[i][5] = list.get(i).getSex();
					}
				}else {
					JOptionPane.showMessageDialog(null, "无用户，请先注册用户");
				}
				jTable = new JTable(array,user);
				jTable.setPreferredScrollableViewportSize(new Dimension(500, 600));
				js = new JScrollPane(jTable);
			    js.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
			    js.setViewportView(jTable);
				js.setBounds(275, 130, 500, 500);
				
				jp.removeAll();
				jp.add(Uupdate);
				jp.add(Udelete);
				jp.add(js);
				jp.add(about);
				jp.add(refresh);
				jp.add(updateB);
				jp.add(updateU);
				repaint();
			}
		});
		
		// 添加图书按钮事件监听
		add.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new BookUpdateJF("add");
			}
		});
		
		// 删除图书按钮事件监听
		Bdelete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new BookUpdateJF("Bdelete");
			}
		});
		
		// 修改图书按钮事件监听
		Bupdate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new BookUpdateJF("Bupdate");
			}
		});
		
		Udelete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new UserUpdateJF("Udelete");
			}
		});
		
		Uupdate.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new UserUpdateJF("Uupdate");
			}
		});
		
	}
}
