package geometricattribute;

public class Triangle extends Shape implements GetAttribute {
	private double a, b, c;

	public double getC() {
		return this.a + this.b + this.c;
	}

	public double getV() {
		double l = (a + b + c)/2;
		return Math.sqrt(l * (l - a) * (l - b) * (l - c));
	}

	// getter and setter
	/**
	 * @return a
	 */
	public double getA() {
		return a;
	}

	/**
	 * @param a 要设置的 a
	 */
	public void setA(double a) {
		this.a = a;
	}

	/**
	 * @return b
	 */
	public double getB() {
		return b;
	}

	/**
	 * @param b 要设置的 b
	 */
	public void setB(double b) {
		this.b = b;
	}

	/**
	 * @param c 要设置的 c
	 */
	public void setC(double c) {
		this.c = c;
	}
	
	//构造方法
	public Triangle() {
		super();
	}

	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	
	
}
