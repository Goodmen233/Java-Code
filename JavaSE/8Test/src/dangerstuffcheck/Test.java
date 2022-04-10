package dangerstuffcheck;

public class Test {
	public static void main(String[] args) {
		Goods[] g = new Goods[3];
		g[0] = new Knife();
		g[1] = new RadioactiveGoods();
		g[2] = new Foods();
		Machine m = new Machine();
		//物品数组里有两个违禁物品，应该输出两次提醒
		for(int i = 0;i < g.length;i++) {
			try {
				m.checkBag(g[i]);
			}catch(DangerException e){
				e.toShow();
				System.out.println("来源是：" + g[i].getClass().getName());
			}
		}
	}
}
