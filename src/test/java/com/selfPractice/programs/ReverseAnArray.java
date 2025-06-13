package com.selfPractice.programs;

import java.util.Arrays;

public class ReverseAnArray {
	
	//reverse an array without creating another array
	
	public static void main(String[] args) {
		int[] var= {34,22,35,11,22,90,148};
		
		int start=0;
		int end=var.length-1;
		
		while(start<end)
		{
			int temp=var[start];
			var[start]=var[end];
			var[end]=temp;
			start++;
			end--;
		}
		
		System.out.println(Arrays.toString(var));
	}
	

}
