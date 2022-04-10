package managesystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class RemoveFrame extends JDialog{
	Goods goods;
	public RemoveFrame(Goods goods) {
		// 设置组件
		this.goods = goods;
		JTextField tf1 = new JTextField();
		JLabel l1 = new JLabel("在这里输入删除商品的名称：");
		JButton sure = new JButton("确定");
		// 设置属性
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(150, 150, 300, 300);
		// 添加组件
		this.add(l1);
		l1.setBounds(50, 25, 200, 25);
		this.add(tf1);
		tf1.setBounds(50, 50, 200, 50);
		this.add(sure);
		sure.setBounds(200, 225, 100, 40);
		//为按钮添加监听事件，使之按确定键后添加成功
		sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tf1.getText();
				goods.map.remove(name);
			}
		});
	}
}
