package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class Day1VitalyAndString {

	private static final String NO_SUCH_STRING = "No such string";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		sc.close();
		System.out.println(findMiddleOne(s1, s2));
	}
	
	/*
	 * Coding idea:
	 * for (length -> 0) {
	 *   if two item is diff: increase to one of the first, break;
	 * }
	 * s == t : no such string
	 * s != t: print s
	 * 
	 * super fast =));
	 */
	public static String findMiddleOne(String string1, String string2) {
		if (string1 == null || string1.length() == 0) {
			return NO_SUCH_STRING;
		}
		
		int i = string1.length() - 1;
		while (i >= 0) {
			int diff = string2.charAt(i) - string1.charAt(i);
			if (diff > 0) {
				return generateResultByIncreaseOneLastChar(string1, string2);
			}
			i--;
		}
		return NO_SUCH_STRING;
	}

	public static String generateResultByIncreaseOneLastChar(String string1, String string2) {
		char[] arr1 = string1.toCharArray();
		boolean remember = true;
		for (int i = arr1.length - 1; i >= 0 && remember; i--) {
			if (arr1[i] == 'z') {
				arr1[i] = 'a';
			} else {
				remember = false;
				arr1[i] = (char) (arr1[i] + 1);
			}
		}
		
		String updatedString = String.valueOf(arr1);
		if (updatedString.equals(string2)) {
			return NO_SUCH_STRING;
		}
		
		return updatedString;
	}

}
