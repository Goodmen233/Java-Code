package com.huaqiao.cmd;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserUpdateJF extends JDialog {
	private JLabel id;
	private JLabel key;
	private JLabel value;
	
	private JLabel delete;
	
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	
	private JButton apply;
	
	private JPanel jp = new JPanel();
	
	// 构造方法
	public UserUpdateJF(String type) {
		// 进入删除用户功能模块
		if("Udelete".equals(type)) {
			id = new JLabel("请输入要删除的用户id：");
			text1 = new JTextField();
			apply = new JButton("删除");
			
			this.setTitle("删除用户界面");
			this.setSize(300,100);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			jp.setLayout(null);
			
			id.setBounds(0, 5, 130, 50);
			text1.setBounds(130, 05, 70, 50);
			apply.setBounds(220, 10, 70, 40);
			
			jp.add(id);
			jp.add(text1);
			jp.add(apply);
			this.add(jp);
			this.setVisible(true);
			
			apply.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					try {
						int id = Integer.valueOf(text1.getText());
						boolean issucc = Util.deleteU(id);
						if(issucc == true) {
							JOptionPane.showMessageDialog(null, "删除成功");
						}else {
							JOptionPane.showMessageDialog(null, "删除失败，请重新删除！");
						}
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, "输入不合法，请检查");
					}
					
				}
			});
			
		// 进入用户更改信息模块	
		}else {
			id = new JLabel("输入修改用户id：");
			key = new JLabel("输入修改的字段：");
			value = new JLabel("输入修改的值：");
			apply = new JButton("更改");
			text1 = new JTextField();
			text2 = new JTextField();
			text3 = new JTextField();
			
			this.setTitle("更改用户信息界面");
			this.setSize(700,100);
			this.setLocationRelativeTo(null);
			this.setResizable(false);
			jp.setLayout(null);
			
			id.setBounds(0, 5, 100, 50);
			text1.setBounds(100, 5, 100, 50);
			key.setBounds(200, 5, 100, 50);
			text2.setBounds(300, 5, 100, 50);
			value.setBounds(400, 5, 140, 50);
			text3.setBounds(520, 5, 70, 50);
			apply.setBounds(610, 10, 70, 40);
			
			jp.add(apply);
			jp.add(id);
			jp.add(key);
			jp.add(text1);
			jp.add(text2);
			jp.add(text3);
			jp.add(value);
			this.add(jp);
			this.setVisible(true);
			
			apply.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(! "".equals(text1.getText()) && ! "".equals(text2.getText()) && ! "".equals(text3.getText())) {
						try {
							int id1 = Integer.valueOf(text1.getText());
							boolean issucc = Util.updateU(text2.getText(), text3.getText(), id1);
							if(issucc == true) {
								JOptionPane.showMessageDialog(null, "修改成功");
							}else {
								JOptionPane.showMessageDialog(null, "修改失败，请重新修改！");
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "输入不合法，请检查");
						}
					}else JOptionPane.showMessageDialog(null, "输入不能为空");
				}
			});
		}
	}

}
