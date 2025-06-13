package com.selfPractice.programs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class StringProblem1 {
	
	// aaabbab to a4b3
	
	public static void main(String[] args) {
	
		String input="aaabbab";
		Map<Character,Integer> map=new LinkedHashMap<Character,Integer>();
		int count =0;
		for(Character c:input.toCharArray())
		{
			if(!map.containsKey(c))
			{
				map.put(c, 1);
			}
			
			else
			{
				map.put(c,(map.get(c)+1));
			}
			
		}
		
		//map element retrieval
		for(Character c:map.keySet())
		{
			System.out.println(c+" "+map.get(c));
		}
		//map element retrieval
		StringBuilder results=new StringBuilder();
		for(Map.Entry<Character, Integer> entry: map.entrySet())
		{
			//System.out.println(entry.getKey()+" "+entry.getValue());
			results.append(entry.getKey()).append(entry.getValue());	
		}

		System.out.println(results.toString());
		
		
	}

}
