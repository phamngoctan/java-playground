package com.tanpham.playaround.leetcode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class L530 {

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1') {
					bfs(grid, i, j);
					count++;
				}
			}
		}
		return count;
	}

	private void bfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length  || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
			return;
		}
		
		grid[i][j] = '0';
		bfs(grid, i + 1, j);
		bfs(grid, i - 1, j);
		bfs(grid, i, j - 1);
		bfs(grid, i, j + 1);
	}
	
//	public static void main(String[] args) {
//		calculateDistance('z', 'a');
//		calculateDistance('z', 'e');
//		calculateDistance('e', 'u');
//	}

//	private static void calculateDistance(char c1, char c2) {
//		int b = Math.abs(c1 - c2);
//		int total = 0;
//		if (b > 13) {
//			total = 26 - b;
//		} else {
//			total = b;
//		}
//		System.out.println(Math.min(b, total));
//	}
	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		String str = sc.next();
//		
//		char[] arr = str.toCharArray();
//		int total = calculateDistance('a', arr[0]);    
//		for (int i = 1; i < arr.length; i++) {
//	      total += calculateDistance(arr[i - 1], arr[i]);
//	    }
//		System.out.println(total);    
//  }
//
//	private static int calculateDistance(char c1, char c2) {
//		int b = Math.abs(c1 - c2);
//		int total = 0;
//		if (b > 13) {
//			total = 26 - b;
//		} else {
//			total = b;
//		}
//		return Math.min(b, total);
//  }

//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//	
//		int cur = 0;    
//		boolean skip = false;    
//		for (int i = 0; i < t; i++) {
//			int minute = sc.nextInt();
//			if (skip) {
//				continue;        
//      }      
//			if (minute - cur > 15) {
//				skip = true;
//				cur += 15;        
//      } else {
//				cur = minute;
//      }
//    }
//		System.out.println(cur);    
//  }
	
//		public static void main(String[] args) {
//			Scanner sc = new Scanner(System.in);
//			String s1 = sc.next();    
//			String s2 = sc.next();    
//			char[] arr1 = s1.toCharArray();
//			for (int i = arr1.length - 1; i >= 0; i--) {
//				if (arr1[i] == 'z') {
//					arr1[i] = 'a';
//				} else {
//					arr1[i] = (char)(arr1[i] + 1);
//					break;
//				}
//			}
//			if (new String(arr1).compareTo(s2) < 0) {
//				System.out.println(new String(arr1));
//			} else {
//				System.out.println("No such string");
//			}
//	  }
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int t1 = sc.nextInt();
//		int t2 = sc.nextInt();
//		int k = sc.nextInt();
//		int m = sc.nextInt();
//
//		int[] arr1 = new int[t1];
//		for (int i = 0; i < t1; i++) {
//			arr1[i] = sc.nextInt();
//		}
//		int[] arr2 = new int[t2];
//		for (int i = 0; i < t2; i++) {
//			arr2[i] = sc.nextInt();
//		}
//
//		// check
//		boolean res = false;
//
//	}

	
	// Suffix structure
//		public static void main(String[] args) {
//			Scanner sc = new Scanner(System.in);
//			String s = sc.next();
//	    String t = sc.next();
//			int[] countS = new int[26];
//			for (int i = 0; i < s.length(); i++) {
//				countS[((int) s.charAt(i)) - 97] += 1;
//	    }
//			int[] countT = new int[150];    
//			for (int i = 0; i < t.length(); i++) {
//				countT[((int) s.charAt(i)) - 97] += 1;
//	    }
//
//			boolean needTree = false;
//			boolean automaton = false;
//			boolean arrayApproach = false;    
//			for (int i = 0; i < 26; i++) {
//	      if (countS[i] )
//	    } 
//	  }  
	
//		public static void main(String[] args) {
//			Scanner sc = new Scanner(System.in);
//			int n = sc.nextInt();
//			int blockedTime = sc.nextInt();
//			
//			// good idea, just care about the length, don't care about the value    
//			int[] count = new int[101];    
//			for (int i = 0; i < n; i++) {
//				String pass = sc.next();
//	  		count[pass.length()]++;
//	    }
//	    
//			int bestTime = 0;    
//
//			int countPassLessLengthThenOrigin = 0;    
//			for (int i = 0; i < n; i++) {
//				 
//	    }    
//	  }
	
	// Array
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];    
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		int first = 0;
		int second = 0;
		Set<Integer> distinctItem = new HashSet<>();
		for (int i = 1; i < n; i++) {
			distinctItem.add(arr[i]);
			if (arr[i] >= arr[i - 1]) {
				if (distinctItem.size() < k) {
					second = i;
				} else {
					second = i;
					break;
				}
			} else {
				first = i;
			}
		}
		// O(n) only, because the second while, maximum it reach the first time & exit the program
//		while ()
		System.out.println(first + " " + second);
		
    }    
	
	
}
