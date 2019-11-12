package com.tanpham.playaround.datastructure.binarysearchtree;

import static org.junit.Assert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

public class NodeTest {
	
	private Node<Integer> node;

	@Before
	public void init() {
		node = new Node<>(10);
	}
	
	@Test
	public void getType__leave() {
		assertThat(node.getType(), Matchers.equalTo(NodeType.LEAVE));
	}
	
	@Test
	public void getType__bothChildren() {
		node.setLeftChild(new Node<>(5));
		node.setRightChild(new Node<>(13));
		
		assertThat(node.getType(), Matchers.equalTo(NodeType.BOTH_CHILDREN));
	}
	
	@Test
	public void getType__singleLeftChild() {
		node.setLeftChild(new Node<>(5));
		assertThat(node.getType(), Matchers.equalTo(NodeType.SINGLE_LEFT_CHILD));
	}
	
	@Test
	public void getType__singleRightChild() {
		node.setRightChild(new Node<>(13));
		assertThat(node.getType(), Matchers.equalTo(NodeType.SINGLE_RIGHT_CHILD));
	}
	
	@Test
	public void delete__leftChild() {
		node.setLeftChild(new Node<>(5));
		node.setRightChild(new Node<>(13));
		
		node.delete(new Node<>(5));
		
		assertThat(node.getRightChild().getData(), Matchers.equalTo(13));
		assertThat(node.getLeftChild(), Matchers.nullValue());
	}
	
	@Test
	public void delete__rightChild() {
		node.setLeftChild(new Node<>(5));
		node.setRightChild(new Node<>(13));
		
		node.delete(new Node<>(13));
		
		assertThat(node.getLeftChild().getData(), Matchers.equalTo(5));
		assertThat(node.getRightChild(), Matchers.nullValue());
	}
	
	@Test
	public void delete__bothChild() {
		node.setLeftChild(new Node<>(5));
		node.setRightChild(new Node<>(13));
		
		node.delete(new Node<>(5));
		node.delete(new Node<>(13));
		
		assertThat(node.getLeftChild(), Matchers.nullValue());
		assertThat(node.getRightChild(), Matchers.nullValue());
		assertThat(node.getType(), Matchers.equalTo(NodeType.LEAVE));
	}
	
}
