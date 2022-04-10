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
	 * @param a Ҫ���õ� a
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
	 * @param b Ҫ���õ� b
	 */
	public void setB(double b) {
		this.b = b;
	}

	/**
	 * @param c Ҫ���õ� c
	 */
	public void setC(double c) {
		this.c = c;
	}
	
	//���췽��
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
