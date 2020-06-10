package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//import java.util.Stack;

// FIXME: why I cannot finish this exercise using stack???
public class Day6DuduServiceMaker {
	
	static List<List<Integer>> graph;
//	static List<Integer> path;
	static List<Boolean> visited;
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
//		path = new ArrayList<>();
		visited = new ArrayList<>();
		inPath = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			visited.add(false);
			inPath.add(false);
//			path.add(-1);
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u - 1).add(v - 1);
		}
		
		for (int i = 0; i < V; i++) {
			if (!visited.get(i)) {
				DFS(i);
			}
		}
		
		return isCycle ? "YES" : "NO";
	}

//	private static void DFS(int starting) {
//		visited.set(starting, true);
//		inPath.set(starting, true);
//		
//		Stack<Integer> s = new Stack<>();
//		s.push(starting);
//		
//		while (!s.isEmpty()) {
//			Integer cur = s.pop();
//			for (int i = 0; i < graph.get(cur).size(); i++) {
//				Integer curVertex = graph.get(cur).get(i);
//				if (inPath.get(curVertex)) {
//					isCycle = true;
//					return;
//				}
//				if (!visited.get(curVertex)) {
//					s.push(curVertex);
//					path.set(curVertex, cur);
//					visited.set(curVertex, true);
//					inPath.set(curVertex, true);
//				}
//			}
//		}
////		inPath.set(starting, false);
//		for (int i = 0; i < inPath.size(); i++) {
//			inPath.set(i, false);
//		}
//	}
	
	private static void DFS(int starting) {
		visited.set(starting, true);
		inPath.set(starting, true);
		
		for (int i = 0; i < graph.get(starting).size(); i++) {
			Integer curVertex = graph.get(starting).get(i);
			if (inPath.get(curVertex)) {
				isCycle = true;
				return;
			}
			if (!visited.get(curVertex)) {
				DFS(curVertex);
			}
		}
		inPath.set(starting, false);
	}
	
}
