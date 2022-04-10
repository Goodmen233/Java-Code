package managesystem;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Properties;

public class Goods implements Serializable{
	Properties map = new Properties(8);
	private static final long serialVersionUID = 12523912750982752L;
	
	public Goods() {

	}

	// add增
	public void add(String name, int price) {
		this.map.put(name, price);
		System.out.println("添加" + name + "成功");
	}

	// remove删
	public void remove(String name) throws CantFindGoodsException {
		if(this.map.containsKey(name)) {
			this.map.remove(name);
			System.out.println("删除" + name + "成功");
		}else
			throw new CantFindGoodsException(name + "商品不存在！请重新输入！");
	}

	// search查
	public void search(String name) throws CantFindGoodsException {
		if (this.map.containsKey(name)) {
			System.out.println("你要查找的对象是" + name + " 价格是：" + this.map.get(name));
		} else
			throw new CantFindGoodsException(name + "商品不存在！请重新输入！");
	}

	// change改
	public void change(String name, int price) {
		this.map.put(name, price);
		System.out.println("修改成功");
	}

}