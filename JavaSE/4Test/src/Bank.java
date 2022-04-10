
public class Bank {

	public static void main(String[] args) {
		BankAccount ba = new BankAccount(123456,500);
		ba.savemoney(1000);
		ba.getmoney(2000);
		ba.getleftmoney();
	}
}
class BankAccount {
	private int account_number,leftmoney;
	//构造方法
	BankAccount(){
	};
	BankAccount(int a,int b){
		this.account_number = a;
		this.leftmoney = b;
	}
	//getter and setter
	public int getAccount_number() {
		return account_number;
	}
	public void setAccount_number(int account_number) {
		this.account_number = account_number;
	}
	public int getLeftmoney() {
		return leftmoney;
	}
	public void setLeftmoney(int leftmoney) {
		this.leftmoney = leftmoney;
	}
	//
	void savemoney(int a) {
		setAccount_number(this.leftmoney +=a);
	}
	void getmoney(int a) {
		this.leftmoney = this.leftmoney -a;
	}
	void getleftmoney() {
		System.out.println(this.leftmoney);
	}
}