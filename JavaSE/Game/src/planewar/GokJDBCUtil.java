package planewar;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GokJDBCUtil {
	/**
	 * 妞瑰崬濮╅崥锟�
	 */
	public static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
	/**
	 * 鏉╃偞甯撮弫鐗堝祦鎼存挸婀撮崸锟�
	 */
	public static final String URL = "jdbc:mysql://localhost:3306/plane_user?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true";
	/**
	 * 閺佺増宓佹惔鎾舵暏閹村嘲鎮�
	 */
	public static final String USERNAME = "root";
	/**
	 * 閺佺増宓佹惔鎾崇槕閻拷
	 */
	public static final String PASSWORD = "333";

	/**
	 * 閺嬪嫰锟界姵鏌熷▔鏇狀潌閺堝瀵�
	 */
	private GokJDBCUtil() {
	}

	/**
	 * 閼惧嘲褰囬弫鐗堝祦鏉╃偞甯�
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			// 閸旂姾娴囨す鍗炲З
			Class.forName(DRIVER_CLASS_NAME);
			// 2.閼惧嘲褰囨潻鐐村复
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	/**
	 * 閸忔娊妫撮惄绋垮彠鐠у嫭绨�
	 * 
	 * @param con
	 *            閺佺増宓佹惔鎾绘懠閹猴拷
	 * @param st
	 *            閺屻儴顕楅幒銉ュ經
	 * @param rs
	 *            缂佹挻鐏夐梿锟�
	 */
	public static void close(Connection con, Statement st, ResultSet rs) {
		try {
			try {
				if (rs != null) {
					rs.close();

					rs = null;
				}
			} finally {
				try {
					if (st != null) {
						st.close();

						st = null;
					}
				} finally {
					if (con != null) {
						con.close();

						con = null;
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 閺屻儴顕楅幐鍥х暰sql閻ㄥ嫮绮ㄩ弸婊堟肠鐠佹澘缍嶉弫甯礉鏉╂柨娲栭崐闂磋礋int缁鐎�
	 * 
	 * @param sql 閺屻儴顕梥ql(閻€劏顓搁弫鎷屼粵閸氬牆鍤遍弫鐗堢叀鐠囷拷)
	 *            
	 * @param args 閸欘垰褰夐崣鍌涙殶
	 *            
	 * @return 鏉╂柨娲栭弶鈩冩殶
	 */
	public static int queryForCount(String sql, Object... args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			for (int i = 0; args != null && i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			while (rs.next()) {
				// 鏉╂柨娲栫粭顑跨鐞涘瞼顑囨稉锟介崚锟�
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}
		return 0;
	}
	
	
	/**
	 * 閸掋倖鏌囩�圭偘缍嬬猾璁宠厬閻ㄥ嫬鐫橀幀褎妲搁崥锕�婀紒鎾寸亯闂嗗棔鑵戠�涙ê婀�(閸掓鎮曠捄鐔风潣閹冩倳閺勵垰鎯佹稉锟介弽锟�)
	 * 
	 * @param rsmd 缂佹挻鐏夐梿鍡欐畱閸忓啩淇婇幁锟�
	 *            
	 * @param fieldName 鐎圭偘缍嬬猾鑽ゆ畱鐏炵偞锟斤拷
	 *            
	 * @return
	 */
	private static boolean isExists(ResultSetMetaData rsmd, String fieldName) {

		try {
			int count = rsmd.getColumnCount();
			for (int i = 0; i < count; i++) {
				// 閼惧嘲褰囧В蹇撳灙閻ㄥ嫬鐡у▓闈涙倳鐎涳拷,鐎涙顔岄惃鍕瑓閺嶅洣绮�1瀵拷婵拷
				String columnName = rsmd.getColumnLabel(i + 1);
				if (columnName.equals(fieldName)) {
					return true;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}

	/**
	 * 閺屻儴顕楁径姘蒋閺佺増宓�(缂佹挻鐏夐梿鍞嶉弶锟�)閿涘苯鐨㈤弻銉嚄缂佹挻鐏夐梿鍡欐畱濮ｅ繑娼拋鏉跨秿鐏忎浇顥婇幋鎰瘹鐎规氨琚崹瀣嚠鐠炩槄绱濇潻鏂挎礀缁鐎锋稉绡杋st
	 * <br/>
	 * 濞夈劍鍓�:鐞涖劎娈戠�涙顔岄弫鐗堝祦缁鐎疯箛鍛淬�忛崪宀�琚惃鍕潣閹勬殶閹诡喚琚崹瀣╃閼凤拷 鐞涖劎娈戦崚妤�鎮曡箛鍛淬�忛崪宀�琚惃鍕潣閹冩倳娑擄拷閺嶏拷
	 * 
	 * @param sql 閺屻儴顕梥ql
	 *            
	 * @param c	缁崵琚崹锟�
	 *            
	 * @param args 閸欘垰褰夐崣鍌涙殶(sql娑擃厼鐢弶鈥叉鐎涙顔岄崐鐓庡祮sql娑擃厾娈�?,婵″倹鐏夊▽鈩冩箒?閸欘垯浜掓稉宥咃綖)
	 *            
	 * @return 鏉╂柨娲栭弻銉嚄缂佹挻鐏夌拋鏉跨秿闂嗗棗鎮嶭ist
	 */
	public static <T> List<T> queryAll(String sql, Class<T> c, Object... args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<T> list = null;
		try {
			con = getConnection();
			ps = con.prepareStatement(sql);
			for (int i = 0; args != null && i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			// 闁俺绻冮崣宥呯殸閼惧嘲褰囩猾鑽ゆ畱閹碉拷閺堝鐫橀幀锟�
			Field fields[] = c.getDeclaredFields();
			list = new ArrayList<T>();
			//閼惧嘲褰囩紒鎾寸亯闂嗗敃s閻ㄥ嫬鍘撻弫鐗堝祦
			ResultSetMetaData rsmd = rs.getMetaData();
			//閹垮秳缍旂紒鎾寸亯闂嗭拷
			while (rs.next()) {
				// 閺嶈宓佺猾鑽よ閸ㄥ鐤勬笟瀣鐎电钖�
				T o = c.newInstance();
				/**
				 * 鐎电钖勯惃鍕潣閹嗙ゴ閸婄》绱濋棁锟界憰浣界殶閻⑩暞et閺傝纭堕敍宀勬付鐟曚浇骞忛崣鏉漞t閺傝纭剁�电钖勯敍宀勬付鐟曚胶鐓￠柆鎼抏t閺傝纭堕崥宥呯摟
				 */
				for (int i = 0; i < fields.length; i++) {
					// 閼惧嘲褰囧В蹇庣娑擃亜鐫橀幀锟�
					Field field = fields[i];
					// 閼惧嘲褰囩�涙顔岄崥宥呯摟
					String fieldName = field.getName();// id--setI d
					// 閼惧嘲褰囩�涙顔岀猾璇茬��
					Class<?> fieldType = field.getType();
					// 閼惧嘲褰噑et閺傝纭堕崥锟�
					String methodName = "set" + (fieldName.charAt(0) + "").toUpperCase() + fieldName.substring(1);
					// 閼惧嘲褰噑et閺傝纭剁�电钖�
					Method method = c.getMethod(methodName, fieldType);

					/**
					 * 濞夈劍鍓伴悙锟�: 1.婵″倹鐏夐弻銉嚄閻ㄥ嫮绮ㄩ弸婊呮畱鐎涙顔岄崥宥呮嫲鐏炵偞锟窖冩倳娑撳秳绔撮弽铚傜窗閹躲儵鏁奤ser(id,name,password) select id,name from t_user
					 * 2.閺佺増宓佹惔鎾广�冮崚妤�鎮曠捄鐒渁va鐎圭偘缍嬬猾璇茬潣閹冩倳娑擄拷閺嶏拷
					 */
					// 閸掋倖鏌囩�涙顔岄弰顖氭儊閸︺劎绮ㄩ弸婊堟肠娑擃厼鐡ㄩ崷锟�(閸掓鎮曠捄鐔风潣閹冩倳閺勵垰鎯佹稉锟介弽锟�)
					if (isExists(rsmd, fieldName)) {// fieldName=category
						// 閺嶈宓佺猾鑽ゆ畱鐏炵偞锟窖冩倳鐎涙骞忛崣鏍х摟濞堢數娈戦崐锟�
						Object value = rs.getObject(fieldName);
						if (value != null) {
							// 鐠嬪啰鏁et閺傝纭堕敍灞筋嚠鐠炩�茶厬閻ㄥ嫬鐫橀幀褑绁撮崐锟�
							method.invoke(o, value);
						}

					}

				}
				// 闂囷拷鐟曚焦濡哥�电钖勯弨鎯у煂List娑擃叏绱濋悞璺烘倵鏉╂柨娲杔ist

				list.add(o);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, ps, rs);
		}

		return list;
	}

	

	/**
	 * 缂佹挻鐏夐張锟芥径锟�1閺壜ゎ唶瑜版洩绱濇潻鏂挎礀閹稿洤鐣剧�电钖勭猾璇茬�烽弫鐗堝祦
	 * 
	 * @param sql  閹稿洤鐣緎ql
	 * @param c	鐎电钖勯惃鍕缁鐎�
	 *            
	 * @param args	閸斻劍锟戒礁寮弫锟�
	 * @return 閹稿洤鐣剧�电钖勭猾璇茬��
	 */
	public static <T> T queryForObject(String sql, Class<T> c, Object... args) {
		List<T> list = queryAll(sql, c, args);//鐠嬪啰鏁ゆ禍鍡樼叀鐠囥垹鍙忛柈銊ф畱閺傝纭�
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;

	}

	/**
	 * <p>
	 * 鐎电銆冮惃鍕杻閸掔姵鏁奸崝鐔诲厴閻ㄥ嫮绮烘稉锟界拫鍐暏濮濄倖鏌熷▔锟�
	 * </p>
	 * 
	 * @param sql	闂囷拷鐟曚焦澧界悰宀�娈慡QL鐠囶厼褰�
	 *            
	 * @param args	?閸欏倹鏆�,鏉╂瑦娼痵ql鐠囶厼褰炲▽鈩冩箒閿涚噦绱濋崣顖欎簰娑撳秶绮伴崐锟�
	 *            
	 * @return 閸欐濂栭崫宥囨畱鐞涘本鏆熼敍娑欐惙娴ｆ粈绗夐幋鎰閿涘矁绻戦崶锟�0
	 */
	public static int update(String sql, Object... args) {
		Connection con = null;

		PreparedStatement ps = null;
		try {
			// 閼惧嘲褰囨潻鐐村复
			con = getConnection();
			// 閸掓稑缂搒tatement鐎电钖�
			ps = con.prepareStatement(sql);

			// 鐠佸墽鐤嗛崣鍌涙殶
			for (int i = 0; args != null && i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}

			// 閹笛嗩攽SQL鐠囶厼褰�
			return ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 閸忔娊妫寸挧鍕爱
			close(con, ps, null);
		}
		return 0;

	}

}
