package com.tanpham.playaround.recursion;

public class Printer {
	
	public static void main(String[] args) {
//		printSeries(5, 10);
		System.out.println(sum(3));
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
	
}
