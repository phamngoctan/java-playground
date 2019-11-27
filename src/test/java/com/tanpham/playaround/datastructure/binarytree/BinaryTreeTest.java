package com.tanpham.playaround.datastructure.binarytree;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

	private BinaryTree<String> binaryTree;
	
	@Before
	public void init() {
		binaryTree = new BinaryTree<String>();
	}
	
	@Test
	public void getTreeByLevelOrderTravelling__emptyTree() {
		assertThat(binaryTree.getTreeByLevelOrderTravelling(), Matchers.nullValue());
	}
	
	@Test
	public void getTreeByLevel__onlyRoot() {
		binaryTree.setRoot(new TreeNode<>("Harry"));
		assertThat(binaryTree.getTreeByLevelOrderTravelling(), Matchers.equalTo("Harry"));
	}
	
	
	/**
	 *      Harry
	 *     /
	 *  John
	 */
	@Test
	public void getTreeByLevel__rootWithLeftChild() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByLevelOrderTravelling(), Matchers.equalTo("Harry John"));
	}
	
	/**
	 *      Harry
	 *           \
	 *           John
	 */
	@Test
	public void getTreeByLevel__rootWithRightChildOnly() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addRightChild("John");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByLevelOrderTravelling(), Matchers.equalTo("Harry John"));
	}
	
	/**
	 *      Harry
	 *     /     \
	 *  John    Wick
	 */
	@Test
	public void getTreeByLevel__rootTwoLevel() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		root.addRightChild("Wick");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByLevelOrderTravelling(), Matchers.equalTo("Harry John Wick"));
	}
	
	/**
	 *            Harry
	 *         /        \
	 *      John        Wick
	 *      /  \       /    \
	 *  Terry  Chef  Lucy   Pink
	 *  
	 */
	@Test
	public void getTreeByLevel__rootThreeLevels() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		root.getLeftChild().addLeftChild("Terry");
		root.getLeftChild().addRightChild("Chef");
		root.addRightChild("Wick");
		root.getRightChild().addLeftChild("Lucy");
		root.getRightChild().addRightChild("Pink");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByLevelOrderTravelling(), Matchers.equalTo("Harry John Wick Terry Chef Lucy Pink"));
	}
	
}
