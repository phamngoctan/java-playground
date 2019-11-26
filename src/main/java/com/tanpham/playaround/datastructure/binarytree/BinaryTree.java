package com.tanpham.playaround.datastructure.binarytree;

public class BinaryTree<T> {

	private TreeNode<T> root;
	
	public BinaryTree(T rootValue) {
		root = new TreeNode<>();
		root.setValue(rootValue);
	}
	
	public TreeNode<T> getRoot() {
		return root;
	}

	public String getTreeByLevelOrderTravelling() {
		// TODO: implement it
		return null;
	}
}
