package test;
import java.util.Scanner;
public class ScannerTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 接收用户输入的数字，使之为数组的长度
		int len = sc.nextInt();
		String []a = new String[len];
		// 遍历输入
		for(int i=0;i<a.length;i++) {
		    a[i]=sc.nextLine();
		}
		// 遍历输出
		for(int i=0;i<a.length;i++) {
		    System.out.println("a[" + i + "]=" + a[i] + "666 ");
        }
	}  
}
