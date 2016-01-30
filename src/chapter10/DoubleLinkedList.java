package chapter10;

/*
 * An implementation of linked list using sentinels
 */
public class DoubleLinkedList {
	private DoubleLinkedListNode head;
	
	public DoubleLinkedList(){
		head = new DoubleLinkedListNode(0);
		head.next = null;
		head.prev = null;
	}

	public DoubleLinkedListNode Search(int key){
		DoubleLinkedListNode x = head.next;
		while ((x.prev != null)&(x.key != key)){
			x = x.next;
		}
		return x;
	}
	
	public void Insert(DoubleLinkedListNode x){
		x.next = head.next;
		if(head.next != null){
			head.next.prev = x;
		}
		head.next = x;
		x.prev = head;
	}
	
	public void Insert(int key){
		DoubleLinkedListNode x = new DoubleLinkedListNode(key);
		Insert(x);
	}
	
	public String toString(){
		DoubleLinkedListNode x = head.next;
		String out = "[";
		while (x.next.next != null){
			out = out+ x.key + ", ";
			x = x.next;
		}
		out = out+ x.key + "]";
		return out;
	}
}
