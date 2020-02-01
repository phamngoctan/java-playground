package com.tanpham.playaround.algorithm;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.hamcrest.Matchers;
import org.junit.Test;

public class Day5BreadthFirstSearchShortestReachTest {

	@Test
	public void testCase01() {
		int totalNodes = 4;
		List<List<Integer>> edges = new ArrayList<>();
		edges.add(Arrays.asList(1, 2));
		edges.add(Arrays.asList(1, 3));
		int fromNode = 2;
		List<Integer> result = Day5BreadthFirstSearchShortestReach.getDistance(totalNodes, edges, fromNode);
		assertThat(result, Matchers.equalTo(new ArrayList<>(Arrays.asList(6, 6, -1))));
	}
	
	@Test
	public void testUtility__fromEdgesToGraph01() {
		List<List<Integer>> edges = new ArrayList<>();
		edges.add(Arrays.asList(1, 2));
		edges.add(Arrays.asList(1, 3));
		List<Set<Integer>> graph = Day5BreadthFirstSearchShortestReach.fromEdgesToGraph(4, edges);
		assertThat(graph.get(1), Matchers.equalTo(new LinkedHashSet<>(Arrays.asList(2, 3))));
		assertThat(graph.get(2), Matchers.equalTo(new LinkedHashSet<>(Arrays.asList(1))));
		assertThat(graph.get(3), Matchers.equalTo(new LinkedHashSet<>(Arrays.asList(1))));
	}
	
}
