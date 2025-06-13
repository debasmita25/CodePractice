package com.selfPractice.programs;

public class DoWhileLoopCode {
	
	public static void main(String[] args) {
		int i = 5;
		int sum = 0;

		do {
		    sum += i;
		    i++;
		    if (i % 2 == 0) {
		        continue;
		    }
		} while (i < 10);

		System.out.println(sum);

	}

}
