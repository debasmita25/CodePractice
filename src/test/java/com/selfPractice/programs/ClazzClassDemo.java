package com.selfPractice.programs;

import java.util.Arrays;

public class ClazzClassDemo {
	
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class clazz=Class.forName("java.lang.String");
		
		Object[] objMethods=clazz.getDeclaredMethods();
		
		System.out.println(Arrays.toString(objMethods));
	}

}
