package com.tanpham.playaround.algorithm.dsu;

public class SetUpInBasicApproach {
	
	private static final int MAX = 30000;
	private static int[] parent = new int[MAX + 5];

	public static void main(String[] args) {
		makeSet();
	}

	private static void makeSet() {
		for (int i = 1; i <= MAX; i++) {
			parent[i] = i;
		}
	}
	
	private static void unionSet(int u, int v) {
		int up = findSet(u);
		int vp = findSet(v);
		parent[up] = vp;
	}

	private static int findSet(int u) {
		while (u != parent[u]) {
			u = parent[u];
		}
		return u;
	}
	
}
