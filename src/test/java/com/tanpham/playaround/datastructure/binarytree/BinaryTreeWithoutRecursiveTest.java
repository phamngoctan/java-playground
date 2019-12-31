package com.tanpham.playaround.datastructure.binarytree;

import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.hamcrest.Matchers;

public class BinaryTreeWithoutRecursiveTest {

	private BinaryTree<Integer> binaryTree;
	
	@Before
	public void init() {
		binaryTree = new BinaryTree<>();
	}
	
	/**
	 *      10
	 *     /   \
	 *    15    9
	 */
	@Test
	public void getTreeByPreOrder__rootTwoLevel() {
		TreeNode<Integer> root = new TreeNode<>(10);
		root.setLeftChild(new TreeNode<>(15));
		root.setRightChild(new TreeNode<>(9));
		
		binaryTree.setRoot(root);
		
		String result = binaryTree.getTreeByPreOrderWithoutUsingRecursive();
		assertThat(result, Matchers.equalTo("10 15 9"));
	}
	
}
