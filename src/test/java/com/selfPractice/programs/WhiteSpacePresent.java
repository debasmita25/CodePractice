package com.selfPractice.programs;

public class WhiteSpacePresent {
	 public static void main(String[] args) {
		
		 //count white spaces
		 String input="gfgh jhghg hjghjg ";
		 String[] strArray=input.split(" ");
		 System.out.println(strArray.length);
		 String input1="gfgh.jhghg.hjghjg";
		 int count =0;
		 for(char c:input1.toCharArray()) {
			 if(c == '.')
			 {
				 count++;
			 }
		 }
		 System.out.println("count of space : "+count);
	}

}
