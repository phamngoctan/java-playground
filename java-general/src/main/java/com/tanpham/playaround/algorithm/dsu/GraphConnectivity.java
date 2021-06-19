package com.tanpham.playaround.algorithm.dsu;

import java.util.Scanner;

public class GraphConnectivity {
	
	private static final int MAX = 26;
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
		sc.close();
	}

	private static int handleATestCase(Scanner sc) {
		String maxVertex = sc.nextLine();
		//System.out.println("maxVertex: " + maxVertex);
		//System.out.println("NEXTLINE: " + nextLine);
		String nextLine;
		try {
			while (!(nextLine = sc.nextLine()).trim().equals("")) {
				//System.out.println(nextLine);
				int u = nextLine.charAt(0) - 'A' + 1;
				//System.out.println((int) u);
				int v = nextLine.charAt(1) - 'A' + 1;
				//System.out.println((int) v);
				unionSet(u, v);
			}
			//System.out.println(count(maxVertex));
		} catch (Exception e) {
			return count(maxVertex);
		}
		return count(maxVertex);
	}

	private static int count(String maxVertex) {
		int totalVertexes = maxVertex.charAt(0) - 'A' + 1;
		//System.out.println(totalVertexes);
		//System.out.println(Arrays.toString(parent));
		int count = 0;
		for (int i = 1; i <= totalVertexes; i++) {
			if (parent[i] == i) {
				count++;
			}
		}
		return count;
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
