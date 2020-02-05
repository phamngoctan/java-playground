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

	/*
	 *     1
	 *    / \     4
	 *   2   3
	 */
	@Test
	public void myTestCase01__from2_shouldHaveOneConnectionTo1() {
		int totalNodes = 4;
		List<List<Integer>> edges = new ArrayList<>();
		edges.add(Arrays.asList(1, 2));
		edges.add(Arrays.asList(1, 3));
		// from edge list to graph
		//                    0     1      2    3   4
		// mang rang cua --> [[], [2, 3], [1], [1], []]
		List<Set<Integer>> graph = Day5BreadthFirstSearchShortestReach.fromEdgesToGraph(totalNodes, edges);
		int fromNode = 2;
		List<Integer> result = Day5BreadthFirstSearchShortestReach.getPath(totalNodes, graph, fromNode);
		assertThat(result, Matchers.equalTo(new ArrayList<>(Arrays.asList(-1, 2, -1, 1, -1))));
	}
	
	/*
	 *     1
	 *    / \     4
	 *   2   3
	 */
	// There is no connection from node 0 to other nodes in the graph
	// expect to have all elements in the path should be -1
	@Test
	public void myTestCase02() {
		int totalNodes = 4;
		List<List<Integer>> edges = new ArrayList<>();
		edges.add(Arrays.asList(1, 2));
		edges.add(Arrays.asList(1, 3));
		// from edge list to graph
		//                    0     1      2    3   4
		// mang rang cua --> [[], [2, 3], [1], [1], []]
		List<Set<Integer>> graph = Day5BreadthFirstSearchShortestReach.fromEdgesToGraph(totalNodes, edges);
		int fromNode = 0;
		List<Integer> result = Day5BreadthFirstSearchShortestReach.getPath(totalNodes, graph, fromNode);
		assertThat(result, Matchers.equalTo(new ArrayList<>(Arrays.asList(-1, -1, -1, -1, -1))));
	}
	
	/*
	 *     1
	 *    / \     4
	 *   2   3
	 */
	@Test
	public void myTestCase03__from1_shouldHaveTwoConnectionsTo2And3() {
		int totalNodes = 4;
		List<List<Integer>> edges = new ArrayList<>();
		edges.add(Arrays.asList(1, 2));
		edges.add(Arrays.asList(1, 3));
		// from edge list to graph
		//                    0     1      2    3   4
		// mang rang cua --> [[], [2, 3], [1], [1], []]
		List<Set<Integer>> graph = Day5BreadthFirstSearchShortestReach.fromEdgesToGraph(totalNodes, edges);
		int fromNode = 1;
		List<Integer> result = Day5BreadthFirstSearchShortestReach.getPath(totalNodes, graph, fromNode);
		assertThat(result, Matchers.equalTo(new ArrayList<>(Arrays.asList(-1, -1, 1, 1, -1))));
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
	
	/*
	 *     1
	 *    / \     4
	 *   2   3
	 */
	@Test
	public void testPrintPath__moreThanTwoNodes() {
		List<Integer> path = new ArrayList<>(Arrays.asList(-1, 2, -1, 1, -1));
		List<Integer> direction = Day5BreadthFirstSearchShortestReach.printPath(path, 2, 3);
		assertThat(direction, Matchers.equalTo(new ArrayList<>(Arrays.asList(2, 1, 3))));
	}
	
	/*
	 *     1
	 *    / \     4
	 *   2   3
	 */
	@Test
	public void testPrintPath__twoNodesConnectDirectly() {
		List<Integer> path = new ArrayList<>(Arrays.asList(-1, 2, -1, 1, -1));
		List<Integer> direction = Day5BreadthFirstSearchShortestReach.printPath(path, 1, 3);
		assertThat(direction, Matchers.equalTo(new ArrayList<>(Arrays.asList(1, 3))));
	}

	/*
	 *     1
	 *    / \     4
	 *   2   3
	 */
	@Test
	public void testPrintPath__noConnection() {
		List<Integer> path = new ArrayList<>(Arrays.asList(-1, 2, -1, 1, -1));
		List<Integer> direction = Day5BreadthFirstSearchShortestReach.printPath(path, 1, 4);
		assertThat(direction, Matchers.equalTo(new ArrayList<>()));
	}
	
	/*
	 *     1
	 *    / \     4
	 *   2   3
	 */
	@Test
	public void testCase01() {
		int totalNodes = 4;
		List<List<Integer>> edges = new ArrayList<>();
		edges.add(Arrays.asList(1, 2));
		edges.add(Arrays.asList(1, 3));
		int fromNode = 1;
		List<Integer> result = Day5BreadthFirstSearchShortestReach.getDistance(totalNodes, edges, fromNode);
		assertThat(result, Matchers.equalTo(new ArrayList<>(Arrays.asList(6, 6, -1))));
	}
	
}
