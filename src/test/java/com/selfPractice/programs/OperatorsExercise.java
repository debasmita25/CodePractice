package com.selfPractice.programs;

public class OperatorsExercise {
	
	public static void main(String[] args) {
		
		int a1 = 5;
		int b1 = a1++;
		System.out.println(a1 + " " + b1); //6 5
		
		int x1 = 10;
		System.out.println(x1++ + ++x1); //=10+1+10+1 =22
		
		int a = 10;
		int b = a++ + ++a + a;
		System.out.println(a + " " + b);
		
		int x = 4;
		int y = ++x + x++ + ++x;
		System.out.println(x + " " + y);
		
		EqualityTest();


		
	}
	
	public static void EqualityTest() {
	   
	        String a = "hello";
	        String b = "hello";
	        String c = new String("hello");
	        String d = c.intern();

	        System.out.println(a == b);       // T
	        System.out.println(a == c);       // F
	        System.out.println(a.equals(c));  // T
	        System.out.println(a == d);       
	  // T ,d = c.intern() → returns reference from string pool, same as a
	        System.out.println(c == d);       // f
	    }
	}


