
public class JudgeRunYear {

	public static void main(String[] args) {
		MyDate d1 = new MyDate();
        System.out.print("d1是");
        d1.print();
        JudgeRunYear.judge(d1.isRunyear(d1.year));
		MyDate d2 = new MyDate(2009,4,1);
        System.out.print("d2是");
        d1.print();
        JudgeRunYear.judge(d1.isRunyear(d2.year));
        
        System.out.println("经过交换后：");
        
        d1 = new MyDate(2009,4,1);
        System.out.print("d1是");
        d1.print();
        JudgeRunYear.judge(d1.isRunyear(d1.year));
        d2 = new MyDate();
        System.out.print("d2是");
        d1.print();
        JudgeRunYear.judge(d1.isRunyear(d2.year));
	}
    
    public static void judge(boolean j) {
    	if(j)
    		System.out.println("是闰年");
    	else
    		System.out.println("不是闰年");
    }
}
class MyDate{
	int year,month,day;
	boolean isRunyear(int y) {
		if((y%4==0&&y%100!=0)||(y%400==0))
			 return true;
		else return false;
	}
	public void print() {
		System.out.println(this.year + " " + this.month + " " + this.day + " " );
	}
	MyDate(){
		this(1970,1,1);
	}
	MyDate(int y,int m,int d){
		this.year = y;
		this.month = m;
		this.day = d;
	}
}