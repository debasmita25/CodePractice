package com.selfPractice.programs;

public class RemoveDuplicateFromArray {
	
	
	public static void main(String[] args) {
		
		int[] input= {3,4,5,6,7,5,1,2,3,0,9,0};
		boolean[] temp=new boolean[input.length];
		System.out.println("Before Removing duplicates : ");
		for(int i=0;i<input.length;i++)
		{
			
				System.out.print(input[i]+" ");
			
		}
		System.out.println();
		
		for(int i=0;i<input.length;i++)
		{
			if(temp[i]!=true)
			{
			for(int j=i+1;j<input.length;j++)
			{
			if(input[i]==input[j])
			{
				temp[j]=true;
			}
			}
			}
			continue;
		}

		System.out.println("printing Array without duplicates");
		for(int i=0;i<input.length;i++)
		{
			if(temp[i]!=true)
			{
				System.out.print(input[i]+" ");
			}
		}
		
	}

}
