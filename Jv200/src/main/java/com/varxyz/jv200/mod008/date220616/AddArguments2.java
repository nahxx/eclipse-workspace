package com.varxyz.jv200.mod008.date220616;

public class AddArguments2 {

	public static void main(String[] args) {
		try {
			int sum = 0;
			for (String arg : args) {
				sum += Integer.parseInt(arg);
			}
			System.out.println("Sum = " + sum);
		} catch (NumberFormatException nfe) {
			System.err.println("One of the command-line " + "arguments is not an integer.");
		}
	}

}

//java AddArguments2 1 tow 3.0 4
//One of the command-line arguments is not an integer.