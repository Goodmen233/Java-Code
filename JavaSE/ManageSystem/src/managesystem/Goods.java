package managesystem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Properties;

public class Goods implements Serializable{
	Properties map = new Properties(8);
	private static final long serialVersionUID = 12523912750982752L;
	
	public Goods() {

	}

	// add��
	public void add(String name, int price) {
		this.map.put(name, price);
		System.out.println("���" + name + "�ɹ�");
	}

	// removeɾ
	public void remove(String name) throws CantFindGoodsException {
		if(this.map.containsKey(name)) {
			this.map.remove(name);
			System.out.println("ɾ��" + name + "�ɹ�");
		}else
			throw new CantFindGoodsException(name + "��Ʒ�����ڣ����������룡");
	}

	// search��
	public void search(String name) throws CantFindGoodsException {
		if (this.map.containsKey(name)) {
			System.out.println("��Ҫ���ҵĶ�����" + name + " �۸��ǣ�" + this.map.get(name));
		} else
			throw new CantFindGoodsException(name + "��Ʒ�����ڣ����������룡");
	}

	// change��
	public void change(String name, int price) {
		this.map.put(name, price);
		System.out.println("�޸ĳɹ�");
	}

}