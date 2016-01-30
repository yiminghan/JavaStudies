package chapter10;

public class DoubleLinkedListNode {
	public int key;
	public DoubleLinkedListNode prev;
	public DoubleLinkedListNode next;
	
	public DoubleLinkedListNode(int k){
		key = k;
		prev = null;
		next = null;
	}
}
