package chapter10;

/*
 * A circular implementation of single linked list
 */
public class SingleLinkedList {
	private SingleLinkedListNode head;
	private SingleLinkedListNode last;
	
	public SingleLinkedList(){
		head = null;
	}
	
	public void Insert(SingleLinkedListNode x){
		x.next = head;
		if(head == null){
			x.next = x;
			last = x;
		}
		head = x;
		last.next = x;
	}
	
	public void Insert(int key){
		SingleLinkedListNode x= new SingleLinkedListNode(key);
		Insert(x);
	}
	
	/*
	 * Delete x from the list if x is in the list
	 * Search for the key then delete if you only have the key
	 */
	public void Delete(SingleLinkedListNode x){
		SingleLinkedListNode y = head;
		SingleLinkedListNode z = last;
		while((y != x)&(y != last)){
			y = y.next;
			z = z.next;
		}
		if(y == x){
			z.next = y.next;
			if(y == head){
				y.next = head;
			}
		}
	}
	
	/*
	 * Takes Values of List LL and add them.  
	 * The pointer to LL should be destroyed after.
	 */
	public void Union(SingleLinkedList LL){
		if(head == null){
			head = LL.head;
		}else if(LL.head!=null){
		last.next = LL.head;
		LL.last.next = head;
		last = LL.last;
		}
	}
	
	/*
	 * reverses the list
	 * head becomes last and last becomes head after this.
	 */
	public void reverse(){
		SingleLinkedListNode x = head;
		SingleLinkedListNode y = x.next;
		SingleLinkedListNode z = last;
		while(x!=last){
		  y = x.next;
		  x.next = z;
		  z = x;
		  x = y;
		}
		  x.next = z;
		  head = x;
	}
	
	
	public SingleLinkedListNode search(int key){
		SingleLinkedListNode x = head;
		while((x.key != key)&(x!=last)){
			x = x.next;
		}
		if(x.key == key){
		return x;}
		else {
			return null;
		}
	}
	
	public String toString(){
		SingleLinkedListNode x = head;
		String out = "[";
		while (x.next != last){
			out = out+ x.key + ", ";
			x = x.next;
		}
		out = out+ x.key + "]";
		return out;
	}
	
}
