package com.selfPractice.programs;

public class StringSplitProblem {
	
	public static void main(String[] args) {
		
		countWords("Java is easy to learn");
		findIPValid("1.168.1.320"); //3 dots+1 = 4 (length)
		String input=".1.168.1.320";
		String[] testSplit=input.split("\\.");
		System.out.println(testSplit.length + " : first index holds: "+testSplit[0].isEmpty());
		//number of dots+1 , index holds true
		
		//split without split method
		splitProgram("Java  is powerful");
		
	}

	public static void splitNumbersSum(String input)
	{
		/*
		 * Input: "10,20,30,40"
          Output: 100

		 */
		
		
	}
	
	
	public static void splitProgram(String input)
	{
		//Input: "Java is powerful"
				//Output: [Java, is, powerful]
		
		char[] charArray=input.toCharArray();
		StringBuilder results=new StringBuilder();
		for(int i =0;i<charArray.length;i++)
		{
		if(charArray[i]==' ')	
		results.append(",").append(charArray[i]);
		else
			results.append(charArray[i]);
		}
		
		System.out.println("split without method : "+results);
	}
	public static void findIPValid(String input)
	{/* 0-255 and four dots
	Input: "192.168.1.300"
    Output: Invalid IP

Input: "192.168.1.1"
Output: Valid IP

	*/
		boolean flag=false;
		String[] ipNumber=input.split("\\.");
		System.out.println(ipNumber.length);
		for(String value:ipNumber)
		{
			Integer valueInt=Integer.valueOf(value);
			//java.lang.NumberFormatException:
			if(valueInt <= 255)
			{
				continue;
			}
			else
			{
				flag=true;
				break;
			}
		}
		if(!flag && ipNumber.length==4 && !ipNumber[0].startsWith("0"))
		{
			System.out.println("Valid Ip");
		}
		else
			System.out.println("Invalid Ip");
		
	}
	
	public static void countWords(String input)
	{
		/*
		 * Input: "Java is easy to learn"
           Output: 5
		 */
		
		String[] wordArray=input.split(" ");
		System.out.println("count of words "+wordArray.length);
	}
}
