package com.selfPractice.programs;

public class MultipleInheritanceByInterface implements Left,Right {
	
	public static void main(String[] args) {
		
		MultipleInheritanceByInterface obj=new MultipleInheritanceByInterface();
		obj.show();
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		Left.super.show();
		Right.super.show();
	}
	

}
