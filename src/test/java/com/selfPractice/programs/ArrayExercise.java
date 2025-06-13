package com.selfPractice.programs;

import java.util.Arrays;

public class ArrayExercise {
	
	public static void main(String[] args) {
		
		//Anonymous array
		SumOfnumbers(new int[] {1,2,3,4,5});
		
		//2-d array
		int[][] multiArray= {
				{1,2,3},
				{4,5}
		};
		System.out.println(Arrays.toString(multiArray[0]));
		System.out.println(Arrays.deepToString(multiArray));
		
		int[] arrayProb= {23,45,12,34};
		System.out.println("SORT");
		Arrays.sort(arrayProb);
		System.out.println(Arrays.toString(arrayProb));
		System.out.println("Binary Search "+Arrays.binarySearch(arrayProb,34));
		int[] copiedArray=Arrays.copyOf(arrayProb, arrayProb.length);
		System.out.println("Arrays equal : "+Arrays.equals(arrayProb, copiedArray));
		
		System.out.println(multiArray[1][1]); //5
		System.out.println(multiArray.length); //2
		System.out.println(multiArray[0].length); //3
		System.out.println(multiArray[1].length);//2
		
		//allocating only root size
		int[][] rootArray=new int[2][];
		rootArray[0]=new int[2];
		//rootArray[1]=new int[-3]; //NegativeArraySizeException
		rootArray[0][0]=4;
		rootArray[0][1]=5;
		// rootArray[0][3]=6; java.lang.ArrayIndexOutOfBoundsException
		//System.out.println(rootArray[1][0]); 
		//java.lang.NullPointerException: 
		//Cannot load from int array because "rootArray[1]" is null
		System.out.println(rootArray[0][0]); 
		
	}
	
	public static void SumOfnumbers(int[] a)
	{
		int total=0;
		for(int num:a)
		{
			//System.out.println(num);
			total=total+num;
		}
		
		System.out.println("Sum of Numbers : "+total);
	}

}
