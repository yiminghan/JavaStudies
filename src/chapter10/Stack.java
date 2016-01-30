package chapter10;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class Stack<E> {
	private ArrayList<E> data = new ArrayList<E>();
	private Integer top = 0;
	
	public void push(E e){
		data.add(top,e);
		top++;
	}
	
	public boolean isEmpty(){
	    if (top == 0) {
	    	return true;
	    } else {
	    	return false;
	    }
	}
	
	/*
	 * empties the stack.
	 */
	public void empty(){
		top = 0 ;
		data.clear();
	}
	
	/*
	 * Copies the elements of this stack to stack s
	 */
	public void copy(Stack<E> s){
		int temp = top;
		Stack<E> e = new Stack<E>();
		while(top > 0){
			top = top - 1;
			e.push(data.get(top));
		} 
		top = temp;
		while(!e.isEmpty()){
			s.push(e.pop());
		}
	}
	
	public E pop() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException(); 
		} else {
			top= top - 1;
			return data.get(top);
		}
	}
	
	public String toString(){
		String out = "[";
		//Can we do better than this?
		for(int i=0; i< top;i++){
			if(i != top - 1){
			out = out + data.get(i).toString() + ",";
			}
			else{
				out = out + data.get(i).toString();
			}
		}
		return out + "]";
	}

	/*
	 * reverses the contents in the stack
	 */
	public void reverse() {
		Stack<E> temp = new Stack<E>();
		copy(temp);
		empty();
		while(!temp.isEmpty()){
			push(temp.pop());
		}
	}
}

