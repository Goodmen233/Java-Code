package test;

class Bird {
	String name;

	Bird(String n) {
		name = n;
	}

	public void fly() {
		System.out.println(name + " fly as bird");
	}

	public void shout() {
		System.out.println(name + " shout as bird");
	}

	public void shout(int number) {
		System.out.println(name + " shout " + number + " times as bird");
	}
}

class Swan extends Bird {
	Swan(String n) {
		super(n);
	}

	public void fly() {
		System.out.println(name + " fly as Swan");
	}

	public void shout() {
		System.out.println(name + " shout as Swan");
	}

	public void swim() {
		System.out.println(name + " swim as Swan");
	}
}

class Duck extends Bird {
	Duck(String n) {
		super(n);
	}

	public void fly() {
		System.out.println(name + " fly as Duck");
	}

	public void shout() {
		System.out.println(name + " shout as Duck");
	}

	public void swim() {
		System.out.println(name + " swim as Duck");
	}
}

public class TestM {
	public static void main(String[] args) {
	    Bird b1 = new Bird("小小鸟");
	    Bird b2 = new Swan("小天鹅");
	    Bird b3 = new Duck("唐老鸭");
	    
	    /*分析以下语句编译错误的原因*/
	    //原因：b1，b2,b3都是Bird类，而此类中没有swim的方法
	    //b1.swim();
	    //b2.swim();
	    //b3.swim();
	    //(Duck)b3.swim();      
	    /****************************/
	    
	    /*先分析以下语句的运行结果，再执行验证*/    	
	    b1.fly();
	    b2.fly();
	    b3.fly();
	    
	    b1.shout(1);
	    b2.shout(2);
	    b3.shout(3);
	    
	 
	    Swan s2=(Swan)b2;
	    s2.swim();    
	    //b1是Bird类型，不能转换为Swan类型
	    s2=(Swan)b1;
	    s2.swim();
	    //b3是Duck类型，不能转换为Swan类型
	    s2=(Swan)b3;
	    s2.swim();     

	    ((Duck)b3).swim();	
	    /****************************/    	
	  }
}
