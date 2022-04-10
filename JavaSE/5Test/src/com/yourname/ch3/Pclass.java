package com.yourname.ch3;
class Dclass {	   //default class	
	public void method1(){
		System.out.println("public method of a defalut class in package p5");
	}
	protected void method2(){
		System.out.println("protected method of a defalut class in package p5");
	}
	void method3(){
		System.out.println("defalut method of a defalut class in package p5");
	}
	private void method4(){
		System.out.println("private method of a defalut class in package p5");
	}
}

public class Pclass {	    //public class		
	public void method1(){
		System.out.println("public method of a public class in package p5");
	}
	protected void method2(){
		System.out.println("protected method of a public class in package p5");
	}
	void method3(){
		System.out.println("defalut method of a public class in package p5");
	}
	private void method4(){
		System.out.println("private method of a public class in package p5");
	}
	
}