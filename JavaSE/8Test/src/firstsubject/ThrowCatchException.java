package firstsubject;
//���������쳣ִ��catch�е���䣬�����ֶ��׳���һ���쳣����Ϣ
//��ɾ��throws Exception�󷽷���û�ж��ֶ��׳����쳣���д������Իᱨ��
class ThrowCatchException{
	public static void main(String[] args)throws Exception{
		String s=null;
		System.out.println("step 1.");
		try{
			System.out.println(s.length());
			System.out.println("step 2.");
		}catch(Exception e){
			throw new Exception("here,"+e.getMessage());
		}
		System.out.println("step 3.");
	}
}
