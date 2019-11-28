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
	
	@Test
	public void getTreeByInOrder__emptyTree() {
		assertThat(binaryTree.getTreeByInOrder(), Matchers.equalTo(""));
	}
	
	@Test
	public void getTreeByInOrder__onlyRoot() {
		binaryTree.setRoot(new TreeNode<>("Harry"));
		assertThat(binaryTree.getTreeByInOrder(), Matchers.equalTo("Harry"));
	}
	
	/**
	 *      Harry
	 *     /
	 *  John
	 */
	@Test
	public void getTreeByInOrder__rootWithLeftChild() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByInOrder(), Matchers.equalTo("John Harry"));
	}
	
	/**
	 *      Harry
	 *           \
	 *           John
	 */
	@Test
	public void getTreeByInOrder__rootWithRightChildOnly() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addRightChild("John");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByInOrder(), Matchers.equalTo("Harry John"));
	}
	
	/**
	 *      Harry
	 *     /     \
	 *  John    Wick
	 */
	@Test
	public void getTreeByInOrder__rootTwoLevel() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		root.addRightChild("Wick");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByInOrder(), Matchers.equalTo("John Harry Wick"));
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
	public void getTreeByInOrder__rootThreeLevels() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		root.getLeftChild().addLeftChild("Terry");
		root.getLeftChild().addRightChild("Chef");
		root.addRightChild("Wick");
		root.getRightChild().addLeftChild("Lucy");
		root.getRightChild().addRightChild("Pink");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByInOrder(), Matchers.equalTo("Terry John Chef Harry Lucy Wick Pink"));
	}
	
	@Test
	public void getTreeByPreOrder__emptyTree() {
		assertThat(binaryTree.getTreeByPreOrder(), Matchers.equalTo(""));
	}
	
	@Test
	public void getTreeByPreOrder__onlyRoot() {
		binaryTree.setRoot(new TreeNode<>("Harry"));
		assertThat(binaryTree.getTreeByPreOrder(), Matchers.equalTo("Harry"));
	}
	
	
	/**
	 *      Harry
	 *     /
	 *  John
	 */
	@Test
	public void getTreeByPreOrder__rootWithLeftChild() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByPreOrder(), Matchers.equalTo("Harry John"));
	}
	
	/**
	 *      Harry
	 *           \
	 *           John
	 */
	@Test
	public void getTreeByPreOrder__rootWithRightChildOnly() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addRightChild("John");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByPreOrder(), Matchers.equalTo("Harry John"));
	}
	
	/**
	 *      Harry
	 *     /     \
	 *  John    Wick
	 */
	@Test
	public void getTreeByPreOrder__rootTwoLevel() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		root.addRightChild("Wick");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByPreOrder(), Matchers.equalTo("Harry John Wick"));
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
	public void getTreeByPreOrder__rootThreeLevels() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		root.getLeftChild().addLeftChild("Terry");
		root.getLeftChild().addRightChild("Chef");
		root.addRightChild("Wick");
		root.getRightChild().addLeftChild("Lucy");
		root.getRightChild().addRightChild("Pink");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByPreOrder(), Matchers.equalTo("Harry John Terry Chef Wick Lucy Pink"));
	}
	
	@Test
	public void getTreeByPostOrder__emptyTree() {
		assertThat(binaryTree.getTreeByPostOrder(), Matchers.equalTo(""));
	}
	
	@Test
	public void getTreeByPostOrder__onlyRoot() {
		binaryTree.setRoot(new TreeNode<>("Harry"));
		assertThat(binaryTree.getTreeByPostOrder(), Matchers.equalTo("Harry"));
	}
	
	
	/**
	 *      Harry
	 *     /
	 *  John
	 */
	@Test
	public void getTreeByPostOrder__rootWithLeftChild() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByPostOrder(), Matchers.equalTo("John Harry"));
	}
	
	/**
	 *      Harry
	 *           \
	 *           John
	 */
	@Test
	public void getTreeByPostOrder__rootWithRightChildOnly() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addRightChild("John");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByPostOrder(), Matchers.equalTo("John Harry"));
	}
	
	/**
	 *      Harry
	 *     /     \
	 *  John    Wick
	 */
	@Test
	public void getTreeByPostOrder__rootTwoLevel() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		root.addRightChild("Wick");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByPostOrder(), Matchers.equalTo("John Wick Harry"));
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
	public void getTreeByPostOrder__rootThreeLevels() {
		TreeNode<String> root = new TreeNode<>("Harry");
		root.addLeftChild("John");
		root.getLeftChild().addLeftChild("Terry");
		root.getLeftChild().addRightChild("Chef");
		root.addRightChild("Wick");
		root.getRightChild().addLeftChild("Lucy");
		root.getRightChild().addRightChild("Pink");
		
		binaryTree.setRoot(root);
		assertThat(binaryTree.getTreeByPostOrder(), Matchers.equalTo("Terry Chef John Lucy Pink Wick Harry"));
	}
	
}
