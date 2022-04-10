package employeeSalary;

public class EmployeeTest {
	public static void main(String[] args) {
		TempEmployee te1 = new TempEmployee("张三","福建",500,2000);
		System.out.println(te1.name + "的工资是： " + te1.salary());
	}
}
