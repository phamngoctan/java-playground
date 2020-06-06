package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Day5BFSShortestReach2 {

	private static List<List<Integer>> graph;
	private static int V;
	private static int E;
	private static List<Integer> path;
	private static List<Boolean> visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int queries = sc.nextInt();
		while (queries > 0) {
			graph = new ArrayList<>();
			for (int i = 0; i < V; i++) {
				graph.add(new ArrayList<>());
			}
			V = sc.nextInt();
			E = sc.nextInt();
			for (int i = 0; i < E; i++) {
				int u = sc.nextInt();
				int v = sc.nextInt();
				graph.get(u).add(v);
				graph.get(v).add(u);
			}
			int startingEdge = sc.nextInt();
			BFS(startingEdge);
			
			queries--;
		}
	}

	private static void BFS(int startingEdge) {
		Queue<Integer> q = new LinkedList<>();
		path = new ArrayList<>();
		for (int i = 0; i < V; i++) {
			visited.add(false);
			path.add(-1);
		}
		visited.set(startingEdge, true);
		q.add(startingEdge);
		while (!q.isEmpty()) {
			Integer u = q.remove();
			for (int i = 0; i < graph.get(u).size(); i++) {
				Integer v = graph.get(u).get(i);
				if (!visited.get(v)) {
					visited.set(v, true);
				}
			}
		}
	}
	
}
