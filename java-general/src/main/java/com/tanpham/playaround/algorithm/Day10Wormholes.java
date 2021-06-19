package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Main idea: find the negative path cycle (chu trinh am)
 */
public class Day10Wormholes {

	static class Edge {
		public int source;
		public int target;
		public int weight;
		public Edge(int source, int target, int weight) {
			this.source = source;
			this.target = target;
			this.weight = weight;
		}
		@Override
		public String toString() {
			return "Edge [source=" + source + ", target=" + target + ", weight=" + weight + "]";
		}
	}
	
	private static final int INF = (int)1e9;
	private static final int MAX = 1005;
	private static final int[] dist = new int[MAX];
	private static Edge[] graph;
	private static int n, m;
	private static int[] path = new int[MAX];
	
	private static boolean BellmanFord(int s) {
		int u, v, w;
		dist[s] = 0;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m; j++) {
				u = graph[j].source;
				v = graph[j].target;
				w = graph[j].weight;
				if (dist[u] != INF && dist[u] + w < dist[v]) {
					dist[v] = dist[u] + w;
					path[v] = u;
				}
			}
		}
		
		for (int i = 0; i < m; i++) {
			u = graph[i].source;
			v = graph[i].target;
			w = graph[i].weight;
			if (dist[u] != INF && dist[u] + w < dist[v]) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalTestCases = sc.nextInt();
		List<String> res = new ArrayList<>();
		for (int i = 0; i < totalTestCases; i++) {
			res.add(handleATestCase(sc));
		}
		sc.close();
		res.forEach(System.out::println);
	}

	private static String handleATestCase(Scanner sc) {
		n = sc.nextInt();
		m = sc.nextInt();
		graph = new Edge[m];
		Arrays.fill(dist, INF);
		Arrays.fill(path, -1);
		int u, v, w;
		for (int i = 0; i < m; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();
			graph[i] = new Edge(u, v, w);
		}
		
		for (int i = 0; i < n; i++) {
			if (path[i] == -1) {
				boolean res = BellmanFord(i);
				if (!res) {
					return "possible";
				}
			}
		}
		return "not possible";
	}
	
}
