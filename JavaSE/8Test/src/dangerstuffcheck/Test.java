package dangerstuffcheck;

public class Test {
	public static void main(String[] args) {
		Goods[] g = new Goods[3];
		g[0] = new Knife();
		g[1] = new RadioactiveGoods();
		g[2] = new Foods();
		Machine m = new Machine();
		//��Ʒ������������Υ����Ʒ��Ӧ�������������
		for(int i = 0;i < g.length;i++) {
			try {
				m.checkBag(g[i]);
			}catch(DangerException e){
				e.toShow();
				System.out.println("��Դ�ǣ�" + g[i].getClass().getName());
			}
		}
	}
}
