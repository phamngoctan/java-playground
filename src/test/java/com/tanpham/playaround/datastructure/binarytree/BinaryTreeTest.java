package com.tanpham.playaround.datastructure.binarytree;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class BinaryTreeTest {

	private BinaryTree<Integer> binaryTree;
	
	@Before
	public void init() {
		binaryTree = new BinaryTree<Integer>();
	}
	
	@Test
	public void getTreeByLevelOrderTravelling__emptyTree() {
		assertThat(binaryTree.getTreeByLevelOrderTravelling(), Matchers.nullValue());
	}
	
}
