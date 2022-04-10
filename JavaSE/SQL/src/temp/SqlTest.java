package temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

/**
 * 导入jar包（复制粘贴到项目下，然后build path，add）
 * 使用：
 * 	1.获取连接：
 * @author Shabiy
 *
 */

public class SqlTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		// 1.获取连接
		//	1.1加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
		//	1.2准备参数
			String url = "jdbc:mysql://localhost:3306/hero_sys?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
			String name = "root";
			String password= "333";
		// 	1.3获取连接,相当于navicat的连接数据库
			conn = DriverManager.getConnection(url, name, password);
		// 2.与sql对话,并执行sql语句
			String sql = "update hero set hp = ? where name = ?";
			ps= conn.prepareStatement(sql);
			ps.setInt(1, 2000);
			ps.setString(2, "曹操");
			ps.executeUpdate();// update增删改
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
}
