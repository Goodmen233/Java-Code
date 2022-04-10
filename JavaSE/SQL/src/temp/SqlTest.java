package temp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

/**
 * ����jar��������ճ������Ŀ�£�Ȼ��build path��add��
 * ʹ�ã�
 * 	1.��ȡ���ӣ�
 * @author Shabiy
 *
 */

public class SqlTest {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
		// 1.��ȡ����
		//	1.1��������
			Class.forName("com.mysql.cj.jdbc.Driver");
		//	1.2׼������
			String url = "jdbc:mysql://localhost:3306/hero_sys?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
			String name = "root";
			String password= "333";
		// 	1.3��ȡ����,�൱��navicat���������ݿ�
			conn = DriverManager.getConnection(url, name, password);
		// 2.��sql�Ի�,��ִ��sql���
			String sql = "update hero set hp = ? where name = ?";
			ps= conn.prepareStatement(sql);
			ps.setInt(1, 2000);
			ps.setString(2, "�ܲ�");
			ps.executeUpdate();// update��ɾ��
			
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
