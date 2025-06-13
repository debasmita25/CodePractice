package com.selfPractice.programs;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.util.Arrays;
import java.util.Scanner;

public class ArmstrongNumber {

	//1cube3+5cube3+3cube3=153
	//extract number,cube it and sum all
	
	public static void main(String[] args) {
		String userInput="";
		do
		{	
		System.out.println("Enter your number : ");
		Scanner scr=new Scanner(System.in);
		int n=scr.nextInt();
		
		//int n=153;
		double sum=0;
		int input=n;
		int totalDigits=String.valueOf(input).length();
		
		while(n > 0)
		{
			int temp=n%10;
			
			sum=sum+Math.pow(temp, totalDigits);
			System.out.println(sum);
			
			n=n/10;
		}
		
		if(sum==input)
		{
			System.out.println("Armstrong number");
		}
		else
		{
			System.out.println("Not an Armstrong number");
		}
		System.out.println("Do you want to enter more number(Y/N) ");
		 userInput = scr.next();
		}while(userInput.toLowerCase().equals("y"));
	}
}
