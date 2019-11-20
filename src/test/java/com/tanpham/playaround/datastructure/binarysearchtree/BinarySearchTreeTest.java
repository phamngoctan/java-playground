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
	
	@Test
	public void toString__nullRoot() {
		String result = binarySearchTree.toStringFollowingPreOrder();
		assertThat(result, Matchers.equalTo(""));
	}
	
	/*
	 *      5
	 *    /
	 *   3
	 *    \
	 *      4
	 */
	@Test
	public void toString__followingPreOrder() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		
		String result = binarySearchTree.toStringFollowingPreOrder();
		assertThat(result, Matchers.equalTo("5 3 4"));
	}
	
	/*
	 *        5
	 *       /
	 *      3
	 *     / \
	 *   2     4
	 */
	@Test
	public void toString__followingPreOrder__rootWithBothChildren() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		
		String result = binarySearchTree.toStringFollowingPreOrder();
		assertThat(result, Matchers.equalTo("5 3 2 4"));
	}
	
	/*
	 *          5
	 *       /     \
	 *      3        10
	 *     / \      /  \ 
	 *   2     4  8     15
	 */
	@Test
	public void toString__followingPreOrder__rootWithBothChildren2() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		
		binarySearchTree.insert(10);
		binarySearchTree.insert(8);
		binarySearchTree.insert(15);
		
		String result = binarySearchTree.toStringFollowingPreOrder();
		assertThat(result, Matchers.equalTo("5 3 2 4 10 8 15"));
	}
	
	@Test
	public void delete__emptyTree() {
		binarySearchTree.delete(5);
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo(""));
	}
	
	/*
	 *        5
	 */
	@Test
	public void delete__correctlyOneRemainingNode() {
		binarySearchTree.insert(5);
		binarySearchTree.delete(5);
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo(""));
	}
	
	/*
	 *        5
	 *       /
	 *      3
	 *     / \
	 *   2     4
	 */
	@Test
	public void delete__leftLeave() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		
		binarySearchTree.delete(2);
		assertThat(binarySearchTree.getRoot().getLeftChild().getLeftChild(), Matchers.nullValue());
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo("5 3 4"));
	}
	
	/*
	 *        5
	 *       /
	 *      3
	 *     /
	 *   2 
	 */
	@Test
	public void delete__leftNode_singleLeftChildType() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(2);
		
		binarySearchTree.delete(3);
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo("5 2"));
	}
	
	/*
	 *        5
	 *       /
	 *      3
	 *     /
	 *    2
	 *   /
	 *  1
	 */
	@Test
	public void delete__leftNode_singleLeftChildType__theChildAlsoARootOfAnotherChild() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(2);
		binarySearchTree.insert(1);
		
		binarySearchTree.delete(3);
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo("5 2 1"));
	}
	
	/*
	 *        5
	 *       /
	 *      3
	 *     / \
	 *   2     4
	 */
	@Test
	public void delete__rightLeave() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		
		binarySearchTree.delete(4);
		assertThat(binarySearchTree.getRoot().getLeftChild().getRightChild(), Matchers.nullValue());
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo("5 3 2"));
	}
	
	/*
	 *        5
	 *         \
	 *          8 
	 *            \
	 *             16
	 */
	@Test
	public void delete__rightNode_singleLeftChildType() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(8);
		binarySearchTree.insert(16);
		
		binarySearchTree.delete(8);
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo("5 16"));
	}
	
	/*
	 *        5
	 *          \
	 *           9
	 *            \
	 *            15
	 *              \
	 *              18
	 */
	@Test
	public void delete__leftNode_singleRightChildType__theChildAlsoARootOfAnotherChild() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(9);
		binarySearchTree.insert(15);
		binarySearchTree.insert(18);
		
		binarySearchTree.delete(9);
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo("5 15 18"));
	}
	
	@Test
	public void findSmallestValue_nullBinaryTree() {
		assertThat(binarySearchTree.findSmallestValue(), Matchers.nullValue());
	}
	
	@Test
	public void findSmallestValue() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		
		Integer smallestValue = binarySearchTree.findSmallestValue();
		assertThat(smallestValue, Matchers.equalTo(2));
	}
	
	@Test
	public void findSmallestValue__onlyRoot() {
		binarySearchTree.insert(5);
		
		Integer smallestValue = binarySearchTree.findSmallestValue();
		assertThat(smallestValue, Matchers.equalTo(5));
	}
	
	@Test
	public void findSmallestValue__onlyLeftChild() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		
		Integer smallestValue = binarySearchTree.findSmallestValue();
		assertThat(smallestValue, Matchers.equalTo(3));
	}
	
	@Test
	public void findSmallestValue__onlyRightChild() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(8);
		binarySearchTree.insert(100);
		
		Integer smallestValue = binarySearchTree.findSmallestValue();
		assertThat(smallestValue, Matchers.equalTo(5));
	}
	
	/*
	 *        5
	 *       /
	 *      3
	 *     / \
	 *   2     4
	 */
	@Test
	public void delete__root() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		
		binarySearchTree.delete(3);
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo("5 4 2"));
	}
	
	/*
	 *        5
	 *       /
	 *      3
	 *     / \
	 *   2     4
	 *          \
	 *           8
	 */
	@Test
	public void delete__root__theSmallestRightChildHasARightChild() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(3);
		binarySearchTree.insert(2);
		binarySearchTree.insert(4);
		binarySearchTree.insert(8);
		
		binarySearchTree.delete(3);
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo("5 4 2 8"));
	}
	
	/*
	 *        10
	 *       /
	 *      2
	 *     / \
	 *   1     4
	 *        / \
	 *       3   8
	 */
	@Test
	public void delete__root__theSmallestRightChild__isNotRightAfterTheRightChild() {
		binarySearchTree.insert(10);
		binarySearchTree.insert(2);
		binarySearchTree.insert(1);
		binarySearchTree.insert(4);
		binarySearchTree.insert(8);
		binarySearchTree.insert(3);
		
		binarySearchTree.delete(2);
		assertThat(binarySearchTree.toStringFollowingPreOrder(), Matchers.equalTo("10 3 1 4 8"));
	}
	
	@Test
	public void getValue__nullRoot() {
		String result = binarySearchTree.getValue();
		assertThat(result, Matchers.nullValue());
	}
	
	/*
	 *        10
	 *       /
	 *      2
	 *     / \
	 *   1     4
	 *        / \
	 *       3   8
	 */
	@Test
	public void getValue__minToMaxOrder_happyPath() {
		binarySearchTree.insert(10);
		binarySearchTree.insert(2);
		binarySearchTree.insert(1);
		binarySearchTree.insert(4);
		binarySearchTree.insert(8);
		binarySearchTree.insert(3);
		
		String result = binarySearchTree.getValue();
		assertThat(result, Matchers.equalTo("1 2 3 4 8 10"));
	}
	
	/*
	 *        10
	 */
	@Test
	public void getValue__onlyRoot() {
		binarySearchTree.insert(10);
		String result = binarySearchTree.getValue();
		assertThat(result, Matchers.equalTo("10"));
	}
	
	/*
	 *        10
	 *       /
	 *      2
	 *     /
	 *    1
	 */
	@Test
	public void getValue__onlyLeftTree() {
		binarySearchTree.insert(10);
		binarySearchTree.insert(2);
		binarySearchTree.insert(1);
		
		String result = binarySearchTree.getValue();
		assertThat(result, Matchers.equalTo("1 2 10"));
	}
	
	/*
	 *        10
	 *          \
	 *           16
	 *           /
	 *         12 
	 */
	@Test
	public void getValue__onlyRightTree() {
		binarySearchTree.insert(10);
		binarySearchTree.insert(16);
		binarySearchTree.insert(12);
		
		String result = binarySearchTree.getValue();
		assertThat(result, Matchers.equalTo("10 12 16"));
	}
	
	
}
