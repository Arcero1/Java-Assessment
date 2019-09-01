package com.qa.javaAssessment;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Assessment {

	// Given a string, returns a string where for every char in the original string, there are three chars
	public String multChar(String input) {
		return new ExtendedString(input).multiplyCharacterInstancesBy(3).toString();
	}

	// Returns the reversed string between the first and last appearance of "bert"
	// Returns an empty string if there aren't at least two instances of "bert"
	// "bert" in the string is case-insensitive
	public String getBert(String input) {
		return reverseString(new ExtendedString(input).getStringBetween("bert"));
	}

	private String reverseString(String string) {
		StringBuilder reversedString = new StringBuilder(string);
		
		return reversedString.reverse().toString();
	}
	
	// Given three integers, returns true if they are evenly distributed
	public boolean evenlySpaced(int a, int b, int c) {
		int ab = distanceBetween(a, b); // line a -> b
		int ac = distanceBetween(a, c); // line a -> c
		int bc = distanceBetween(b, c); // line b -> c

		return ab == ac || ab == bc || ac == bc;
	}

	private int distanceBetween(int a, int b) {
		return Math.abs(a - b);
	}

	// Given a string and an int n, returns the string with n letters removed from the 'middle'
	// If the string length is even and n is odd, more characters will be removed from the first half of the word
	public String nMid(String string, int n) {
		if (string.length() < n) return "";
	
		int mid = string.length() / 2;
		return string.substring(0, mid - (n / 2)) + string.substring(mid + (n / 2) + 1);
	}

	// Given a string, returns the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	public static int superBlock(String string) {
		return new ExtendedString(string).getLargestCharBlock();
	}

	// given a string - returns the number of times "am" appears in the String
	// ignores case, am must be a separate word
	public int amISearch(String string) {
		return new ExtendedString(string).numInstancesOf("am");
	}
	
	// if input is divisible by 3 returns "fizz"
	// if input is divisible by 5 returns "buzz"
	// if input is divisible by both 3 and 5 returns "fizzbuzz"
	public String fizzBuzz(int value) {
		return (value % 3 == 0 ? "fizz" : "") + (value % 5 == 0 ? "buzz" : "");
	}

	// Splits a number string into each constituent number
	// Add digits of each number to get an integer for each number
	// Return the highest value integer
	public int largest(String string) {
		AtomicInteger largest = new AtomicInteger();

		new ExtendedString(string).toIntList().forEach(element -> largest.set(Math.max(addDigits(element), largest.get())));

		return largest.get();
	}

	// Returns the sum of the digits of the input
	private int addDigits(int x) {
		return x == 0 ? 0 : x % 10 + addDigits(x / 10);
	}
}