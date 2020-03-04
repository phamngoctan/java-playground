package com.tanpham.playaround.recursion;

public class Printer {
	
	public static void main(String[] args) {
		printSeries(5, 10);
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
	
}
