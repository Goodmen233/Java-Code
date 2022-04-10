package firstsubject;

public class NonException {
	
	public static void main(String[] args) {
		String s=null;
		System.out.println("step 1.");
		System.out.println(s.length());
		//出现空指针异常，程序不能正常运行
		System.out.println("step 2.");
		System.out.println("step 3.");
	}	
}
