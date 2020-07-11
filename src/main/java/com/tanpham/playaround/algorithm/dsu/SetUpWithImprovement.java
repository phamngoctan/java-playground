package com.tanpham.playaround.algorithm.dsu;


/**
 * Time complexity: mlogn
 * M number of join
 * n number of vertexes
 * @author HP
 *
 */
public class SetUpWithImprovement {
	
	private static final int MAX = 30000;
	private static int[] parent = new int[MAX + 5];
	private static int[] ranks = new int[MAX + 5];

	public static void main(String[] args) {
		makeSet();
	}

	private static void makeSet() {
		for (int i = 1; i <= MAX; i++) {
			parent[i] = i;
			ranks[i] = 0;
		}
	}
	
	private static void unionSet(int u, int v) {
		int up = findSet(u);
		int vp = findSet(v);
		parent[up] = vp;
	}

	private static int findSet(int u) {
		while (u != parent[u]) {
			parent[u] = findSet(parent[u]);
		}
		return parent[u];
	}
	
	private static void unionset(int u, int v) {
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
			parent[vp] = up;
			ranks[vp]++;
		}
	}
	
}
