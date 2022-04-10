package annex1;
//关系图：AbsClass是AbsSubClass和SubClass的父类，
//三
//1、删掉abstract,编译出错，因为类里面定义了抽象方法，而抽象方法要在抽象类中
//2、加{}后，编译出错，因为抽象方法不能有方法体
//3、删除后可以通过编译
//4、编译出错，因为抽象类的子类需要重写父类方法
//5、编译出错，因为改名后和4一样没有重写父类抽象类的方法
//四
//编译出错，因为AbsClass是一个抽象类,不能创建对象
//五
//编译通过，因为虽然AbsClass是一个抽象类，不能创建对象，但可以定义一个引用。
//六
//编译通过，因为sc和ac都调用相应的类的方法，而ac2虽然是AbsClass的的引用，但实际上是SubClass类型，因此可以调用acsMethod方法。
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