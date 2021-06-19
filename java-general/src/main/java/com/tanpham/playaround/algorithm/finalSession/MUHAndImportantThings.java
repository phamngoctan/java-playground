package com.tanpham.playaround.algorithm.finalSession;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class MUHAndImportantThings {
	
//	// Maintain a global counter. After finding a permutation, increment this. 
//    private static int count;
//    private static Map<Integer, List<String>> res = new HashMap<>();
//    private static int curGroup;
//
//    // pos is the current index, and K is the length of permutation you want to print, and N is the number of permutation you want to print.
//    private static void printPermutations(int[] arr, int[] visited, int pos, int K, int N, String str) {
//
//        // We have already found N number of permutations. We don't need anymore. So just return.
//        if (count == N) {
//            return;
//        }
//
//        if (pos == K) {
//            System.out.println(str);
//            if (!res.containsKey(curGroup)) {
//            	res.put(curGroup, new ArrayList<>());
//            }
//            res.get(curGroup).add(str);
//            count++; // we have found a valid permutation, increment counter.
//            return;
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            // Only recur if the ith element is not visited.
//            if (visited[i] == 0) {
//                // mark ith element as visited.
//                visited[i] = 1;
//                printPermutations(arr, visited, pos + 1, K, N, str + " " + arr[i]);
//                // unmark ith element as visited.
//                visited[i] = 0;
//            }
//        }
//
//    }

	static class Pair implements Comparable<Pair> {
		Integer x;
		Integer y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(Pair o) {
			return x.compareTo(o.x);
		}
		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		Map<Integer, List<Integer>> input = new TreeMap<>();
		List<Pair> arrPairs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			arrPairs.add(new Pair(arr[i], i + 1));
			if (!input.containsKey(arr[i])) {
				input.put(arr[i], new ArrayList<>());
			}
			input.get(arr[i]).add(i);
		}
		
//		System.out.println(input);
		Collections.sort(arrPairs);
//		System.out.println(arrPairs);
		// First record
		String first = arrPairs.stream().map(p -> p.y).map(Object::toString).collect(Collectors.joining(" "));
//		System.out.println(first);
		List<String> resStr = new ArrayList<>();
		resStr.add(first);
		
		int count = 1;
		for (int i = 0; i < n - 1; i++) {
			if (arrPairs.get(i).x == arrPairs.get(i + 1).x) {
				List<Integer> temp = new ArrayList<>();
				for (int j = 0; j < n; j++) {
					if (j == i) {
						temp.add(arrPairs.get(j + 1).y);
					} else if (j == i + 1) {
						temp.add(arrPairs.get(j - 1).y);
					} else {
						temp.add(arrPairs.get(j).y);
					}
				}
				String cur = temp.stream().map(Object::toString).collect(Collectors.joining(" "));
//				System.out.println(cur);
				if (!resStr.contains(cur)) {
					count++;
					resStr.add(cur);
				}
			}
			if (count >= 3) {
				break;
			}
		}
		if (count < 3) {
			System.out.println("NO");
		} else {
			System.out.println("YES");
			resStr.stream().forEach(System.out::println);
		}
//		List<List<Integer>> res = new ArrayList<>();
//		for (Map.Entry<Integer, List<Integer>> entry : input.entrySet()) {
//			for (int i = 0; i < entry.getValue().size(); i++) {
//				res.get(0).add(entry.getValue().get(i));
//			}
//		}
//		
//		for (Map.Entry<Integer, List<Integer>> entry : input.entrySet()) {
//			if (entry.getValue().size() == 2) {
//				
//			}
//			for (int i = 0; i < entry.getValue().size(); i++) {
//				res.get(0).add(entry.getValue().get(i));
//			}
//		}
		
		
//		List<List<Integer>> arrRes = new ArrayList<>();
//		curGroup = 0;
//		for (Map.Entry<Integer, List<Integer>> entry : input.entrySet()) {
//			int[] res = new int[entry.getValue().size()];
//			int i = 0;
//			for (Integer item : entry.getValue()) {
//				res[i++] = item;
//			}
//			if (res.length > 1) {
//				int[] visited = new int[res.length];
//				count = 0;
//				curGroup++;
//				printPermutations(res, visited, 0, res.length, res.length, "");
//			}
//			//System.out.println(entry.getKey() + ": " + entry.getValue());
//		}

//		System.out.println(res);
//		int resCount = 0;
//		while (true) {
//			for (Map.Entry<Integer, List<String>> entry : res.entrySet() ) {
//				
//			}
//			if (resCount == 3) {
//				break;
//			}
//			resCount++;
//		}
		
//		Arrays.sort(arr);
//		System.out.println(Arrays.toString(arr));
//		int totalPermutation = 1;
//		List<List<Integer>> arrRes = new ArrayList<>();
//		for (int i = 0; i < n;) {
//			int groupCount = 0;
//			int j = i;
//			List<Integer> groupItem = new ArrayList<>();
//			while (j < n && arr[j] == arr[i]) {
//				groupCount++;
//				groupItem.add(j);
//				j++;
//			}
//			i = j;
//			int curTotalPermutation = factorialHavingLargeResult(groupCount).intValue();
////			System.out.println(curTotalPermutation);
//			totalPermutation *= curTotalPermutation;
//			arrRes.add(groupItem);
//		}
//		System.out.println(arrRes);
//		System.out.println(totalPermutation);
//		if (totalPermutation >= 3) {
//			System.out.println("YES");
//			int count = 0;
//			while (count <= 3) {
//				for (int i = 0; i < arrRes.size(); i++) {
//					
//				}
//			}
//		} else {
//			System.out.println("NO");
//		}
	}
	
	public static BigInteger factorialHavingLargeResult(int n) {
	    BigInteger result = BigInteger.ONE;
	    for (int i = 2; i <= n; i++)
	        result = result.multiply(BigInteger.valueOf(i));
	    return result;
	}
	
}
