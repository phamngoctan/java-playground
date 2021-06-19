package com.tanpham.playaround.algorithm.dsu;

import java.util.Scanner;

public class Friends {
	
	private static final int MAX = 30000;
	private static int[] parent = new int[MAX + 5];
	private static int[] ranks = new int[MAX + 5];
	private static int[] size = new int[MAX + 5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalTestCases = sc.nextInt();
		for (int i = 0; i < totalTestCases; i++) {
			makeSet();
			handleATestCase(sc);
		}
	}

	private static void handleATestCase(Scanner sc) {
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			unionSet(u, v);
		}
		//System.out.println(Arrays.toString(parent));
		
		int maxSize = Integer.MIN_VALUE;
		for (int i = 0; i < MAX; i++) {
			int curSize = getSize(i);
			if (maxSize < curSize) {
				maxSize = curSize;
			}
		}
		System.out.println(maxSize);
	}

	private static void makeSet() {
		for (int i = 1; i <= MAX; i++) {
			parent[i] = i;
			ranks[i] = 0;
			size[i] = 1;
		}
	}
	
	// Path compression
	private static int findSet(int u) {
		if (u != parent[u]) {
			parent[u] = findSet(parent[u]);
		}
		return parent[u];
	}
	
	private static void unionSet(int u, int v) {
		int up = findSet(u);
		int vp = findSet(v);
		if (up == vp) {
			return;
		}
		
		if (ranks[up] > ranks[vp]) {
			parent[vp] = up;
			size[up] += size[vp];
		} else if (ranks[vp] > ranks[up]) {
			parent[up] = vp;
			size[vp] += size[up];
		} else {
			parent[up] = vp;
			size[vp] += size[up];
			ranks[vp]++;
		}
	}
	
	private static int getSize(int u) {
		return size[findSet(u)];
	}
	
}
