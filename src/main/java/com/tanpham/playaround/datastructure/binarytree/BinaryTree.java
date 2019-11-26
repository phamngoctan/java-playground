package com.tanpham.playaround.datastructure.binarytree;

public class BinaryTree<T> {

	private TreeNode<T> root;
	
	public BinaryTree() {
		// empty constructor
	}
	
	public BinaryTree(T rootValue) {
		root = new TreeNode<>();
		root.setValue(rootValue);
	}
	
	public void setRoot(TreeNode<T> root) {
		this.root = root;
	}

	public TreeNode<T> getRoot() {
		return root;
	}

	public String getTreeByLevelOrderTravelling() {
		// TODO: implement it
		return null;
	}
}
