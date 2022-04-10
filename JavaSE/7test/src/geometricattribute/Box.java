package geometricattribute;

public class Box extends Shape implements GetAttribute{
	private double length,wide;

	/**
	 * @return length
	 */
	public double getLength() {
		return length;
	}

	/**
	 * @param length 要设置的 length
	 */
	public void setLength(double length) {
		this.length = length;
	}

	/**
	 * @return weight
	 */
	public double getWeight() {
		return wide;
	}

	/**
	 * @param weight 要设置的 weight
	 */
	public void setWeight(double wide) {
		this.wide = wide;
	}

	public Box() {
		super();
	}

	public Box(double length, double wide) {
		super();
		this.length = length;
		this.wide = wide;
	}

	public double getC() {
		
		return 2 * (this.length + this.wide);
	}

	@Override
	public double getV() {
		return this.length * this.wide;
	}
	
	
}
