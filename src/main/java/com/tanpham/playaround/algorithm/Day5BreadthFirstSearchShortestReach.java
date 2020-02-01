package com.tanpham.playaround.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Day5BreadthFirstSearchShortestReach {

	public static List<Integer> getDistance(int totalNodes, List<List<Integer>> edges, int fromNode) {
		List<Set<Integer>> graph = fromEdgesToGraph(totalNodes, edges);
		// prepare for single graph
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> path = new ArrayList<>();
		List<Boolean> visited = new ArrayList<>();
		for (int i = 0; i < totalNodes; i++) {
			visited.add(false);
			path.add(-1);
		}
		visited.set(fromNode, true);
		queue.add(fromNode);
		
		while (!queue.isEmpty()) {
			
		}
			
		return null;
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
	
}
