
public class Student {
	private String name;
	private Birthday birthday;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Birthday getBirthday() {
		return birthday;
	}
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
	public void print() {
		System.out.println("The name is " + this.name + ",The birthday is " + birthday.getYear() + "," + birthday.getMonth() + "," + birthday.getDay());
	}
	Student(){
		this.name = "default";
		this.birthday = new Birthday();
	}
	Student(String name,MyDate myDate){
		this.name = name;
		Birthday b = new Birthday();
		b.setYear(myDate.getYear());
		b.setMonth(myDate.getMonth());
		b.setDay(myDate.getDay());
		this.birthday = b;
	}
	Student(String name,int year,int month,int day){
		this.name = name;
		this.birthday = new Birthday(year,month,day);
	}
}
