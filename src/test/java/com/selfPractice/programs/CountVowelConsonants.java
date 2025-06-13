package com.selfPractice.programs;

public class CountVowelConsonants {
	
	public static void main(String[] args) {
		
		String vowels="aeiou";
		String input="ghasoegzuioj";
		int countVowels=0; //6
		int countConsonants=0;
		
	    System.out.println(input.substring(0,1)); //g
	    for(int i=1;i<=input.length();i++)
	    {
	    	if(vowels.contains(input.substring(i-1,i)))
	    	{
	    		countVowels++;
	    	}
	    	else
	    		countConsonants++;
	    }
	    
	    System.out.println("The count of Vowels : "+countVowels);
	    System.out.println("The count of Consonants : "+countConsonants);
	    
				
		
	}

}
