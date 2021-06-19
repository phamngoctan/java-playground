package com.tanpham.playaround.algorithm;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Day9Pangram {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		String s = sc.next();
		Set<Character> res = new HashSet<>();
		char[] charArray = s.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] < 95) {
				res.add((char) (charArray[i] + 32));
			} else {
				res.add(charArray[i]);
			}
		}
		sc.close();
		String r = res.size() == 26 ? "YES" : "NO";
		System.out.println(r);
	}
	
}
