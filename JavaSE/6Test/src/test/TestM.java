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
	    Bird b1 = new Bird("СС��");
	    Bird b2 = new Swan("С���");
	    Bird b3 = new Duck("����Ѽ");
	    
	    /*������������������ԭ��*/
	    //ԭ��b1��b2,b3����Bird�࣬��������û��swim�ķ���
	    //b1.swim();
	    //b2.swim();
	    //b3.swim();
	    //(Duck)b3.swim();      
	    /****************************/
	    
	    /*�ȷ��������������н������ִ����֤*/    	
	    b1.fly();
	    b2.fly();
	    b3.fly();
	    
	    b1.shout(1);
	    b2.shout(2);
	    b3.shout(3);
	    
	 
	    Swan s2=(Swan)b2;
	    s2.swim();    
	    //b1��Bird���ͣ�����ת��ΪSwan����
	    s2=(Swan)b1;
	    s2.swim();
	    //b3��Duck���ͣ�����ת��ΪSwan����
	    s2=(Swan)b3;
	    s2.swim();     

	    ((Duck)b3).swim();	
	    /****************************/    	
	  }
}
