package com.selfPractice.programs;

public class NonRepeatChar {

	/*
	 * input = "agfcsjhjaf" output = [g,f,c,s,h]
	 */

	public static void main(String[] args) {

		String s = "agfcsjhjafpp";
		boolean[] temp = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (temp[i] == false) {
				for (int j = i + 1; j < s.length(); j++) {
					if (s.charAt(i) == s.charAt(j)) {
						temp[i] = true;
						//temp[j]=true;  //only not repeative, 
						               //comment for removing duplicates
					}

				}
			}
		}
		System.out.println("No Repeated numbers are : ");
		for (int p = 0; p < s.length(); p++) {
			if (temp[p] != true)
				System.out.print(s.charAt(p) + " ");
		}

	}

}
