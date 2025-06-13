package com.selfPractice.programs;

public class UnderstandParentChild {
	
	public static void main(String[] args) {
		
		Animal a=new Dog(); // upcasting
		Animal a2=new Animal();//second object;
		
		
		a.speak();// bark() method is not present
		
		Dog d = (Dog)a; //Downcasting
		
		d.bark();
		
	    Animal a1=d;
	    
		d.printSameVariable();
		
		System.out.println(Animal.var);
		Animal.staticDemo();
	}

}
