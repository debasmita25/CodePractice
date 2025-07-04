package com.selfPractice.programs;

public class FindOutAnswer {
	public static void main(String[] args) {

		/*
		 * 
		 * * * * * * * * * * * * * * * * * *
		 * 
		 * 
		 * 
		 * 
		 */

		int n = 5;

		// Upper half
		for (int i = 1; i <= n; i++) {
			// Print spaces
			for (int j = i; j < n; j++) {
				System.out.print(" ");
			}
			// Print stars
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		// Lower half
		for (int i = n - 1; i >= 1; i--) {
			// Print spaces
			for (int j = n; j > i; j--) {
				System.out.print(" ");
			}
			// Print stars
			for (int j = 1; j <= i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}

	public void puzzleTwo() {
		/*
		 * * * * * * *
		 *
		 * 
		 */

		for (int i = 3; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				System.out.print("*" + " ");
			}
			System.out.println();
		}

	}

	public void puzzleOne() {
		int i = 0;

		for (System.out.print("A "); i < 2; System.out.print("C ")) {
			i++;
			System.out.print("B ");
		}

	}

}
