package com.selfPractice.programs;

public class Dog extends Animal {

	String a="I am in Dog";
	public void bark() {
		System.out.println("Dog can bark");
	}
	
	Dog()
	{
		super();
		System.out.println("I am Dog constructor");
	}
	
	public void printSameVariable()
	{
		System.out.println(this.a);
		System.out.println(super.a);
	}
}
