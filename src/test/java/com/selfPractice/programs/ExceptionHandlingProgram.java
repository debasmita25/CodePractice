package com.selfPractice.programs;

public class ExceptionHandlingProgram {
	
	public static void main(String[] args) throws MyException {
		
		
			throw new MyException("I am an Exception");
		
	/*	catch(Exception e)
		{
			System.out.println("I am caught");
		}*/
		
	}

}

class MyException extends Exception {
	
	public MyException(String message) {
		super(message);
	}
}
