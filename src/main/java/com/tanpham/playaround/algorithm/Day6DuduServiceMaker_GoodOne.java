package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day6DuduServiceMaker_GoodOne {
	
	static List<List<Integer>> graph;
	static List<Integer> visited;
	static List<Boolean> inPath;
	static boolean isCycle;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		
		List<String> res = new ArrayList<>();
		for (int i = 0; i < testCases; i++) {
			res.add(handleATestCase(sc));
		}
		sc.close();
		res.forEach(i -> System.out.println(i));
	}

	private static String handleATestCase(Scanner sc) {
		isCycle = false;
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		graph = new ArrayList<>();
		visited = new ArrayList<>();
		inPath = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			visited.add(0);
			inPath.add(false);
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u - 1).add(v - 1);
		}
		
		for (int i = 0; i < V; i++) {
			if (visited.get(i) == 0) {
				DFS(i);
			}
		}
		
		return isCycle ? "YES" : "NO";
	}
	
	private static void DFS(int starting) {
		visited.set(starting, 1);
		
		for (int i = 0; i < graph.get(starting).size(); i++) {
			Integer curVertex = graph.get(starting).get(i);
			if (visited.get(curVertex) == 1) {
				isCycle = true;
				return;
			}
			if (visited.get(curVertex) == 0) {
				DFS(curVertex);
			}
		}
		visited.set(starting, 2);
	}
	
}
