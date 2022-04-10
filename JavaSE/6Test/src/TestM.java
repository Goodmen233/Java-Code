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
 �������������д���ɹ�����Ϊfly()�ڸ����е���final���Σ����Բ��ܱ���д
  
  public void fly() {
    System.out.println(name + " fly as Swan");
  }
  
*/
/*
 �������������д���ɹ�����Ϊfly�����ڸ�������public���Σ�����������д�Ļ�����Ȩ�޲��ܱȸ����
  
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
  	Bird b1 = new Bird("СС��");
    Swan b2 = new Swan("С���");
    b2.fly();
 // swim������������private���Σ����ܱ�ֱ�ӷ���
 // b2.swim();
  }
}