package chapter10;

import java.util.EmptyStackException;

public class Chapter10 {
	public static void main(String args[]){
	testStack();
	}
	
	public static void testStack() throws EmptyStackException{
		Stack<Integer> S = new Stack<Integer>();
		S.push(4);
		S.push(1);
		S.push(3);
		S.push(8);
		System.out.println(S);
		Stack<Integer> Scopy = new Stack<Integer>();
		S.copy(Scopy);
		System.out.println(Scopy);
	}
	
	public static void testQueue() throws OverflowException, UnderflowException{
		TwoStackQueue<Integer> Q = new TwoStackQueue<Integer>();
		Q.enQueue(4);
		Q.enQueue(1);
		Q.enQueue(3);
		System.out.println(Q.deQueue());
		Q.enQueue(8);
		Q.enQueue(7);
		Q.enQueue(1);
		System.out.println(Q.deQueue());
		System.out.println(Q);
	}
	
	public static void testDeque() throws OverflowException, UnderflowException{
		IntegerDeque D = new IntegerDeque(6);
		System.out.println(D);
		D.insertHead(1);
		D.insertHead(2);
		D.insertHead(3);
		D.insertTail(4);
		D.releaseHead();
		D.releaseTail();
		System.out.println(D);
	}
	
	public static void testLinkedList(){
		SingleLinkedList LL = new SingleLinkedList();
		for(int i =0;i<10;i++){
			LL.Insert(i);
		}
		SingleLinkedListNode x = LL.search(5);
		LL.Delete(x);
		LL.reverse();
		System.out.println(LL);
	}
}
