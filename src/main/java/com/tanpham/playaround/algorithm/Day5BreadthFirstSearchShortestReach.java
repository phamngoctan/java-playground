package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Day5BreadthFirstSearchShortestReach {
	
	public static List<Integer> getDistance(int totalNodes, List<List<Integer>> edges, int fromNode) {
		List<Set<Integer>> graph = fromEdgesToGraph(totalNodes, edges);
		List<Integer> path = getPath(totalNodes, graph, fromNode);
		// TODO: implement more
		return null;
	}

	public static List<Integer> getPath(int totalNodes, List<Set<Integer>> graph, int fromNode) {
		System.out.println(graph);
		// prepare for single graph
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> path = new ArrayList<>();
		List<Boolean> visited = new ArrayList<>();
		for (int i = 0; i <= totalNodes; i++) {
			visited.add(false);
			path.add(-1);
		}
		visited.set(fromNode, true);
		queue.add(fromNode);
		
		while (!queue.isEmpty()) {
			int u = queue.poll();
			graph.get(u).stream().forEach(v -> {
				if (!visited.get(v)) {
					visited.set(v, true);
					queue.add(v);
					path.set(v, u);
				}
			});
		}
		
		System.out.println(path);
		
		return path;
	}

	protected static List<Set<Integer>> fromEdgesToGraph(int totalNodes, List<List<Integer>> edges) {
		List<Set<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= totalNodes; i++) {
			graph.add(new LinkedHashSet<>());
		}
		
		for (List<Integer> pairEdges : edges) {
			graph.get(pairEdges.get(0)).add(pairEdges.get(1));
			graph.get(pairEdges.get(1)).add(pairEdges.get(0));
		}
		return graph;
	}
	
	public static void printPath(List<Integer> path, int fromNode, int toNode) {
		int[] arr = new int[Integer.MAX_VALUE];
		int m = 0;
		if (fromNode == toNode) {
			System.out.println(fromNode);
			return;
		}
		
		if (path.get(toNode) == -1) {
			System.out.println(String.format("No path from %s to %s", fromNode, toNode));
			return;
		}
	}
	
}
