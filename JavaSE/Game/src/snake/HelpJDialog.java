package snake;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class HelpJDialog extends JDialog {
	public HelpJDialog() {
		//������ʾ���
		JLabel help = new JLabel();
		//�����ʾ��Ϣ
		String s1 = "�������Ϸ��������ģʽ��";
		String s2 = "1����ģʽ�����ģʽ����Ϸ�ٶ����У��߿��Դ�ǽ�������Լ�����;";
		String s3 = "2������ģʽ�����ģʽ����Ϸ�ٶȽϿ죬�߲����Դ�ǽ�������Լ�������";
		String s4 = "������Ϸ������ʳ��ֱ���ƻ�����Ե�ʹ֮��������һ����ҩ���Ե�ʹ֮���ȼ�һ��ը�����Ե���Ϸ����";
		String massage = "<html><body>"
							+ s1 + "<br>" 
							+ s2 + "<br>" 
							+ s3 + "<br>" 
							+ s4 + "<br>"
							+ "</body></html>";
		help.setText(massage);
		//���õ�������
		setVisible(true);
		add(help);
		setBounds(400, 300, 474, 144);
	}
}
