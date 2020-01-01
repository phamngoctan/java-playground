package com.tanpham.playaround.datastructure.binarytree;

import static org.junit.Assert.assertThat;

import java.util.Stack;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeWithoutRecursiveTest {

	private BinaryTree<Integer> binaryTree;
	
	@Before
	public void init() {
		binaryTree = new BinaryTree<>();
	}
	
	@Test
	public void getTreeByPreOrderWithoutUsingRecursive__nullRoot() {
		binaryTree.setRoot(null);
		String result = binaryTree.getTreeByPreOrderWithoutUsingRecursive();
		assertThat(result, Matchers.equalTo(null));
	}
	
	@Test
	public void getTreeByPreOrderWithoutUsingRecursive__onlyRootItem() {
		binaryTree.setRoot(new TreeNode<>(10));
		String result = binaryTree.getTreeByPreOrderWithoutUsingRecursive();
		assertThat(result, Matchers.equalTo("10"));
	}
	
	/**
	 *      10
	 *     /   \
	 *    15    9
	 */
	@Test
	public void getTreeByPreOrderWithoutUsingRecursive__rootTwoLevel() {
		TreeNode<Integer> root = new TreeNode<>(10);
		root.setLeftChild(new TreeNode<>(15));
		root.setRightChild(new TreeNode<>(9));
		
		binaryTree.setRoot(root);
		
		String result = binaryTree.getTreeByPreOrderWithoutUsingRecursive();
		assertThat(result, Matchers.equalTo("10 15 9"));
	}
	
	/**
	 *       10
	 *     /    \
	 *   15      9
	 *         /   \
	 *        5     16
	 */
	@Test
	public void getTreeByPreOrderWithoutUsingRecursive__leftChildShorterThanRight() {
		TreeNode<Integer> root = new TreeNode<>(10);
		root.addLeftChild(15);
		root.addRightChild(9)
				.addLeftChild(5)
				.goBackOneLevel()
				.addRightChild(16);
		binaryTree.setRoot(root);
		
		String result = binaryTree.getTreeByPreOrderWithoutUsingRecursive();
		
		assertThat(result, Matchers.equalTo("10 15 9 5 16"));
	}
	
	/**
	 *               10
	 *         /            \
	 *       15              9
	 *    /      \         /   \
	 *   6       8        5     16
	 *         /   \
	 *        1     3
	 *       /
	 *      2
	 */ 
	@Test
	public void getTreeByPreOrderWithoutUsingRecursive__complicatedInput() {
		TreeNode<Integer> root = new TreeNode<>(10);
		root.addLeftChild(15)
				.addLeftChild(6)
				.goBackOneLevel()
				.addRightChild(8)
					.addLeftChild(1)
						.addLeftChild(2)
						.goBackOneLevel()
					.goBackOneLevel()
					.addRightChild(3);
		
		root.addRightChild(9)
				.addLeftChild(5)
				.goBackOneLevel()
				.addRightChild(16);
		binaryTree.setRoot(root);
		
		String result = binaryTree.getTreeByPreOrderWithoutUsingRecursive();
		
		assertThat(result, Matchers.equalTo("10 15 6 8 1 2 3 9 5 16"));
	}
	
	@Test
	public void getTreeByInOrderWithoutUsingRecursive__nullRoot() {
		binaryTree.setRoot(null);
		String result = binaryTree.getTreeByInOrderWithoutUsingRecursive();
		assertThat(result, Matchers.equalTo(null));
	}
	
	@Test
	public void getTreeByInOrderWithoutUsingRecursive__onlyRootItem() {
		binaryTree.setRoot(new TreeNode<>(10));
		String result = binaryTree.getTreeByInOrderWithoutUsingRecursive();
		assertThat(result, Matchers.equalTo("10"));
	}
	
	/*
	 *     9
	 *   /   \
	 *  5     7
	 */
	@Test
	public void getTreeByInOrderTraversalWithoutUsingRecursive() {
		TreeNode<Integer> root = new TreeNode<>(9);
		root.addLeftChild(5)
			.goBackOneLevel()
			.addRightChild(7);
		binaryTree.setRoot(root);
		String result = binaryTree.getTreeByInOrderWithoutUsingRecursive();
		assertThat(result, Matchers.equalTo("5 9 7"));
	}
	
	/**
	 *               9
	 *         /            \
	 *       8               20
	 *    /      \         
	 *   5       15        
	 *         /   \
	 *        2     1
	 *      
	 */ 
	@Test
	public void getTreeByInOrderWithoutUsingRecursive__manyItems() {
		TreeNode<Integer> root = new TreeNode<>(9);
		root.addLeftChild(8)
				.addLeftChild(5)
				.goBackOneLevel()
				.addRightChild(15)
					.addLeftChild(2)
					.goBackOneLevel()
					.addRightChild(1)
					.goBackOneLevel()
				.goBackOneLevel()
			.goBackOneLevel()
			.addRightChild(20);
		binaryTree.setRoot(root);
		
		String result = binaryTree.getTreeByInOrderWithoutUsingRecursive();
		assertThat(result, Matchers.equalTo("5 8 2 15 1 9 20"));
	}
	
	@Test
	public void travelToFarMostLeftChild() {
		Stack<TreeNode<Integer>> stack = new Stack<>();
		TreeNode<Integer> node = new TreeNode<>(9);
		node.addLeftChild(8)
				.addLeftChild(5)
				.goBackOneLevel()
				.addRightChild(15)
					.addLeftChild(2)
					.goBackOneLevel()
					.addRightChild(1)
					.goBackOneLevel()
				.goBackOneLevel()
			.goBackOneLevel()
			.addRightChild(20);
		binaryTree.travelToFarMostLeftChild(stack, node);
		
		assertThat(stack.get(0).getValue(), Matchers.equalTo(9));
		assertThat(stack.get(1).getValue(), Matchers.equalTo(8));
		assertThat(stack.get(2).getValue(), Matchers.equalTo(5));
	}
	
	@Test
	public void getTreeByPostOrderTraversalTwoStacksApproach__nullRoot() {
		String result = binaryTree.getTreeByPostOrderTraversalTwoStacksApproach();
		assertThat(result, Matchers.nullValue());
	}
	
	@Test
	public void getTreeByPostOrderTraversalTwoStacksApproach__onlyRoot() {
		binaryTree.setRoot(new TreeNode<Integer>(9));
		String result = binaryTree.getTreeByPostOrderTraversalTwoStacksApproach();
		assertThat(result, Matchers.equalTo("9"));
	}
	
	/*
	 *    9
	 *   / \
	 *  4   7
	 */
	@Test
	public void getTreeByPostOrderTraversalTwoStacksApproach__twoLevels() {
		TreeNode<Integer> root = new TreeNode<>(9);
		root.addLeftChild(4)
			.goBackOneLevel()
			.addRightChild(7);
		binaryTree.setRoot(root);
		
		String result = binaryTree.getTreeByPostOrderTraversalTwoStacksApproach();
		assertThat(result, Matchers.equalTo("4 7 9"));
	}
	
	/**
	 *               9
	 *         /            \
	 *       8               20
	 *    /      \         
	 *   5       15        
	 *         /   \
	 *        2     1
	 *      
	 */ 
	@Test
	public void getTreeByPostOrderTraversalTwoStacksApproach__manyItems() {
		TreeNode<Integer> root = new TreeNode<>(9);
		root.addLeftChild(8)
				.addLeftChild(5)
				.goBackOneLevel()
				.addRightChild(15)
					.addLeftChild(2)
					.goBackOneLevel()
					.addRightChild(1)
					.goBackOneLevel()
				.goBackOneLevel()
			.goBackOneLevel()
			.addRightChild(20);
		binaryTree.setRoot(root);
		
		String result = binaryTree.getTreeByPostOrderTraversalTwoStacksApproach();
		assertThat(result, Matchers.equalTo("20 1 2 15 5 8 9"));
	}
	
	@Test
	public void travelToFarMostLeftChildWithRightChildAsMarker__onlyOneNode() {
		TreeNode<Integer> node = new TreeNode<>(4);
		Stack<TreeNode<Integer>> stack = new Stack<>();
		binaryTree.travelToFarMostLeftChildWithRightChildAsMarker(stack, node);
		
		assertThat(stack.get(0).getValue(), Matchers.equalTo(4));
	}
	
	/*
	 *       1
	 *      /
	 *     2
	 *    /
	 *   3
	 */
	@Test
	public void travelToFarMostLeftChildWithRightChildAsMarker__noRightChildAtAll() {
		TreeNode<Integer> node = new TreeNode<>(1);
		node.addLeftChild(2)
				.addLeftChild(3);
		Stack<TreeNode<Integer>> stack = new Stack<>();
		binaryTree.travelToFarMostLeftChildWithRightChildAsMarker(stack, node);
		assertThat(stack.get(0).getValue(), Matchers.equalTo(1));
		assertThat(stack.get(1).getValue(), Matchers.equalTo(2));
		assertThat(stack.get(2).getValue(), Matchers.equalTo(3));
	}

	/*
	 *       1
	 *      / \
	 *     2   4
	 *    /
	 *   3
	 */
	@Test
	public void travelToFarMostLeftChildWithRightChildAsMarker__manyRightChild() {
		TreeNode<Integer> node = new TreeNode<>(1);
		node.addLeftChild(2)
				.addLeftChild(3)
				.goBackOneLevel()
			.goBackOneLevel()
			.addRightChild(4);
		Stack<TreeNode<Integer>> stack = new Stack<>();
		binaryTree.travelToFarMostLeftChildWithRightChildAsMarker(stack, node);
		assertThat(stack.get(0).getValue(), Matchers.equalTo(4));
		assertThat(stack.get(1).getValue(), Matchers.equalTo(1));
		assertThat(stack.get(2).getValue(), Matchers.equalTo(2));
		assertThat(stack.get(3).getValue(), Matchers.equalTo(3));
	}
	
	/*
	 *      1
	 *     / \
	 *    2   3
	 *   / \
	 *  4   5
	 *    
	 */
	@Test
	public void travelToFarMostLeftChildWithRightChildAsMarker__threeLevels() {
		TreeNode<Integer> node = new TreeNode<>(1);
		node.addLeftChild(2)
				.addLeftChild(4)
					.goBackOneLevel()
				.addRightChild(5)	
					.goBackOneLevel()
				.goBackOneLevel()
			.addRightChild(3);
		
		Stack<TreeNode<Integer>> stack = new Stack<>();
		binaryTree.travelToFarMostLeftChildWithRightChildAsMarker(stack, node);
		assertThat(stack.get(0).getValue(), Matchers.equalTo(3));
		assertThat(stack.get(1).getValue(), Matchers.equalTo(1));
		assertThat(stack.get(2).getValue(), Matchers.equalTo(5));
		assertThat(stack.get(3).getValue(), Matchers.equalTo(2));
		assertThat(stack.get(4).getValue(), Matchers.equalTo(4));
	}
	
	@Test
	public void travelToFarMostLeftChild__1() {
		TreeNode<Integer> node = new TreeNode<>(3);
		node.addLeftChild(6)
				.goBackOneLevel()
			.addRightChild(7)
			;
		
		Stack<TreeNode<Integer>> stack = new Stack<>();
		binaryTree.travelToFarMostLeftChildWithRightChildAsMarker(stack, node);
		assertThat(stack.get(0).getValue(), Matchers.equalTo(7));
		assertThat(stack.get(1).getValue(), Matchers.equalTo(3));
		assertThat(stack.get(2).getValue(), Matchers.equalTo(6));
	}

	/*
	 *      1
	 *     / \
	 *    2   3
	 */
	@Test
	public void getTreeByPostOrderTraversalWithoutRecursive__twoLevels() {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.addLeftChild(2)
				.goBackOneLevel()
			.addRightChild(3);
		binaryTree.setRoot(root);
		
		String result = binaryTree.getTreeByPostOrderTraversalWithoutRecursive();
		assertThat(result, Matchers.equalTo("2 3 1"));
	}
	
	/*
	 *      1
	 *     / \
	 *    2   3
	 *   / \
	 *  4   5
	 *    
	 */
	@Test
	public void getTreeByPostOrderTraversalWithoutRecursive__threeLevels() {
		TreeNode<Integer> root = new TreeNode<>(1);
//		root.addLeftChild(2)
//				.addLeftChild(4)
//					.goBackOneLevel()
//				.addRightChild(5)	
//					.goBackOneLevel()
//				.goBackOneLevel()
//			.addRightChild(3);
		
		root.addLeftChild(2)
				.addLeftChild(4)
					.goBackOneLevel()
				.addRightChild(5)	
					.goBackOneLevel()
				.goBackOneLevel()
			.addRightChild(3);
		
		binaryTree.setRoot(root);
		
		String result = binaryTree.getTreeByPostOrderTraversalWithoutRecursive();
		assertThat(result, Matchers.equalTo("4 5 2 3 1"));
	}
	
	@Test
	public void getTreeByPostOrderTraversalWithoutRecursive__1() {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.addLeftChild(2)
				.goBackOneLevel()
			.addRightChild(3)
				.addLeftChild(6)
					.goBackOneLevel()
				.addRightChild(7)
				;
		binaryTree.setRoot(root);
		System.out.println(binaryTree.getTreeByInOrder());
		
		String result = binaryTree.getTreeByPostOrderTraversalWithoutRecursive();
		assertThat(result, Matchers.equalTo("2 6 7 3 1"));
	}
	
	/*
	 *            1
	 *         /      \
	 *        2        3
	 *     /    \     / \
	 *    4      5   6   7
	 *          / \
	 *         8   9
	 *            / \
	 *          10   11
	 */
	@Test
	public void getTreeByPostOrderTraversalWithoutRecursive__manyItemsInside() {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.addLeftChild(2)
				.addLeftChild(4)
					.goBackOneLevel()
				.addRightChild(5)
					.addLeftChild(8)
						.goBackOneLevel()
					.addRightChild(9)
						.addLeftChild(10)
							.goBackOneLevel()
						.addRightChild(11)
							.goBackOneLevel()
						.goBackOneLevel()
					.goBackOneLevel()
				.goBackOneLevel()
			.addRightChild(3)
				.addLeftChild(6)
					.goBackOneLevel()
				.addRightChild(7)
				;
		binaryTree.setRoot(root);
		
		String result = binaryTree.getTreeByPostOrderTraversalWithoutRecursive();
		assertThat(result, Matchers.equalTo("4 8 10 11 9 5 2 6 7 3 1"));
	}
	
}
