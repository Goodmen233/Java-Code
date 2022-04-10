package hotel;

public class Test {
	public static void main(String[] args) {
		Hotel hotel = new Hotel();
		hotel.book(21);
		hotel.book(32);
		hotel.check();
		hotel.book(11);
		hotel.check();
	}
}
