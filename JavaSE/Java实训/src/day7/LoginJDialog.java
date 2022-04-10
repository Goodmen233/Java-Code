package day7;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class LoginJDialog extends JDialog {
	public LoginJDialog() {
		
	}
	/**
	 * 构造方法传参，true登录成功，false登录失败
	 */
	public LoginJDialog(boolean isSucc) {
		if(isSucc) {
			JLabel tips = new JLabel("登录成功");
			this.setBounds(200, 200, 100, 100);
			this.add(tips);
			this.setVisible(true);
		}else {
			JLabel tips = new JLabel("登录失败");
			this.setBounds(200, 200, 100, 100);
			this.add(tips);
			this.setVisible(true);
		}
	}
}
