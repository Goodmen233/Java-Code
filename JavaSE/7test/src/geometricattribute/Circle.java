package geometricattribute;

public class Circle extends Shape implements GetAttribute{
	private double radius;
	
	
	public Circle() {
		super();
	}

	public Circle(double radius) {
		super();
		this.radius = radius;
	}

	/**
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}

	/**
	 * @param radius ÒªÉèÖÃµÄ radius
	 */
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double getC() {
		return 2 * Math.PI * this.radius;
	}

	@Override
	public double getV() {
		return Math.PI * this.radius * this.radius;
	}
	
}
