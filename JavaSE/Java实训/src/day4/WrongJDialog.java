package day4;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class WrongJDialog extends JDialog {
	public WrongJDialog() {
		JLabel help = new JLabel();
		String s1 = "�˺Ż�������������µ�¼����֪�����룿�࿴��Դ�����";
		String s2 = "��Ȼ���㷢�ֵİ������棡���ǿ���Ʒ�����ɻ���ս��boss��л�ƽ�ȵ���Ϸ�������������";
		String massage = "<html><body>"
				+ s1 + "<br>" 
				+ s2 + "<br>" 
				+ "</body></html>";
		help.setText(massage);
		this.add(help);
		this.setVisible(true);
		this.setBounds(200, 200, 600, 200);
	}
}
