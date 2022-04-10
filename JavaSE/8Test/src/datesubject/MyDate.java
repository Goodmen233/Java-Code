package datesubject;

public class MyDate {
	private int year, month, day;

	MyDate() throws InvalidDateException {
		this(1970, 1, 1);
	}

	MyDate(int y, int m, int d) throws InvalidDateException {
		if(y < 1 || (m < 1 || m > 12) || (d < 1 || d > 31)) {
			throw new InvalidDateException("��ʼֵ���ò��Ϸ���");
		}
		this.year = y;
		this.month = m;
		this.day = d;
	}

	/**
	 * @return year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year Ҫ���õ� year
	 * @throws InvalidDateException 
	 */
	public void setYear(int year) throws InvalidDateException {
		if(year < 1) {
			throw new InvalidDateException("������ò��Ϸ���");
		}
		this.year = year;
	}

	/**
	 * @return month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month Ҫ���õ� month
	 * @throws InvalidDateException 
	 */
	public void setMonth(int month) throws InvalidDateException {
		if(month < 1 || month > 12) {
			throw new InvalidDateException("�·����ò��Ϸ���");
		}
		this.month = month;
	}

	/**
	 * @return day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day Ҫ���õ� day
	 * @throws InvalidDateException 
	 */
	public void setDay(int day) throws InvalidDateException {
		if(day < 1 || day > 31) {
			throw new InvalidDateException("�������ò��Ϸ���");
		}
		this.day = day;
	}
	
}