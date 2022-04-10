package employeeSalary;

public class TempEmployee extends Employee {
	//构造方法
	public TempEmployee() {
		
	}
	
	public TempEmployee(String n, String d,double basicpay,double pay) {
		super(n,d,basicpay);
		this.pay = pay;
	}
	
	public double salary() {
		return this.basicpay + this.pay;
	}
}
