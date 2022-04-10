package firstsubject;
//程序遇到异常执行catch中的语句，其中手动抛出了一个异常的信息
//当删除throws Exception后方法中没有对手动抛出的异常进行处理，所以会报错
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
