package com.selfPractice.programs;

public class RemoveNumbers {

	public static void main(String[] args) {
		
		String input="jg76676bjgJhi";
		String output="";
		for(int i=0;i<input.length();i++)
		{
			
			if(((int)input.charAt(i) >=65 && (int)input.charAt(i) < 90) || (int)input.charAt(i) >=97 && (int)input.charAt(i) < 123 )
		
			output=output+Character.toString(input.charAt(i));
			else
				continue;
			
		}
		
		System.out.println("After removing numbers : "+ output);
	}

}
