package com.huaqiao.cmd;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Util {	
//-----------------------------用户界面------------------------------------	
	/**
	 * 可借阅的书
	 * @return 可借阅的书的集合
	 */
	public static List<Books> lendableBooks() {
		String sql = "select * from books where leftnumber<>0";
		return GokJDBCUtil.queryAll(sql, Books.class);
	}

	
	/**
	 * 借书
	 * @param id 书的id
	 * @param user	用户	
	 * @return 返回真则借书成功，反之借书失败
	 */
	public static boolean lendBooks(int id, User user) {
		String sql = "select * from books where id=?";
		Books books = GokJDBCUtil.queryForObject(sql, Books.class, id);
		// 判断书是否存在
		if(books != null) {
			int num = books.getLeftnumber();
			// 判断剩余书的数量是否大于零
			if(num > 0) {
				// 判断是否借阅未还
				String sql2 = "select * from iobook where id=? and readerid=? and state='未还'";
				int row = GokJDBCUtil.queryForCount(sql2, id, user.getUserid());
				if(row == 0) {
					// 没有借阅未还则书的剩余数量减一
					String sql1 = "update books set leftnumber=? where id=?";
					GokJDBCUtil.update(sql1, num - 1, id);
					// 在iobook中自动生成借阅日期
					// 借阅时间在12月时有bug，年分会错
					Date lendDate = new Date();
					// 生成现在的日期
					Calendar rightNow = Calendar.getInstance();
					rightNow.setTime(lendDate);
					rightNow.add(Calendar.MONTH, 1);
					Date returnDate = rightNow.getTime();
					// 归还日期设置为一个月后
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String lendedDate = sdf.format(lendDate);
					String returnedDate = sdf.format(returnDate);
					String sql3 = "insert into iobook values(?,?,?,?,?,?)";
					GokJDBCUtil.update(sql3, id, lendedDate, returnedDate, "未还", user.getName(), user.getUserid());
					return true;
				}else return false;
			// 有同本书借阅未还，返回false
			}else return false;
		}
		// 书不存在，返回false
		return false;
	}
	
	
	/**
	 * 用户已借阅（可归还）的书
	 * @param user	用户
	 * @return 返回可归还书的列表
	 */
	public static List<IOBook> returnableBooks(User user) {
		String sql = "select * from iobook where readerid=? and state = '未还'";
		return GokJDBCUtil.queryAll(sql, IOBook.class, user.getUserid());
	}
	
	
	/**
	 * 还书
	 * @param bookId	书的id
	 * @param userId	用户的id
	 * @return	返回true则还书成功，反之失败
	 */
	public static boolean returnBooks(int bookId, int userId) {
		// 获取当前的日期
		Date returnDate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String returnedDate = sdf.format(returnDate);
		// 将iobook表中的state改为“已还”
		String sql = "update iobook set returntime=?, state=? where id=? and readerid=?";
		int row = GokJDBCUtil.update(sql, returnedDate, "已还", bookId, userId);
		// 判断修改是否执行
		if(row != 0) {
			// 将books表中的leftnumber加一
			String sql1 = "select * from books where id=?";
			Books books = GokJDBCUtil.queryForObject(sql1, Books.class, bookId);
			String sql2 = "update books set leftnumber = ? where id =?";
			int row0 = GokJDBCUtil.update(sql2, books.getLeftnumber() + 1,bookId);
			return true;
		}
		// 执行失败返回false
		return false;
		
	}
//----------------------------管理员界面------------------------------------------
	/**
	 * 删除书
	 * @param id	书的id
	 * @return	返回true则删除成功，反之删除失败
	 */
	public static boolean deleteB(int id) {
		String sql = "delete from books where id=?";
		int row = GokJDBCUtil.update(sql, id);
		if(row > 0) return true;
		return false;
		
	}
	
	/**
	 * 修改书的信息
	 * @param key	要修改的键
	 * @param value	改为的值
	 * @param id	书的id
	 * @return	返回true则修改成功，反之修改失败
	 */
	public static boolean updateB(String key, String value, int id) {
		if("bookname".equals(key)) {
			String sql = "update books set bookname=? where id=?";
			int row = GokJDBCUtil.update(sql,value, id);
			if(row > 0) return true;
			return false;
		}else if("author".equals(key)) {
			String sql = "update books set author=? where id=?";
			int row = GokJDBCUtil.update(sql,value, id);
			if(row > 0) return true;
			return false;
		}else if("addtime".equals(key)) {
			String sql = "update books set addtime=? where id=?";
			int row = GokJDBCUtil.update(sql,value, id);
			if(row > 0) return true;
			return false;
		}else if("leftnumber".equals(key)) {
			String sql = "update books set leftnumber=? where id=?";
			int value0 = Integer.parseInt(value);
			int row = GokJDBCUtil.update(sql,value0, id);
			if(row > 0) return true;
			return false;
		}else
			return false;
	}
	
	/**
	 * 增加书
	 * @param bookname	书的名字
	 * @param author	书的作者
	 * @param leftnumber	书的数量
	 * @return	返回true则增加成功，反之增加失败
	 */
	public static boolean insertB(String bookname, String author, int leftnumber) {
		String sql = "insert into books values(0,?,?,?,?)";
		// 自动生成当前日期
		Date date0 = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(date0);
		int row = GokJDBCUtil.update(sql, bookname, author, date, leftnumber);
		if(row > 0) return true;
		return false;
	}
	
	/**
	 * 返回所有书的列表
	 * @return	返回所有书的列表
	 */
	public static List<Books> selectB() {
		String sql = "select * from books order by id desc";
		return GokJDBCUtil.queryAll(sql, Books.class);
	}
	
	
	/**
	 * 删除用户
	 * @param userid	用户的id
	 * @return	返回true则删除成功，反之删除失败
	 */
	public static boolean deleteU(int userid) {
		String sql = "delete from user where userid=?";
		int row = GokJDBCUtil.update(sql, userid);
		if(row > 0) return true;
		return false;
	}
	
	/**
	 * 更新用户数据
	 * @param key	要更新的键
	 * @param value	改为的值
	 * @param userid	用户的id
	 * @return	返回true则更新成功，反之更新失败
	 */
	public static boolean updateU(String key, String value, int userid) {
		if("code".equals(key)) {
			String sql = "update user set code=? where userid=?";
			int row = GokJDBCUtil.update(sql, value, userid);
			if(row > 0) return true;
			return false;
		}else if("type".equals(key)) {
			String sql = "update user set type=? where userid=?";
			int row = GokJDBCUtil.update(sql, value, userid);
			if(row > 0) return true;
			return false;
		}else if("name".equals(key)) {
			String sql = "update user set name=? where userid=?";
			int row = GokJDBCUtil.update(sql, value, userid);
			if(row > 0) return true;
			return false;
		}else if("phone".equals(key)) {
			String sql = "update user set phone=? where userid=?";
			int row = GokJDBCUtil.update(sql,value, userid);
			if(row > 0) return true;
			return false;
		}else if("sex".equals(key)) {
			String sql = "update user set sex=? where userid=?";
			int row = GokJDBCUtil.update(sql,value, userid);
			if(row > 0) return true;
			return false;
		}else
			return false;
	}
	
	/**
	 * 返回所有用户的列表
	 * @return 返回所有用户的列表
	 */
	public static List<User> selectU() {
		String sql = "select * from user order by type desc";
		return GokJDBCUtil.queryAll(sql, User.class);
	}
	
	/**
	 * 返回借书的所有历史
	 * @return
	 */
	public static List<IOBook> history(){
		String sql = "select * from iobook";
		return GokJDBCUtil.queryAll(sql, IOBook.class);
	}
	/**
	 * 返回指定对象的历史记录
	 * @param target 指定的对象(可以输入“readerid”、“id”)
	 * @param id  对象id
	 * @return 返回包含该对象历史记录的list集合
	 */
	public static List<IOBook> namedHis(String target,int id){
		if("readerid".equals(target)) {
			String sql = "select * from iobook where readerid=? ";
			return GokJDBCUtil.queryAll(sql, IOBook.class,id);
		}else if("id".equals(target)){
			String sql = "select * from iobook where id=? ";
			return GokJDBCUtil.queryAll(sql, IOBook.class,id);
		}else {
			return null;
		}
	}
	
	
//---------------------------------------其他------------------------
	/**
	 * 关键词检索
	 * bookname、author支持模糊查询
	 * @param type	检索的类型：bookname、author
	 * @param keyword 关键词
	 * @return	返回带有关键字列表的集合，没有返回null
	 */
	public static List<Books> keyCheck(String type, String keyword) {
		if("bookname".equals(type)) {
			String sql = "select * from books where bookname like ?";
			return GokJDBCUtil.queryAll(sql, Books.class, "%"+keyword+"%");
		}else if("author".equals(type)) {
			String sql = "select * from books where author like ?";
			return GokJDBCUtil.queryAll(sql, Books.class, "%"+keyword+"%");
		}else {
			return null;
		}
	}
	/**
	 * 关键词搜索
	 * 仅支持id查找
	 * @param keyword  输入书籍的id
	 * @return	返回该id的书籍
	 */
	public static List<Books> keyCheck(int keyword){
		String sql = "select * from books where id=?";
		return GokJDBCUtil.queryAll(sql, Books.class,keyword);
	}
	
	/**
	 * 用户登录
	 * @param userid 账号
	 * @param code	密码
	 * @return 	返回User的对象则成功，返回空则失败
	 */
	public static User login(int userid, String code) {
		String sql = "select * from user where userid=? and code=?";
		User user = GokJDBCUtil.queryForObject(sql, User.class, userid, code);
		// user不为空则返回对象
		if(user != null) {
			return user;
		}
		// 为空则返回null
		return null;
	}
	
	
	/**
	 * 注册
	 * @param userid	账号
	 * @param code	密码
	 * @return 注册成功则返回true，反之则返回false
	 */
	public static boolean register(int userid, String code) {
		String sql = "select * from user where userid=?";
		User user = GokJDBCUtil.queryForObject(sql, User.class, userid);
		// 判断账号是否已经存在
		if(user == null) {
			String sql1 = "insert into user (userid, code) values(?,?)"; 
			GokJDBCUtil.update(sql1, userid, code);
			return true;
		}
		//若存在则返回false
		return false;
	}
	/**
	 * 一次性注册用户所有信息，默认为用户类型
	 * @param userid	用户账号
	 * @param code		用户密码
	 * @param name		用户姓名
	 * @param phone		用户电话
	 * @param sex		用户性别
	 * @return 注册成功则返回true，反之则返回false
	 */
	public static boolean register(int userid,String code,String name,String phone,String sex) {
		String sql = "select * from user where userid=?";
		User user = GokJDBCUtil.queryForObject(sql, User.class, userid);
		// 判断账号是否已经存在
		if(user == null) {
			String sql1 = "insert into user values(?,?,'用户',?,?,?)"; 
			GokJDBCUtil.update(sql1, userid, code,name,phone,sex);
			return true;
		}
		//若存在则返回false
		return false;
	}

}
