package com.selfPractice.programs;

public class ControlStatementExercise1 {
	
	public static void main(String[] args) {
		int day = 3;
		switch (day) {
		    case 1: System.out.println("Monday"); break;
		    case 2: System.out.println("Tuesday"); break;
		    case 3: System.out.println("Wednesday"); break;
		    default: System.out.println("Invalid Day");
		}
		
		//enhanced switch
		
		String dayInString = switch(day) {
		case 1->"Monday";
		case 2->"Tuesday";
		default->"Invalid";
		};

		System.out.println(dayInString);
		
		//fall through switch
		String selectMonth ="August";
		switch(selectMonth)
		{
		case "April":
		case "May":
		case "June":System.out.println("First Quarter");
		      break;
		case "July":
		case "August":
		case "Sept":System.out.println("Second Quarter");
		}
	

	
	int score = 85;
	String grade = switch (95 / 10) {
	    case 10, 9 -> "A";
	    case 8 -> {
	        System.out.println("Good job!");
	        yield "B";
	    }
	    case 7 -> "C";
	    default -> "F";
	};

	System.out.println(grade);

	}
}
