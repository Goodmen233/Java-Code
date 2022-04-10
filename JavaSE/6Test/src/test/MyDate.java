package test;

public class MyDate {
	private int year;
	private int month;
	private int day;
	//构造方法
	MyDate() {
		this(1970, 1, 1);
	}

	MyDate(int year, int month, int day) {
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//getter and setter
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}
	//重写toString和equals
	public boolean equals(MyDate myDate) {
		boolean flag = false;
		if(this.year == myDate.year && this.month == myDate.month && this.day == myDate.day) {
			System.out.println("两个日期是相同的");
			return flag = true;
		}else {
			System.out.println("两个日期是不同的");
			return flag;
		}
	}

	public String toString() {
		return "The date is " + this.year + "," + this.month + "," + this.day;
	}
	
}
