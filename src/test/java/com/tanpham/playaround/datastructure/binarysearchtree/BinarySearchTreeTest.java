package com.tanpham.playaround.datastructure.binarysearchtree;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	
	private BinarySearchTree<Integer> binarySearchTree;

	@Before
	public void init() {
		binarySearchTree = new BinarySearchTree<>();
	}

	@Test
	public void insert_firstNode() {
		binarySearchTree.insert(5);
		assertThat(binarySearchTree.getRoot().getData(), Matchers.equalTo(5));
	}
	
	/*
	 *       5
	 *     /
	 *   3
	 */
	@Test
	public void insert__firstLeftLeave() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		
		Node<Integer> firstLeftChild = binarySearchTree.getRoot().getLeftChild();
		assertThat(firstLeftChild, Matchers.notNullValue());
		
		assertThat(firstLeftChild.getData(), Matchers.equalTo(3));
	}

	/*
	 *      5
	 *    /
	 *   3
	 *    \
	 *      4
	 */
	@Test
	public void insert__rightNodeInTheFirstLeftChild() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		
		Node<Integer> firstLeftChild = binarySearchTree.getRoot().getLeftChild();
		assertThat(firstLeftChild, Matchers.notNullValue());
		assertThat(firstLeftChild.getData(), Matchers.equalTo(3));
		
		Node<Integer> rightChild = binarySearchTree.getRoot().getLeftChild().getRightChild();
		assertThat(rightChild.getData(), Matchers.equalTo(4));
	}
	
	/*
	 *        5
	 *       /
	 *      3
	 *     / \
	 *   2     4
	 */
	@Test
	public void insert__rootWithBothChildren() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		
		Node<Integer> leftChild = binarySearchTree.getRoot().getLeftChild().getLeftChild();
		assertThat(leftChild, Matchers.notNullValue());
		assertThat(leftChild.getData(), Matchers.equalTo(2));
		
		Node<Integer> rightChild = binarySearchTree.getRoot().getLeftChild().getRightChild();
		assertThat(rightChild, Matchers.notNullValue());
		assertThat(rightChild.getData(), Matchers.equalTo(4));
	}
	
	/*
	 *        5
	 *         \
	 *          10
	 *           \
	 *            15
	 *           /
	 *          14
	 *         /
	 *        13
	 */
	@Test
	public void insert__rightChild() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(10);
		binarySearchTree.insert(15);
		binarySearchTree.insert(14);
		binarySearchTree.insert(13);
		
		Node<Integer> rightChild1 = binarySearchTree.getRoot().getRightChild();
		assertThat(rightChild1, Matchers.notNullValue());
		assertThat(rightChild1.getData(), Matchers.equalTo(10));
		
		Node<Integer> rightChild = binarySearchTree.getRoot().getRightChild().getRightChild();
		assertThat(rightChild, Matchers.notNullValue());
		assertThat(rightChild.getData(), Matchers.equalTo(15));
		
		Node<Integer> leftChild = binarySearchTree.getRoot().getRightChild().getRightChild().getLeftChild();
		assertThat(leftChild, Matchers.notNullValue());
		assertThat(leftChild.getData(), Matchers.equalTo(14));
		
		Node<Integer> leftChild2 = binarySearchTree.getRoot().getRightChild().getRightChild().getLeftChild().getLeftChild();
		assertThat(leftChild2, Matchers.notNullValue());
		assertThat(leftChild2.getData(), Matchers.equalTo(13));
	}
	
	/*
	 *        5
	 *         \
	 *          10
	 *         / \
	 *        6   15
	 */
	@Test
	public void insert__rightNodeWithBothChildren() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(10);
		binarySearchTree.insert(15);
		binarySearchTree.insert(6);
		
		Node<Integer> rightChild1 = binarySearchTree.getRoot().getRightChild();
		assertThat(rightChild1, Matchers.notNullValue());
		assertThat(rightChild1.getData(), Matchers.equalTo(10));
		
		Node<Integer> rightChild = binarySearchTree.getRoot().getRightChild().getRightChild();
		assertThat(rightChild, Matchers.notNullValue());
		assertThat(rightChild.getData(), Matchers.equalTo(15));
		
		Node<Integer> leftChild = binarySearchTree.getRoot().getRightChild().getLeftChild();
		assertThat(leftChild, Matchers.notNullValue());
		assertThat(leftChild.getData(), Matchers.equalTo(6));
	}
}
