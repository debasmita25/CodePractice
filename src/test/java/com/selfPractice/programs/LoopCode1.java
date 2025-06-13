package com.selfPractice.programs;

public class LoopCode1 {
	
	public static void main(String[] args) {
		int i = 0;
		int sum = 0;

		while (i < 10) {
		    i++;
		    if (i % 3 == 0) {
		        continue;  // Skip multiples of 3
		    }
		    if (sum > 15) {
		        break;     // Exit if sum exceeds 15
		    }
		    sum += i;
		}
		System.out.println(sum);

	}

}
