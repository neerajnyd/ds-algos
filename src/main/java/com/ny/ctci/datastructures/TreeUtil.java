package com.ny.ctci.datastructures;

public class TreeUtil {

	public static void inOrderTraversal(TreeNode node){
		
		if(node != null){
			inOrderTraversal(node.left);
			System.out.println(node.name);
			inOrderTraversal(node.right);
		}
	
	}
	
	public static void preOrderTraversal(TreeNode node){
		
		if(node != null){
			System.out.println(node.name);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
		
	}
	
	public static void postOrderTraversal(TreeNode node){
		
		if(node != null){
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.name);
		}
		
	}

}
