package managesystem;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class ManageFrame extends JFrame {
	JPanel p1,p2;
	JTextArea t;
	JButton add, remove, search, change, refresh, storage;
	JScrollPane jsp = null;
	Goods goods;
	AddFrame addFrame = null;
	RemoveFrame removeFrame = null;
	SearchFrame searchFrame = null;
	ChangeFrame changeFrame = null;
	FileReader reader = null;
	FileWriter writer = null;
	
	public ManageFrame() {
		// ���ô���Ĭ������
		setTitle("��Ʒ����ϵͳ");
		setVisible(true);
		setBounds(900, 300, 400, 300);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		// �������
		this.goods = new Goods();
		
		this.p1 = new JPanel();
		this.p2 = new JPanel();
		this.refresh = new JButton("ˢ��");
		this.add = new JButton("������Ʒ");
		this.remove = new JButton("ɾ����Ʒ");
		this.search = new JButton("������Ʒ");
		this.change = new JButton("�ı���Ʒ");
		this.storage = new JButton("����");
		this.t = new JTextArea();
		this.jsp = new JScrollPane(t);
		// ������
		this.jsp.setPreferredSize(new Dimension(500, 400));
		this.add(p2, new BorderLayout().NORTH);
		this.add(p1, new BorderLayout().SOUTH);
		p1.add(add);
		p1.add(remove);
		p1.add(search);
		p1.add(change);
		p1.add(refresh);
		p2.add(jsp);
		p1.add(storage);
		this.pack();
		// ��Ӱ�ť�����¼�
		// ʵ��ˢ�¼�ˢ�µĹ���
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				t.setText("");
				t.append("��Ʒ����\t��Ʒ�۸�\n");
				Set goodsSet = goods.map.keySet();
				Iterator it = goodsSet.iterator();
				while (it.hasNext()) {
					String name = (String) it.next();
					t.append(name + "\t" + goods.map.get(name) + "\n");
				}
			}
		});
		//ʵ�ֱ��水ť�Ĺ���
		storage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					writer = new FileWriter("D:\\���\\java��workspace\\ManageSystem\\src\\managesystem\\GoodsInfo");
					goods.map.store(writer, null);			
					writer.flush();
				} catch (IOException e1) {
					// TODO �Զ����ɵ� catch ��
					e1.printStackTrace();
				} finally {
					if(writer != null) {
						try {
							writer.close();
						} catch (IOException e1) {
							// TODO �Զ����ɵ� catch ��
							e1.printStackTrace();
						}
					}
				}
			}
		});
		// ʵ����Ӱ�ť�Ĺ���
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addFrame = new AddFrame(goods);
			}

		});
		// ʵ��ɾ����ť�Ĺ���
		remove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeFrame = new RemoveFrame(goods);
			}
		});
		//ʵ�ֲ��Ұ�ť�Ĺ���
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchFrame =new SearchFrame(goods);
			}
		});
		//ʵ�ָ��İ�ť�Ĺ���
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeFrame = new ChangeFrame(goods);
			}
		});
	}

	// ��JTextArea����ʾ���е���Ʒ
	public void showMassage() {
		try {
			reader = new FileReader("D:\\���\\java��workspace\\ManageSystem\\src\\managesystem\\GoodsInfo");
			goods.map.load(reader);
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} finally {
			if(reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
			}
		}
		t.append("��Ʒ����\t��Ʒ�۸�\n");
		Set goodsSet = goods.map.keySet();
		Iterator it = goodsSet.iterator();
		while (it.hasNext()) {
			String name = (String) it.next();
			t.append(name + "\t" + goods.map.get(name) + "\n");
		}
	}

	public static void main(String[] args) {
		new ManageFrame().showMassage();
	}
}