package studentsimplesystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
                
public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BufferedWriter fos = null;
		BufferedReader br = null;
		String s = null;
		while(!("quit".equals(s = sc.next())) ){
			try {
				fos = new BufferedWriter(new FileWriter("d:/0Test/学生姓名名单",true));
				fos.write(s);
				fos.write("\n");
				//刷新
				fos.flush();
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				if(fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
						
		}
		System.out.println("输入s表示查看当前学生，输入其他表示退出！");
		s = sc.next();
		if("s".equals(s)) {
			try {
				br = new BufferedReader(new FileReader("d:/0Test/学生姓名名单"));
				String s1 = null;
				while((s1 = br.readLine()) != null) {
					System.out.println(s1);
				}
				
			} catch (FileNotFoundException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			} finally {
				if(br != null) {
					try {
						br.close();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
				}
			}
		}else {
			System.exit(0);
		}
		

	}
}
