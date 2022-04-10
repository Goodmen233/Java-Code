package userregister;

public class UserService {
	private String username, password;

	public void register(String username, String password) throws RegisterException {
		if (username.length() < 6 || username.length() > 14) {
			throw new RegisterException("注册的用户名不合法!");
		}
		this.username = username;
		this.password = password;
		System.out.println("恭喜你，注册成功！");
	}

	public UserService() {
		super();
	}
	
	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username 要设置的 username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 要设置的 password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
