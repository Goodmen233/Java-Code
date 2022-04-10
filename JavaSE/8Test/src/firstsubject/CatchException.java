package firstsubject;
//程序能够运行，当try语句块中有异常时，程序执行catch中的语句
public class CatchException{	
	public static void main(String[] args) {
		String s=null;
		System.out.println("step 1.");
		try{
			System.out.println(s.length());
			System.out.println("step 2.");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		System.out.println("step 3.");
	}
}
