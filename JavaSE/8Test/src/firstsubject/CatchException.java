package firstsubject;
//�����ܹ����У���try���������쳣ʱ������ִ��catch�е����
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
