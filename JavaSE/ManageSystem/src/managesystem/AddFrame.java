//��ȷ������رյ�����
package managesystem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class AddFrame extends JDialog {
	Goods goods;
	public AddFrame(Goods goods) {
		// �������
		this.goods = goods;
		JTextField tf1 = new JTextField();
		JTextField tf2 = new JTextField();
		JLabel l1 = new JLabel("���������������Ʒ�����ƣ�");
		JLabel l2 = new JLabel("���������������Ʒ�ļ۸�");
		JButton sure = new JButton("ȷ��");
		// ��������
		this.setLayout(null);
		this.setVisible(true);
		this.setBounds(150, 150, 300, 300);
		// ������
		this.add(l1);
		l1.setBounds(50, 25, 200, 25);
		this.add(tf1);
		tf1.setBounds(50, 50, 200, 50);
		this.add(l2);
		l2.setBounds(50, 125, 200, 25);
		this.add(tf2);
		tf2.setBounds(50, 150, 200, 50);
		this.add(sure);
		sure.setBounds(200, 225, 100, 40);
		//Ϊ��ť��Ӽ����¼���ʹ֮��ȷ��������ӳɹ�
		sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = tf1.getText();
				String price = tf2.getText();
				goods.map.put(name,price);
			}
		});
	}
}
