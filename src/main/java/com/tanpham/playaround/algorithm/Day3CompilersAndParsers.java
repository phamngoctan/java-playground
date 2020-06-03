package com.tanpham.playaround.algorithm;

import java.util.Scanner;
import java.util.Stack;

public class Day3CompilersAndParsers {
	/*
	 * 10
<<><>>>>>
><<<<
><<>>>>>>>
<<<><>
>>>
<<><<>><<
<>
<
>
><>><

=======
6
0
0
0
0
0
2
0
0
0
	 */
	/*
<<<><>
<>>
<><
<><>
	 * 0
	 * 2
	 * 2
	 * 4
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		String[] inputStrs = new String[total];
		for (int i = 0; i < total; i++) {
			String s = sc.next();
			inputStrs[i] = s;
		}

		for (int i = 0; i < total; i++) {
			char[] arr = inputStrs[i].toCharArray();
			Stack<Character> s = new Stack<>();
			int count = 0;
			int tempCount = 0;
			for (int j = 0; j < arr.length; j++) {
				if (arr[j] == '<') {
					s.push('<');
				} else {
					if (s.isEmpty()) {
						break; // invalid
					} else {
						tempCount += 2;
						s.pop();
						if (s.isEmpty()) {
							count = tempCount;
						}
					}
				}
			}
//			if (s.isEmpty()) {
				System.out.println(count);
//			} else {
//				System.out.println(0);
//			}
		}
	}
}
