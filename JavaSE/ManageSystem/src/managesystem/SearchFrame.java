package managesystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SearchFrame extends JDialog {
	Goods goods;
	public SearchFrame(Goods goods) {
		// �������
		this.goods = goods;
		JTextField tf1 = new JTextField();
		JLabel l1 = new JLabel("������������ҵ���Ʒ���ƣ�");
		JButton sure = new JButton("ȷ��");
		JLabel l2 = new JLabel();
		// ��������
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(150, 150, 300, 300);
		// ������
		this.add(l1);
		l1.setBounds(50, 25, 200, 25);
		this.add(tf1);
		tf1.setBounds(50, 50, 200, 50);
		this.add(sure);
		sure.setBounds(200, 225, 100, 40);
		this.add(l2);
		l2.setBounds(50, 150, 200, 50);
		//Ϊ��ť��Ӽ����¼���ʹ֮��ȷ��������ӳɹ�
		sure.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = tf1.getText();
				l2.setText(name + "�ļ۸��ǣ�" + goods.map.get(name));
			}
		});
	}
}
