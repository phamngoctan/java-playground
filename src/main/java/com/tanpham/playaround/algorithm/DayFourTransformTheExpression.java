package com.tanpham.playaround.algorithm;

import java.util.Scanner;
import java.util.Stack;

public class DayFourTransformTheExpression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		String[] arr = new String[length];
		for (int i = 0; i < length; i++) {
			arr[i] = sc.next();
		}
		sc.close();
		String[] expressions = transform(arr);
		for (int i = 0; i < expressions.length; i++) {
			System.out.println(expressions[i]);
		}
	}
	
	public static String[] transform(String[] arr) {
		String[] result = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = transformSingleItem(arr[i]);
		}
		return result;
	}

	private static String transformSingleItem(String input) {
		String str = "";
		char[] arr = input.toCharArray();
		Stack<String> stack = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] >= 97 && arr[i] <= 122) {
				str += arr[i];
			} else if (arr[i] == ')') {
				str += stack.pop();
			} else if (arr[i] != '('){
				//if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/' || arr[i] == '%' || arr[i] == '^')
				stack.push("" + arr[i]);
			}
		}
		return str;
	}
	
}
