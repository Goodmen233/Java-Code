package userregister;

public class UserService {
	private String username, password;

	public void register(String username, String password) throws RegisterException {
		if (username.length() < 6 || username.length() > 14) {
			throw new RegisterException("ע����û������Ϸ�!");
		}
		this.username = username;
		this.password = password;
		System.out.println("��ϲ�㣬ע��ɹ���");
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
	 * @param username Ҫ���õ� username
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
	 * @param password Ҫ���õ� password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

}
