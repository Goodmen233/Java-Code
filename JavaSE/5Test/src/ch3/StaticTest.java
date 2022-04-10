package ch3;
	public class StaticTest {
		public static void call1(){
			staticmethod();
	//		nonstaticmethod();    
		}
	
		public static void call2(StaticTest o1){
			o1.nonstaticmethod();
			StaticTest o2=new StaticTest ();
			o2.nonstaticmethod();
		}
	
		
		public void nonstaticmethod(){
			System.out.println("非静态方法被调用");
		}
	
		public static void staticmethod(){
			System.out.println("静态方法被调用");
		}
	
		public static void main(String[] arg){
			StaticTest obj=new StaticTest ();
			StaticTest.call1();
			StaticTest.call2(obj);
		}
	}