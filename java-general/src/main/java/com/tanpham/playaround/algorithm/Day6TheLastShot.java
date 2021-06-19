package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

//FIXME:
/**
 * Question: what is the time complexity of this exercise???
 *
 */
public class Day6TheLastShot {

	private static List<List<Integer>> graph;
	private static List<Boolean> visited;
	private static List<Integer> path;
	private static int V;
	private static int E;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		graph = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			graph.add(new ArrayList<>());
		}
		
		for (int i = 0; i < E; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u - 1).add(v - 1);
			//graph.get(v).add(u);
		}
		sc.close();
		
		long maximumImpact = 0;
		for (int i = 0; i < V; i++) {
			reinitializeDFS(V);
			DFS(i);
			long curImpact = path.stream().filter(p -> p >= 0).count();
			maximumImpact = Math.max(curImpact, maximumImpact);
			//System.out.println(path);
		}
		System.out.println(maximumImpact + 1);
	}

	private static void reinitializeDFS(int V) {
		path = new ArrayList<>();
		visited = new ArrayList<>();
		for (int j = 0; j < V; j++) {
			visited.add(false);
			path.add(-1);
		}
	}

	private static void DFS(int i) {
		visited.set(i, true);
		Stack<Integer> s = new Stack<>();
		s.push(i);
		while (!s.isEmpty() ) {
			Integer cur = s.pop();
			List<Integer> vertexes = graph.get(cur);
			for (Integer vertex : vertexes) {
				if (!visited.get(vertex)) {
					path.set(vertex, cur);
					visited.set(vertex, true);
					s.push(vertex);
				}
			}
		}
	}
	
}
