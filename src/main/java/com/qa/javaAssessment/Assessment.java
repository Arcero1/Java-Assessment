package com.qa.javaAssessment;

import java.util.ArrayList;
import java.util.List;

public class Assessment {

	// Given a string, returns a string where for every char in the original string, there are three chars
	public String multChar(String input) {
		return multiplyCharacter(input, 3);
	}
	
	// Given a string and a number of repetitions n,
	// Returns a string with n instances of every character
	public String multiplyCharacter(String string, int n) {
		StringBuilder newString = new StringBuilder();
		
		for (int i = 0; i < string.length(); i++) {
			for (int j = 0; j < n; j++) {
				newString.append(string.substring(i, i + 1));
			}
		}
		
		return newString.toString();
	}

	// Returns the reversed string between the first and last appearance of "bert"
	// Returns an empty string if there aren't at least two instances of "bert"
	// "bert" in the string is case-insensitive
	public String getBert(String input) {
		return reverseString(getStringBetween(input, "bert"));
	}
	
	// This method retrieves a string between the first and last instance of keyword within string
	// The keyword is case insensitive
	public String getStringBetween(String string, String keyword) {
		String lowercase = string.toLowerCase();
		
		int[] instance = { lowercase.indexOf("bert"), lowercase.lastIndexOf("bert") };
		if (instance[0] < 0 || instance[1] < 0 || instance[0] == instance[1]) {
			return "";
		}
		
		return string.substring(instance[0] + keyword.length(), instance[1]);
	}
	
	// Reverses a string
	public String reverseString(String string) {
		
		StringBuilder reversedString = new StringBuilder();
		for (int i = 1; i <= string.length(); i++) {
			reversedString.append(string.charAt(string.length() - i));
		}
		
		return reversedString.toString();
	}
	
	// Given three integers, returns true if they are evenly distributed
	public boolean evenlySpaced(int a, int b, int c) {
		int ab = differenceModulus(a, b); // line a -> b
		int ac = differenceModulus(a, c); // line a -> c
		int bc = differenceModulus(b, c); // line b -> c

		return (ab == ac || ab == bc || ac == bc);
	}

	public int differenceModulus(int a, int b) {
		if (a > b) {
			return a - b;
		} else {
			return b - a;
		}
	}

	// Given a string and an int n, returns the string with n letters removed from the 'middle'
	// If the string length is even and n is odd, more characters will be removed from the first half of the word
	public String nMid(String string, int n) {
		if (string.length() < n) {
			return "";
		}
	
		int mid = string.length() / 2;
		return string.substring(0, mid - (n / 2)) + string.substring(mid + (n / 2) + 1, string.length());
	}

	// Given a string, returns the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	public static int superBlock(String string) {
		int blockLength = 0;

		for (int i = 0; i < string.length(); i++) {
			int j;
			
			for (j = 1; i + j < string.length(); j++) {
				if (string.charAt(i) != string.charAt(i + j)) {
					break;
				}
			}
			
			blockLength = (j > blockLength) ? j : blockLength;
		}
		
		return blockLength;
	}

	// given a string - returns the number of times "am" appears in the String
	// ignores case, am must be a separate word
	public int amISearch(String arg1) {
		return searchStringForKeyword(arg1, "am");
	}
	
	// searches a string for a keyword and returns the number of times the keyword appears in the string
	// the keyword must be a separate word
	// both string and keyword are case-insensitive
	public int searchStringForKeyword(String string, String keyword) {
		keyword = keyword.trim().toLowerCase();
		string = string.toLowerCase();
		int count = 0;

		if (string.startsWith(keyword + " ")) {
			count++;
		}

		if (string.endsWith(" " + keyword)) {
			count++;
		}

		keyword = " " + keyword + " ";
		while (string.contains(keyword)) {
			string = string.substring(string.indexOf(keyword) + keyword.length() - 1); 
			// - 1 is necessary to prevent the method missing consecutive keywords
			count++;
		}

		return count;
	}
	
	// if input is divisible by 3 returns "fizz"
	// if input is divisible by 5 returns "buzz"
	// if input is divisible by both 3 and 5 returns "fizzbuzz"
	public String fizzBuzz(int arg1) {
		String fizzbuzz = "";

		if (arg1 % 3 == 0) {
			fizzbuzz += "fizz";
		}
		
		if (arg1 % 5 == 0) {
			fizzbuzz += "buzz";
		}
		
		return fizzbuzz;
	}

	// Splits a number string into each constituent number
	// Add digits of each number to get an integer for each number
	// Return the highest value integer
	public int largest(String arg1) {
		int largest = 0;
		List<Integer> list = stringToIntArray(arg1, " ");
		
		for (int x : list) {
			x = recursiveAddDigits(x);
			largest = (x > largest) ? x : largest;
		}

		return largest;
	}
	
	// Splits a string of numbers separated by a given separator into a list of integers
	public List<Integer> stringToIntArray(String string, String separator) {
		List<Integer> numList = new ArrayList<Integer>();
		
		while (string.contains(separator)) {
			int seperatorIndex = string.indexOf(separator);
			numList.add(Integer.parseInt(string.substring(0, seperatorIndex)));
			string = string.substring(seperatorIndex + 1);
		}

		numList.add(Integer.parseInt(string));
		return numList;
	}

	// Returns the sum of the digits of the input
	public int recursiveAddDigits(int x) {
		if (x == 0) {
			return 0;
		}
		return x % 10 + recursiveAddDigits(x / 10);
	}
}