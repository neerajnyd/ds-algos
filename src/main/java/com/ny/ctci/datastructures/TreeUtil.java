package com.ny.ctci.datastructures;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeUtil {

	public static void inOrderTraversal(TreeNode node){
		
		if(node != null){
			inOrderTraversal(node.left);
			System.out.println(node.val);
			inOrderTraversal(node.right);
		}
	
	}
	
	public static void preOrderTraversal(TreeNode node){
		
		if(node != null){
			System.out.println(node.val);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
		
	}
	
	public static void postOrderTraversal(TreeNode node){
		
		if(node != null){
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.val);
		}
		
	}

	public static boolean isSymmetric(TreeNode root){
		if(root != null){
			return isSymmetricHelper(root.left, root.right);
		}
		return true;
	}

	public static TreeNode mirrorTree1(TreeNode root){
		if(root == null){
			return root;
		}
		TreeNode left = root.left, right = root.right;

		root.left = mirrorTree1(root.right);
		root.right = mirrorTree1(root.left);
		return root;
	}

	public static TreeNode mirrorTree2(TreeNode root){
		if(root == null){
			return root;
		}
		Deque<TreeNode> treeNodes = new ArrayDeque<>();
		treeNodes.push(root);

		while(!treeNodes.isEmpty()){
			final TreeNode node = treeNodes.pop();
			final TreeNode left = node.left;
			node.left = node.right;
			node.right = left;

			if(node.left != null){
				treeNodes.push(node.left);
			}
			if(node.right != null){
				treeNodes.push(node.right);
			}
		}
		return root;
	}

	public static boolean isSubtree(TreeNode s, TreeNode t){
		if(s == null) return false;

		if(isSame(s, t)) return true;

		return isSubtree(s.left, t) || isSubtree(s.right, t);
	}

	private static boolean isSame(TreeNode s, TreeNode t) {
		if(s == null && t == null) return true;

		if(s == null || t == null) return false;

		if(s.val != t.val) return false;

		return isSame(s.left, t.left) && isSame(s.right, t.right);
	}

	private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {

		if(left == null && right == null) return true;

		if(left != null && right != null){
			return left.val == right.val && isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
		}

		return false;
	}

}
