package day2;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo {
	// �洢�˻���Ϣ
	static ArrayList<BankUser> userList = new ArrayList<BankUser>();
	// ��¼��ǰ��¼�ɹ����˻�
	static BankUser usingAccount;
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		init();
		while(true) {
			System.out.println("--------------------------------------");
			if(usingAccount == null) {
				System.out.println("����ʹ��xx����ϵͳ");
			}else {
				System.out.println("��ӭ" +  usingAccount.getAccount() + "ʹ��xx����ϵͳ");
			}				
			System.out.println("1.��¼ 2.�û���Ϣ��ѯ 3.�û���Ϣ�޸� 4.��ѯ���");
			System.out.println("5.ʵ��ת�� 6.ȡǮ 7.��Ǯ 8.ע�� 9.�˳�");
			System.out.print("��������Ҫ���ܶ�Ӧ�����֣�");
			int num = sc.nextInt();
			// ƥ������
			switch (num) {
			case 1 : login(); break;
			case 2 :showMessege(); break;
			case 3 :alterMessege(); break;
			case 4 :showMoney(); break;
			case 5 :transferBills(); break;
			case 6 :getMoney(); break;
			case 7 :setMoney(); break;
			case 8 :register(); break;
			case 9 :exit(); break;
			default: System.out.println("���벻�Ϸ����������룡");
			}
		}
	}
	
	// ��ʼ�������˻�����
	public static void init() {
		userList.add(0, new BankUser("123", "132695", 21, "123", 1000));
		userList.add(1, new BankUser("456", "456123", 58, "456", 1000));
	}
	
	// 1.��¼
	public static void login() {
		while(true) {
			System.out.print("�������˺ţ�");
			String account = sc.next();
			// ���αȽ��ж��˺��Ƿ����
			for(int i = 0; i < userList.size(); i++) {
				// ����˺Ŵ���
				if(userList.get(i).getAccount().equals(account)) {
					do {
						//���û���������
						System.out.print("��������˺ŵ����룺");
						String password = sc.next();
						if(userList.get(i).getPassword().equals(password)) {
							System.out.println("��¼�ɹ���");
							usingAccount = userList.get(i);
							return;
						}else {
							System.out.println("����������������룡");
							System.out.print("�˳������밴1����������������룺");
							int num = sc.nextInt();
							if(num == 1) return;
							else  continue;
						}
					}while(true);
				}
			}
			// ����˺Ų�����
			System.out.println("�˺Ų����ڣ����˳�ע����������룡");
			System.out.print("�˳�ע���밴1������������������룺");
			int num = sc.nextInt();
			if(num == 1) return;
			else  continue;
		}
	}
	
	// 2.��ѯ�û���Ϣ
	public static void showMessege(){
		if(usingAccount != null) {
			System.out.println(usingAccount);
		}else {
			System.out.println("���ȵ�¼��");
		}
	}
	
	// 3.�û���Ϣ�޸�
	public static void alterMessege() {
		if(usingAccount != null) {
			System.out.println("������Ҫ�޸ĵ��˻���Ϣ(Ŀǰֻ���޸����������͵绰)��");
			System.out.println("�޸���������age,�޸�����������password���޸ĵ绰����tel");
			String s = sc.next();
			if("age".equals(s)) {
				System.out.print("������Ҫ�޸ĵ����䣺");
				int age = sc.nextInt();
				usingAccount.setAge(age);
				System.out.println("�޸ĳɹ���");
			}else if("password".equals(s)) {
				System.out.print("�������޸ĺ�����룺");
				String password = sc.next();
				usingAccount.setPassword(password);
				System.out.println("�޸ĳɹ���");
			}else if("tel".equals(s)) {
				System.out.println("�������޸ĺ�ĵ绰��");
				String tel = sc.next();
				usingAccount.setTel(tel);
				System.out.println("�޸ĳɹ���");
			}else {
				System.out.println("���벻�Ϸ����޸�ʧ��");
			}	
		}else {
			System.out.println("���ȵ�¼��");
		}
	}
	
	// 4.��ѯ���
	public static void showMoney() {
		if(usingAccount != null) {
			System.out.println("��ǰ�˻������Ϊ��" + usingAccount.getMoney() + "Ԫ");
		}else {
			System.out.println("���ȵ�¼��");
		}
	}
	
	// 5.ת��
	public static void transferBills() {
		if(usingAccount != null) {
			System.out.print("������Ҫת�˵��˺�(�����ڱ����е��˺�)��");
			String account = sc.next();
			// �鿴������˺��Ƿ����
			for(int i = 0; i < userList.size(); i++) {
				// �˺Ŵ���
				if(account.equals(userList.get(i).getAccount())) {
					System.out.print("����Ҫת�˵���Ŀ��");
					int money = sc.nextInt();
					// ת��ǮС�����
					if(money < usingAccount.getMoney()) {
						usingAccount.setMoney(usingAccount.getMoney() - money);
						userList.get(i).setMoney(userList.get(i).getMoney() + money);
						System.out.println("ת�˳ɹ���");
					}else System.out.println("���㣬ת��ʧ�ܣ�");
						
				}
			}
			// ���û���������˺š���
			//...
		}else {
			System.out.println("���ȵ�¼��");
		}
	}
	
	// 6.ʵ��ȡǮ
	public static void getMoney() {
		if(usingAccount != null) {
			System.out.print("������Ҫȡ��Ǯ��");
			int money = sc.nextInt();
			if(money < usingAccount.getMoney()) {
				usingAccount.setMoney(usingAccount.getMoney() - money);
				System.out.println("ȡǮ�ɹ���");
			}else 
				System.out.println("���㣬ȡǮʧ��");
		}else {
			System.out.println("���ȵ�¼��");
		}
	}
	
	// 7.ʵ�ִ�Ǯ
	public static void setMoney() {
		if(usingAccount != null) {
			System.out.print("������Ҫ���Ǯ��");
			int money = sc.nextInt();
			usingAccount.setMoney(usingAccount.getMoney() + money);
			System.out.println("��Ǯ�ɹ���");
		}else {
			System.out.println("���ȵ�¼��");
		}
	}
	
	// 8.ע��
	public static void register() {
		while(true) {
			System.out.print("������ע����˺ţ�");
			String account = sc.next();
			boolean isRepeat = false;
			// ���αȽ��ж��˺��Ƿ����
			for(int i = 0; i < userList.size(); i++) {
				// ����˺Ŵ���
				if(userList.get(i).getAccount().equals(account)) {
					System.out.println("�˺��Ѵ��ڣ�����������һ���˺�");
					isRepeat = true;
					break;
				}
			}
			// ����˺Ų����ظ��ģ�ʵ��ע��
			if(!isRepeat) {
				System.out.print("���趨���˺ŵ����룺");
				String password = sc.next();
				userList.add(new BankUser(account, password));
				System.out.println("�˺�����ע��ɹ���������Ϣ��¼���������ƣ�");
				return;
			}
		}
	}
	
	// 9.�˳�
	public static void exit() {
		if(usingAccount != null) {
			System.out.println("�˳��ɹ���");
			usingAccount = null;
		}else {
			System.out.println("���ȵ�¼��");
		}
	}
	
	
	
	
}
