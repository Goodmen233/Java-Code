package arrayexception;

public class ArrayExceptionTest {
	public static void main(String[] args) {
		int[] a = new int[5];
		try {
			a[0] = 10;
			a[1] = 10;
			a[2] = 10;
			a[3] = 10;
			a[4] = 10;
			a[5] = 10;
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("����Խ��");
		}finally {
			System.out.println("finally���ִ�У�");
		}
	}
}
