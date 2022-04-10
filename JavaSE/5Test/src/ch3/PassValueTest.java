	package ch3;
	public class PassValueTest {
		private int i = -100;
		public void test1(int b) {
		b = 100;
		}
	
		public void test2(PassValueTest c)   {                         
			// 引用变量c是方法的形式参数，属于PassValueTest类型
			c.i = 100;
		}
	
		public void test3(PassValueTest b) {
			b = this;                      // this是一个引用变量，指向对象自身。
		}
	
		public static void main(String[] args) {
			PassValueTest obj = new PassValueTest();
			int temp = 1;
			obj.test1(temp);
			System.out.println(temp);
		
			obj.test2(obj);
			System.out.println(obj.i);
				
			obj.i=100;
			PassValueTest newobj = new PassValueTest();
			obj.test3(newobj);
			System.out.println(newobj.i);
		}
	}