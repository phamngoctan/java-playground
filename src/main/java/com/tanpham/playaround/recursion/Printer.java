package com.tanpham.playaround.recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Printer {
	
	public static void main(String[] args) {
//		printSeries(5, 10);
//		System.out.println(sum(3));
//		print("abcde");
//		System.out.println("Value of result: " + numberOccur('c', "abcdefc") + " - it should be equal 2");
		System.out.println("Value of result: " + removeVowels("recurse") + " - it should be equal rcrs");
	}

	public static void printSeries(int from, int to) {
		if (from == to) {
			System.out.println(from);
			return;
		} else {
			System.out.println(from);
			printSeries(from + 1, to);
		}
	}
	
	/*
	 * sum(6) = 6 + sum(5)
		      = 6 + 5 + sum(4)
	 */
	public static int sum(int n) {
		if (n <= 0) {
			return 0;
		} else {
			return n + sum(n - 1);
		}
	}
	
	public static void print(String s) {
		if (s == null || s.length() == 0) {
			return;
		}
		print(s.substring(1));
		System.out.println(s.charAt(0));
	}
	
	public static int numberOccur(char ch, String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int matched = s.charAt(0) == ch ? 1 : 0;
		return matched + numberOccur(ch, s.substring(1));
	}
	
	public static Set<Character> vowels = Collections.unmodifiableSet(new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u')));
	public static String removeVowels(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		
		String nonVowel = vowels.stream().anyMatch(c -> c == s.charAt(0)) ? "" : "" + s.charAt(0);
		return nonVowel + removeVowels(s.substring(1));
	}
}
