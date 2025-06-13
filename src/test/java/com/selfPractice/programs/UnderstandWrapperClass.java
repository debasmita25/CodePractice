package com.selfPractice.programs;

public class UnderstandWrapperClass {
	
	public static void main(String[] args) {
		
	//Strings to primitive
		int a=Integer.parseInt("123");
		System.out.println(a);
		
	//String to Object
	 Integer b=Integer.valueOf("1232");
	 System.out.println(b);
	 
	//Object to int
	 Integer c= 12;
	 int d=c.intValue();
	 System.out.println(d);
		
	//compare
	 int result = Integer.compare(10000, 200);
	 System.out.println(result);
	
	//convert char to String
	String meChar=Character.toString('c');
	System.out.println(meChar);

	}

}
