package com.tanpham.playaround.algorithm;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class DayFourStreetParade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		while (length != 0) {
			Integer[] arr = new Integer[length];
			for (int i = 0; i < length; i++) {
				arr[i] = sc.nextInt();
			}
			System.out.println(canReordered(arr) ? "yes" : "no");
			length = sc.nextInt();
		}
		sc.close();
	}
	
	/*
	 * Be careful, we have to check both the remaining items & the stack
	 * Simultaneously
	 * 
	 * Good idea from the teacher:
	 * street = 1
	 * 
	 * street++
	 * 
	 * finally
	 * if (street = n + 1)
	 *   yes
	 * else 
	 *   no
	 * 
	 * With this approach we don't need to clone and sort the array
	 */
	public static boolean canReordered(Integer[] arr) {
		Stack<Integer> stack = new Stack<>();
		Integer[] originalArr = arr.clone();
		Arrays.sort(arr);
		int totalMovedItem = 0;
		for (int i = 0; i < originalArr.length; i++) {
			if (originalArr[i] == arr[totalMovedItem]) {
				totalMovedItem++;
			} else {
				stack.add(originalArr[i]);
			}
			boolean dontStop = true;
			while (!stack.isEmpty() && dontStop) {
				if (arr[totalMovedItem] == stack.peek()) {
					totalMovedItem++;
					stack.pop();
				} else {
					dontStop = false;
				}
			}
		}
		for (int i = totalMovedItem; i < arr.length; i++) {
			if (arr[i] != stack.pop()) {
				return false;
			}
		}
		
		return true;
	}
	
}
