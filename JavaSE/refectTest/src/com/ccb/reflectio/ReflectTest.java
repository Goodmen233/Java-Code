package com.ccb.reflectio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReflectTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		Properties p = new Properties(); 
		try {
			// 读取文件并加载到properties
			fis = new FileInputStream(Thread.currentThread().getContextClassLoader().getResource("classname.properties").getPath());
			p.load(fis);
			// 获取文件中对应字符串的值
			String className = p.getProperty("classname");
			// 直接创建类并输出
			Class myClass = Class.forName(className);
			Object o = myClass.newInstance();
			System.out.println(o);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
