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
	public void getTreeByPostOrderTraversalWithoutUsingRecursive__nullRoot() {
		String result = binaryTree.getTreeByPostOrderTraversalWithoutUsingRecursive();
		assertThat(result, Matchers.nullValue());
	}
	
	@Test
	public void getTreeByPostOrderTraversalWithoutUsingRecursive__onlyRoot() {
		binaryTree.setRoot(new TreeNode<Integer>(9));
		String result = binaryTree.getTreeByPostOrderTraversalWithoutUsingRecursive();
		assertThat(result, Matchers.equalTo("9"));
	}
}
