	package ch3;
	public class PassValueTest {
		private int i = -100;
		public void test1(int b) {
		b = 100;
		}
	
		public void test2(PassValueTest c)   {                         
			// ���ñ���c�Ƿ�������ʽ����������PassValueTest����
			c.i = 100;
		}
	
		public void test3(PassValueTest b) {
			b = this;                      // this��һ�����ñ�����ָ���������
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