package arraylinkedlistcompare;
public class Employee{
	public String name;
	public String department;
	public double basicpay;
	public double pay;

	Employee(){
		this("default", "default department", 0.0);
	}

	Employee(String n, String d, double bp){
		name=n;  
		department=d;
		basicpay=bp;
	}
	public double getPay(){
		pay=basicpay;	
		return pay;
	}
	public String toString(){	
		return "name:"+name+" department:"+department+" pay:"+getPay();
	}
}