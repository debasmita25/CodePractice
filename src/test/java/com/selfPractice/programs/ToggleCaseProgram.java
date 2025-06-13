package com.selfPractice.programs;

public class ToggleCaseProgram {

	/*
	 * Java to jAVA
	 */

	public static void main(String[] args) {
		String input = "Java";
		String output = "";
		int value = 'A';
		System.out.println(value); //65
		for (int i = 0; i < input.length(); i++) {
			if (input.charAt(i) >= 97) {
				char c = (char) (input.charAt(i) - 32);
				System.out.println(c);
				output = output + Character.toString(c);
			} else {
				char c = (char) (input.charAt(i) + 32);
				System.out.println(c);
				output = output + Character.toString(c);
			}
		}

		System.out.println(output);
	}
}
