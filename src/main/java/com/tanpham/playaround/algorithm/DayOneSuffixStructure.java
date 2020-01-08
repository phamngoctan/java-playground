package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class DayOneSuffixStructure {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		sc.close();
		System.out.println(getAnswer(s1, s2));
	}
	
	/*
	 * Data structure
	 * suffix automaton: delete any string (not change the order) abc -> ac (delete b)
	 * suffix array: swap position abc -> cab... bla bla
	 * suffix tree: if twos above don't match
	 * 
	 * implementation idea:
	 * automaton
	 * tomat
	 * 
	 * tomat: get first char "t" ==> check the above string (from left to right) the first match t, save it position;
	 *        get the second char "0" ==> check t from the save position in first step
	 *        ...
	 *        continue until figure out the tomat, otherwise, no automaton:
	 *        
	 * To check array case: it must be the same length
	 * array
	 * arary
	 * 
	 * To check both:
	 * use automation to remove first, then use suffix-array idea to check.
	 * 
	 * ========================
	 * Coding:
	 * automaton case:
	 *   automaton = false
	 *   i = -1
	 *   for j 0 -> length
	 *      j++;
	 *      while (i < length of s1 && s1[i] != s2[j])
	 *        i++;
	 *        
	 *      if...
	 *        
	 * array case:
	 *  counts1 = []
	 *  counts2 = []
	 *  for char in s1
	 *    counts1[char - 'a'] += 1;
	 *    
	 *  for char in s2
	 *    counts2[char - 'a'] += 1;
	 *    
	 *  b4: arrayFlag = true
	 *   for i : 0 -> 26
	 *     if (countS2[i] > countS1[i]
	 *       -> need tree
	 *     if (countS2[i] < countS1[i])
	 *       -> arrayFlag = false; break;
	 *       
	 *   if (arrayFlag == true)
	 *     -> "suffix array"
	 *   else 
	 *     -> "both"
	 */
	public static String getAnswer(String s1, String s2) {
		char[] arr1 = s1.toCharArray();
		char[] arr2 = s2.toCharArray();
		
		if (isAutomaton(arr1, arr2)) {
			return "automaton";
		}
		
		return null;
	}

	private static boolean isAutomaton(char[] arr1, char[] arr2) {
		int i = 0;
		for (int j = 0; j < arr1.length; j++) {
			if (arr1[j] != arr2[i]) {
				i++;
			}
			if (i == arr2.length) {
				return true;
			}
		}
		return false;
	}

}
