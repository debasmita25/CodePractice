package com.selfPractice.programs;

public class ReverseANumber {
	
	public static void main(String[] args) {
		
		/*
		 * 12345
		 * 54321
		 * 
		 */
		int input=123450;
		int output=0;
		
		while(input > 0)
		{
			int temp=input%10;
			output=output*10 + temp;
			input=input/10;
		}
		
		System.out.println(output);
	
	}

}
