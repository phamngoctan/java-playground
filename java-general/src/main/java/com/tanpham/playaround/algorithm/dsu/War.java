package com.tanpham.playaround.algorithm.dsu;

import java.util.Scanner;

public class War {

	private static final int MAX = 10000;
	private static int[] parent = new int[MAX + 5];
	private static int[] ranks = new int[MAX + 5];
	
	private static int[] parentEnemy = new int[MAX + 5];
	private static int[] ranksEnemy = new int[MAX + 5];
	
	public static void main(String[] args) {
		makeSet();
		makeSetEnemy();
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		while (true) {
			int action = sc.nextInt();
			int u = sc.nextInt();
			int v = sc.nextInt();
			if (action == 0 && u == 0 && v == 0) {
				break;
			}
			
			if (action == 1) {
				unionSet(u, v);
			} else if (action == 2) {
				unionSetEnemy(u, v);
			} else if (action == 3) {
				
			} else {
				
			}
		}
		
	}
	
	private static void makeSet() {
		for (int i = 1; i <= MAX; i++) {
			parent[i] = i;
			ranks[i] = 0;
		}
	}
	
	private static void makeSetEnemy() {
		for (int i = 1; i <= MAX; i++) {
			parentEnemy[i] = i;
			ranksEnemy[i] = 0;
		}
	}
	
	private static int findSet(int[] parent, int u) {
		if (u != parent[u]) {
			parent[u] = findSet(parent, parent[u]);
		}
		return parent[u];
	}
	
	private static void unionSet(int u, int v) {
		unionSet(parent, ranks, u, v);
	}
	
	private static void unionSetEnemy(int u, int v) {
		unionSet(parentEnemy, ranksEnemy, u, v);
	}
	
	private static void unionSet(int[] parent, int[] ranks, int u, int v) {
		int up = findSet(parent, u);
		int vp = findSet(parent, v);
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
