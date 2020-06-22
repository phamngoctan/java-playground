package com.tanpham.playaround.algorithm;

import java.util.Scanner;

public class Day9CamelCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) < 95) {
				count++;
			}
		}
		System.out.println(count + 1);
	}
	
}
