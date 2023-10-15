package com.lms.library;

public class InvalidChoiceException extends RuntimeException {

	@Override
	public String toString() {
		String msg = "Invalid Choice.Enter a number between 1 to 6";
		return msg;
	}
	
}
