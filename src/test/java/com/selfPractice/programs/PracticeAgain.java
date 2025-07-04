package com.selfPractice.programs;

import java.util.Scanner;

public class PracticeAgain {

	public static void main(String[] args) {

		try (Scanner scr = new Scanner(System.in)) {
			String choice;
			do {
				System.out.println("Enter your password: ");
				String input = scr.next();
				System.out.println("Is Password valid: " + isPasswordValid(input));
				// System.out.println(findFact(5));
				// printlowerUpper();
				// findOddEvenNumbers();
				// pallindromeOne();
				// pallindromeTwo();
				System.out.println("Try Again: Y/N");
				choice = scr.next();
			} while (choice.toLowerCase().equals("y"));
		}
	}

	public static boolean isPasswordValid(String input) {
		char[] charArray = input.toCharArray();
		int totalChars = charArray.length;

		if (totalChars < 8 || totalChars > 16)
		{
			System.out.println("Length is shorter or longer than expected");
			return false;
		}	

		boolean upperFlag = false;
		boolean lowerFlag = false;
		boolean specialFlag = false;
		boolean digitFlag = false;

		for (char ch : charArray) {
			if (ch >= 65 && ch <= 90) {
				System.out.println("checking for uppercase");
				upperFlag = true;
			} else if (ch >= 97 && ch <= 122) {
				System.out.println("checking for lower case");
				lowerFlag = true;
			} else if (ch >= '0' && ch <= '9') {
				System.out.println("checking for digit");
				digitFlag = true;
			} else {
				System.out.println("checking for special character");
				specialFlag = true;
			}
		}
		if(upperFlag == false)
			System.out.println("Uppercase is missing");
		else if(lowerFlag == false)
			System.out.println("Lowercase is missing");
		else if(digitFlag==false)
		System.out.println("Digit is missing");
		else
			System.out.println("Special Character is missing");

		return upperFlag && lowerFlag && digitFlag && specialFlag;

	}

	public static int findFact(int num) {
		if (num == 0 || num == 1)
			return 1;
		return num * findFact(num - 1);
	}

	public static void printlowerUpper() {
		for (int i = 97; i <= (97 + 17); i++) {
			System.out.print((char) i + " ");
		}
		System.out.println();
		for (int i = 65 + 18; i <= (65 + 25); i++) {
			System.out.print((char) i + " ");
		}
	}

	public static void findOddEvenNumbers() {
		int num = 23456;
		int temp = num;
		int countEven = 0;
		int countOdd = 0;
		while (num % 10 > 0) {
			int temp1 = num % 10;
			if (temp1 % 2 == 0)
				countEven++;
			else
				countOdd++;
			num = num / 10;
		}
		System.out.println(temp);
		System.out.println("Count of Even " + countEven);
		System.out.println("Count of Odd " + countOdd);
	}

	public static void pallindromeTwo() {
		String input = "abcsdcba";
		char[] cInput = input.toCharArray();
		int end = cInput.length - 1;
		int start = 0;
		while (start < end) {
			if (cInput[start] != cInput[end])
				break;
			start++;
			end--;
		}

		if (start >= end)
			System.out.println("Pallindrome");
		else
			System.out.println("Not Pallindrome");
	}

	public static void pallindromeOne() {
		String input = "ababac";
		char[] cInput = input.toCharArray();
		int lengthOfInput = cInput.length;
		int i = 0;
		for (; i < lengthOfInput; i++) {
			if (cInput[i] != cInput[lengthOfInput - i - 1])
				break;
		}
		if (i == lengthOfInput)
			System.out.println("Pallindrome");
		else
			System.out.println("Not Pallindrome");

	}

}
