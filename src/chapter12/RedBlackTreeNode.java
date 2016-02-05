package chapter12;


/*
 * A Tree that stores colors (red/black) to maintain its balance
 * Each node know contains color, key, left, right, and of course parent 
 * The tree satisfies the red-black property, such that:
 * 1. Each node is either red or black
 * 2. The root is black
 * 3. All leaf(NIL) is black
 * 4. If a Node is red, then its children are black
 * 5. For each node, all simple paths from the node to descendant leaves contain the same number of black nodes
 */
public class RedBlackTreeNode{
	
	private RedBlackTreeNode left;
	private RedBlackTreeNode right;
	private RedBlackTreeNode parent;
	private Integer key;
	/*
	 * 0 = red
	 * 1 = black
	 */
	private int color;
	
	public RedBlackTreeNode(Integer x) {
			key = x;
			left = right = parent = null;
	}

	public Integer getKey(){
		return key;}

	public RedBlackTreeNode getLeft(){
		return left;}

	public RedBlackTreeNode getRight(){
		return right;
	}
	
	/*
	 * Rotate around the node x, where x is the current node
	 */
	private void leftRotate(){
		RedBlackTreeNode y = this.right;
		this.right = y.left;
		if (y.left != null){
			y.left.parent = this;
		}
		y.parent = this.parent;
		if( this.parent != null) {
			if (this == this.parent.left){
				this.parent.left = y;
			} else {
				this.parent.right = y;
			}
		}
		y.left = this;
		this.parent = y;
	}
	
	private void rightRotate(){
		RedBlackTreeNode y = this.left;
		this.left = y.right;
		if (y.right != null) {
			y.right.parent = this;
		}
		y.parent = this.parent;
		if ( this.parent!= null){
			if( this == this.parent.left){
				this.parent.left = y;
			} else {
				this.parent.right = y;
			}
		}
		y.right = this;
		this.parent = y;
	}
	
	/*
	 * Notice that in every N-node binary search tree, there are exactly N-1 possible rotations.
	 * Let us begin with a root, where N = 1.  Since it is only one node, there are no rotations, N - 1 = 0.
	 * We can easily see that adding 1 node to the tree will allow for a possible rotation, and convince ourselves
	 * that adding a node will also add a possible local root, where we can add more nodes to it and make
	 * additional possible rotations.  In addition, adding more children does not influence the exsisting rotations, 
	 * so there are N-1 possible rotations for any N-node Tree.
	 */
	
	/*
	 * We can also convince ourselves that we can shift any tree into a right children chain with 
	 * right rotations on the root and going down.  Then we can use left rotation to shift the tree into any
	 * shape we desire. 
	 */
	
	/*
	 * Similar to normal tree insert, except we fix colors at the end
	 */
	private void insert(RedBlackTreeNode x){
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
		fixColor(x);
	}
		
	public void insert(Integer k){
		RedBlackTreeNode x = new RedBlackTreeNode(k);
		x.color = 0; //Set to red
		insert(x);
		}

	private void fixColor(RedBlackTreeNode x){
		if(x.parent != null){
			while(x.parent.color == 0){
				if (x.parent.parent!=null){
					if(x.parent == x.parent.parent.left){
						RedBlackTreeNode y = x.parent.parent.right;
						if((y!= null)&&(y.color == 0)){
							x.parent.color = 1;
							y.color = 1;
							x.parent.parent.color = 0;
							fixColor(x.parent.parent);
						} else {
							if (x == x.parent.right){
								fixColor(x.parent);
								x.parent.leftRotate();
							}
							x.parent.color = 1;
							x.parent.parent.color = 0;
							x.parent.parent.rightRotate();
						}
					} else { //x.parent == x.parent.parent.right
						RedBlackTreeNode y = x.parent.parent.left;
						if((y!= null)&&(y.color == 0)){
							x.parent.color = 1;
							y.color = 1;
							x.parent.parent.color = 0;
							fixColor(x.parent.parent);
						} else {
							if (x == x.parent.left){
								fixColor(x.parent);
								x.parent.rightRotate();
							}
							x.parent.color = 1;
							x.parent.parent.color = 0;
							x.parent.parent.leftRotate();
						}
					}
				}
			}
			setRootBlack(x);
		}
	}

	private void setRootBlack(RedBlackTreeNode x) {
		if(x.parent != null){
			setRootBlack(x.parent);
		} else {
			this.color = 1;
		}
	}

}
