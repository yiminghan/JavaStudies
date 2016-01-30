package chapter12;

import chapter10.OverflowException;
import chapter10.Stack;

/*
 * Basic Binary Tree that satisfies the binary tree property.
 * Uses Integer as a key.
 */
public class BinaryTreeNode {
	private BinaryTreeNode left;
	private BinaryTreeNode right;
	private BinaryTreeNode parent;
	private Integer key = null;
	
	public BinaryTreeNode(Integer x){
		key = x;
		left = right = parent = null;
	}
	
	public Integer getKey(){
		return key;}
	
	public BinaryTreeNode getLeft(){
		return left;
	}
	
	public BinaryTreeNode getRight(){
		return right;
	}
	
	public void inOrderTreeWalk(){
		if(key != null){
			left.inOrderTreeWalk();
			System.out.println(key);
			right.inOrderTreeWalk();
		}
	}
	
	public void preOrderTreeWalk(){
		if(key != null){
			System.out.println(key);
			left.inOrderTreeWalk();
			right.inOrderTreeWalk();
		}
	}
	
	public void postOrderTreeWalk(){
		if(key != null){
			left.inOrderTreeWalk();
			right.inOrderTreeWalk();
			System.out.println(key);
		}
	}
	
	
	public void addLeft(BinaryTreeNode x) throws OverflowException{
		if(left == null){
			throw new OverflowException();
		} else {
			left = x;
			x.setParent(this);
		}
	}
	
	private void setParent(BinaryTreeNode x) {
		parent = x;
	}

	public void addRight(BinaryTreeNode x) throws OverflowException{
		if(right == null){
			throw new OverflowException();
		} else {
			right = x;
			x.setParent(this);
		}
	}
	
	/*
	 * Searches a node recursively
	 */
	public BinaryTreeNode search(Integer k){
		if(key == k){
			return this;
		} else if(key > k){
			if(left == null){
				return null;
			} else{ 
				return left.search(k);
			}
		} else {
			if (right == null){
				return null;
			} else {
				return right.search(k);
			}
		}
	}
	
	/*
	 * Searches for a node in an iterative fashion.
	 * Can be used on any Node. 
	 */
	public BinaryTreeNode search(BinaryTreeNode x, Integer k){
		while((x != null)|(x.getKey() != k)){
			if(x.getKey() < k){
				x = x.getLeft();
			}
		} return x;
	}
	
	/*
	 * Returns the Node with the smallest key.
	 */
	public BinaryTreeNode findMin(){
		BinaryTreeNode x = this;
		while(x.left != null){
			x = x.left;
		} return x;
	}
	
	/*
	 * Returns the Node with the largest key.
	 */
	public BinaryTreeNode findMax(){
		BinaryTreeNode x = this;
		while(x.right != null){
			x = x.right;
		} return x;
	}
	
	/*
	 * Treat this node as a subtree and insert node x into it.
	 */
	public void insert(BinaryTreeNode x){
		if(x.getKey() <= key){
		    if(left!= null){
		    	left.insert(x);
		    } else {//left == null
		    	left= x; 
		    	x.parent = this;
		 } 
		}else {//x.getKey() > key
			if(right!=null){
				right.insert(x);
			} else {
				right = x;
				right.parent = this;
			}
		}
	}
	
	public void insert(Integer k){
		BinaryTreeNode x = new BinaryTreeNode(k);
		insert(x);
	}
	
	/*
	 * Delete the node x from the tree
	 */
	public void delete(BinaryTreeNode x){
		if(x.left == null){
			transplant(x,x.right);
		} else if(x.right == null){
			transplant(x,x.left);
		} else {
			BinaryTreeNode y = x.right.findMin();
			if(y.parent != x){
				transplant(y,y.right);
				y.right = x.right;
				y.right.parent = y;
			} 
			transplant(x,y);
			y.left = x.left;
			y.left.parent = y;
		}
	}
	
	
	/*
	 * replaces the node x with y
	 */
	public void transplant(BinaryTreeNode x, BinaryTreeNode y){
		if(x.parent == null){
			x = y;
		}else if(x == x.parent.left){
			x.parent.left = y;
		} else {
			x.parent.right = y;
		} 
		if(y != null){
			y.parent = x.parent;
		}
	}
	
	//TODO: implement a better illustration. 
	public String toString(){
		BinaryTreeNode x = this;
		String out = "";
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> S2 = new Stack<BinaryTreeNode>();
		s.push(x);
		while(!s.isEmpty()){
			s.copy(S2);
			s.empty();
			while(!S2.isEmpty()){
				x = S2.pop();
				out = out + x.getKey().toString() + " ";
				if(x.getLeft()!= null){
				s.push(x.getLeft());}
				if(x.getRight()!= null){
				s.push(x.getRight());}
			}
			s.reverse();
			out = out + "\n";
		}
		return out + "";
	}
	 
}
