package com.tanpham.playaround.algorithm.dsu;

import java.util.Arrays;
import java.util.Scanner;

public class Forests {
	private static final int MAX = 100;
	private static int[] parent = new int[MAX + 5];
	private static int[] ranks = new int[MAX + 5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalTestCases = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		int[] res = new int[totalTestCases];
		for (int i = 0; i < totalTestCases; i++) {
			makeSet();
			res[i] = handleATestCase(sc);
		}
		for (int i = 0; i < totalTestCases; i++) {
			System.out.println(res[i]);
			System.out.println("");
		}
	}
	
	private static int handleATestCase(Scanner sc) {
		String[] head = sc.nextLine().split(" ");
		int P = Integer.parseInt(head[0]);
		int T = Integer.parseInt(head[1]);
		
		boolean[][] grid = new boolean[P + 1][T + 1];
		String nextLine;
		try {
			while (!(nextLine = sc.nextLine()).trim().equals("")) {
				//System.out.println(nextLine);
				String[] split = nextLine.split(" ");
				int p = Integer.parseInt(split[0]);
				//System.out.println((int) u);
				int v = Integer.parseInt(split[1]);
				//System.out.println((int) v);
				grid[p][v] = true;
			}
			//System.out.println(count(maxVertex));
		} catch (Exception e) {
			countOpinion(P, grid);
		}
		
		//System.out.println(Arrays.toString(parent));
		return countOpinion(P, grid);
	}

	private static int countOpinion(int P, boolean[][] grid) {
		for (int i = 1; i < P; i++) {
			for (int j = i + 1; j < P + 1; j++) {
				if (heardSameTrees(grid[i], grid[j])) {
					unionSet(i, j);
				}
			}
		}
		
		int count = 0;
		for (int i = 1; i <= P; i++) {
			if (findSet(i) == i) {
				count++;
			}
		}
		return count;
	}

	private static boolean heardSameTrees(boolean[] bs, boolean[] bs2) {
		for (int i = 0; i < bs.length; i++) {
			if (bs[i] != bs2[i]) {
				return false;
			}
		}
		return true;
	}

	private static void makeSet() {
		for (int i = 1; i <= MAX; i++) {
			parent[i] = i;
			ranks[i] = 0;
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
		} else if (ranks[vp] > ranks[up]) {
			parent[up] = vp;
		} else {
			parent[up] = vp;
			ranks[vp]++;
		}
	}
	
}
