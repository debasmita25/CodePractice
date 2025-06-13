package com.selfPractice.programs;

import java.util.HashMap;
import java.util.Map;

import javax.print.DocFlavor.INPUT_STREAM;

public class AnagramStrings {
	/*
	 * listen and silent triangle and integral
	 */
	public static void main(String[] args) {

		String input1 = "listen";
		String input2 = "silett";

		if (input1.length() != input2.length()) {
			System.out.println("Two strings are not Anagram");
		} else {
			input1 = input1.toLowerCase();
			input2 = input2.toLowerCase();

			// find occurrence and compare them
			Map<Character, Integer> map1 = getMap(input1);
			Map<Character, Integer> map2 = getMap(input2);

			if (map1.equals(map2)) {
				System.out.println("Two strings are Anagram");
			} else
				System.out.println("Two strings are NOT Anagram");

		}

	}

	public static Map getMap(String input) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for(Character c:input.toCharArray())
		{
			if(map.containsKey(c))
			{
				map.put(c, map.get(c)+1);
			}
			else
				map.put(c, 1);
		}
		
		return map;
	}

}
