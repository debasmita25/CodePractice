package com.selfPractice.programs;

public class StringSubstringProblem {
	
	public static void main(String[] args) {
		
		//Input: "akshatha123@gmail.com"
		//Output: "akshatha123"
		String str="akshatha123@gmail.com";
		int indexOfSplChar=str.indexOf("@");
		System.out.println(indexOfSplChar);
		//using substring
		System.out.println(str.substring(5,8));//tha, first parameter not included
		
		//without substring
		String output="";
		for(char c:str.toCharArray())
		{
		 if(c!='@')	
		  output=output+c;
		 else
			 break;
		}
		
		System.out.println("Only name : "+output);
	}

}
