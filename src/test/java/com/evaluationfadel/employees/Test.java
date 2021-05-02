package com.evaluationfadel.employees;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Double a = 123.56;
		try {
	        Double.parseDouble("12");
	    }
	    catch(NumberFormatException e) {
	    	System.out.println("Field 'Age' must not contain a character");
	    }
	}

}
