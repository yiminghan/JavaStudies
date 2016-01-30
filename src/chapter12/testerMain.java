package chapter12;

import java.util.Random;
/*
 * Tester for implementations of Data Structures. 
 */
public class testerMain {
	
	public static void main(String args[]){
		testTree();
	}
	
	public static void testTree(){
		BinaryTreeNode root = new BinaryTreeNode(8);
		root.insert(7);
		root.insert(10);
		root.insert(9);
		root.insert(11);
		root.insert(3);
		root.insert(12);
		System.out.println(root);
		int i = 10;
		root.delete(root.search(i));
		System.out.println("Deleted "+ i);
		System.out.println(root);
	}
}
