package com.selfPractice.programs;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

public class SwappingWithoutThird {
	
	public static void main(String[] args) {
		
		int a=10;
		int b=90;
		
	      a = a+b; //100
		  b = a-b;  //100-90
		  a = a-b; //90
		  
		  System.out.println(a+" "+b);
		
				
	}

}
