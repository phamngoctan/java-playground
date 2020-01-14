package com.tanpham.playaround.algorithm;

import java.util.Arrays;
import java.util.Scanner;

/*
 * Ahhhh, I thought that the expected output [l,r] is just two items, but it is a segment of items. =)) haizzzz
 * 
 */
public class DayThreeSortTheArray {
	
	static class Range {
		private int from;
		private int to;
		public int getFrom() {
			return from;
		}
		public void setFrom(int from) {
			this.from = from;
		}
		public int getTo() {
			return to;
		}
		public void setTo(int to) {
			this.to = to;
		}
		public Range(int from, int to) {
			super();
			this.from = from;
			this.to = to;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		Range range = getPositionsIfExistThatKindOfArray(arr);
		if (range == null) {
			System.out.println("no");
		} else {
			System.out.println("yes");
			System.out.println(range.from + " " + range.to);
		}
	}

	/*
	 * judging:
	 * idea:
	 * step 1: find the first position l, r (start, end)
	 * step 2: reverse [l, r] in input arr
	 * step 3: compare input arr vs sorted arr 
	 * 
	 * O(NlogN) the cost of sorting the input arr
	 */
	public static Range getPositionsIfExistThatKindOfArray(int[] arr) {
		int[] originalArr = arr.clone();
		Arrays.sort(arr);
		int totalDiff = 0;
		int pos1 = -1;
		int pos2 = -1;
//		System.out.println(Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(", ")));
		for (int i = 0; i < originalArr.length; i++) {
			if (arr[i] != originalArr[i]) {
				if (pos1 == -1) {
					pos1 = i;
				} else {
					pos2 = i;
				}
				totalDiff++;
			}
			if (totalDiff > 2) {
				return null;
			}
		}
		if (totalDiff == 0) {
			return new Range(1, 1);
		}
		return new Range(pos1 + 1, pos2 + 1);
	}
	
}
