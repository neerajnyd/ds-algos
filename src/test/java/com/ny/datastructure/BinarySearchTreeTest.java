package com.ny.datastructure;

import org.junit.Test;

public class BinarySearchTreeTest {
	
	
	@Test
	public void testInsert(){
		
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		
		bst.insert(50);
		bst.insert(30);
		bst.insert(80);
		bst.insert(60);
		bst.insert(70);
		bst.insert(10);
		
		bst.inOrderTraversal();
		
	}
	
}
