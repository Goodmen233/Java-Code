package planewar;

import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Leaderboard extends JFrame {
	public Leaderboard() {
		// 遍历数据库，找出排行
		String sql = "select * from user order by score desc";
		List<Player> playerList = GokJDBCUtil.queryAll(sql, Player.class);
		// 设置组件来显示
		JTextArea j = new JTextArea();
		j.append("名称\t分数\n");
		Iterator<Player> it = playerList.iterator();
		while(it.hasNext()) {
			Player p = it.next();
			j.append(p.getName() + "\t" + p.getScore() + "\n");
		}
		
		// 设置窗口属性
		this.add(j);
		this.setBounds(700, 200, 150, 654);
		this.setTitle("排行榜");
		this.setResizable(false);
		this.setVisible(true);
	
			
	}
}
