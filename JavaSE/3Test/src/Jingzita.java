import java.util.Scanner;
public class Jingzita {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("请输入一个整数：");
		int n = sc.nextInt();
		System.out.println("结果如图：");
		System.out.println(Jingzita.out(n));

	}
	public static int out(int n) {
		for(int i=1;i<=n;i++) {
		   for(int j=0;j<n-i;j++) 
				System.out.print('\t');
		   for(int j=i;j>=1;j--)
				System.out.print(j + "\t");
		   for(int j=2;j<=i;j++)
				System.out.print(j + "\t");
		   System.out.println("\n");
		}
	return 0;
	}
}
