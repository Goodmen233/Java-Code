class Bird {
  String name;
  Bird(String n) {
    name = n;
  }

  final public void fly() {
    System.out.println(name + " fly as bird");
  }

  public void fly(int number) {
    System.out.println(name + " fly " + number + " times as bird");
  }

  protected void shout() {
    System.out.println(name + " shout as bird");
  }

  private void shout(int number) {
    System.out.println(name + " shout " + number + " times as bird");
  }
}

class Swan extends Bird {
  Swan(String n) {
    super(n);
  }
/*
 以下这个方法重写不成功：因为fly()在父类中的以final修饰，所以不能被重写
  
  public void fly() {
    System.out.println(name + " fly as Swan");
  }
  
*/
/*
 以下这个方法重写不成功：因为fly（）在父类中以public修饰，在子类中重写的话访问权限不能比父类高
  
  private void fly(int number) {
    System.out.println(name + " fly " + number + " times as Swan");
  }
  
*/
  protected void shout() {
    System.out.println(name + " shout as Swan");
  }

  private void swim() {
    System.out.println(name + " swim as Swan");
  }
}
public class TestM {
  public static void main(String[] args) {
  	Bird b1 = new Bird("小小鸟");
    Swan b2 = new Swan("小天鹅");
    b2.fly();
 // swim方法在类中以private修饰，不能被直接访问
 // b2.swim();
  }
}