package com.selfPractice.programs;

public class UnderstandStaticVariable {
	    public static void main(String[] args) {
	        Counter c1 = new Counter();  // count = 1
	        Counter c2 = new Counter();  // count = 2
	        Counter c3 = new Counter();  // count = 3

	        System.out.println("\nAccessing count from each object:");
	        c1.displayCount();  // Output: 3
	        c2.displayCount();  // Output: 3
	        c3.displayCount();  // Output: 3
	    }
	
}	

	
	class Counter {
	    static int count = 0; // static variable shared by all objects

	    Counter() {
	        count++; // Incrementing static variable in constructor
	        System.out.println("Object created. Current count: " + count);
	    }

	    void displayCount() {
	        System.out.println("Count from this object: " + count);
	    }
	}

	    



