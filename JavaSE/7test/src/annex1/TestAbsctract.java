package annex1;
//��ϵͼ��AbsClass��AbsSubClass��SubClass�ĸ��࣬
//��
//1��ɾ��abstract,���������Ϊ�����涨���˳��󷽷��������󷽷�Ҫ�ڳ�������
//2����{}�󣬱��������Ϊ���󷽷������з�����
//3��ɾ�������ͨ������
//4�����������Ϊ�������������Ҫ��д���෽��
//5�����������Ϊ�������4һ��û����д���������ķ���
//��
//���������ΪAbsClass��һ��������,���ܴ�������
//��
//����ͨ������Ϊ��ȻAbsClass��һ�������࣬���ܴ������󣬵����Զ���һ�����á�
//��
//����ͨ������Ϊsc��ac��������Ӧ����ķ�������ac2��Ȼ��AbsClass�ĵ����ã���ʵ������SubClass���ͣ���˿��Ե���acsMethod������
abstract class AbsClass{
	abstract void absMethod();
	void commMethod(){
		System.out.println("I am a common method in a abstract class.");
	}
}
abstract class AbsSubClass extends AbsClass{
	void commMethod3(){
		System.out.println("I am a common method in a abstract sub class.");
	}
}
class SubClass extends AbsClass{
	void absMethod(){
		System.out.println("I am a implemented method in a common sub class.");
	}
}
public class TestAbsctract {
	public static void main(String [] rgs){
		SubClass sc=new SubClass();
		AbsClass ac=new SubClass();
		AbsClass ac2=sc;
		sc.absMethod();
		ac.absMethod();
		ac2.absMethod();
   }
}