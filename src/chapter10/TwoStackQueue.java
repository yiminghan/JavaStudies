package chapter10;

/*
 * This is a implementation of Queue Using 2 Stacks
 */
public class TwoStackQueue<E> {
	private Stack<E> head = new Stack<E>();
	private Stack<E> tail = new Stack<E>();
	
	public void enQueue(E e){
		head.push(e);
	}
	
	/*
	 * The worst-case runtime of this implementation is O(n),
	 * However, the average runtime is linear. 
	 */
	public E deQueue(){
		if(tail.isEmpty()) {
			moveStack();
		} 
			return tail.pop();
	}
	
	private void moveStack(){
		while(!head.isEmpty()){
			tail.push(head.pop());
		}
	}
	
	public String toString(){
		return head.toString() + tail.toString();
	}
}
