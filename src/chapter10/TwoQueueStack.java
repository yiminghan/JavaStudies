package chapter10;

public class TwoQueueStack {
	private IntegerQueue Q1;
	private IntegerQueue Q2;
	
	public TwoQueueStack(int size) {
		Q1 = new IntegerQueue(size);
		Q2 = new IntegerQueue(size);
	}
	
	public void push(int x) throws OverflowException{
		Q1.enQueue(x);
	}
	
	public int pop() throws OverflowException, UnderflowException{
		while(Q1.size() >= 2){
			Q2.enQueue(Q1.deQueue());
		}
		if(Q1.size()== 0){
			throw new UnderflowException();
		} else {
			IntegerQueue Temp = Q1;
			Q1 = Q2;
			Q2 = Temp;
			return Q2.deQueue();
		}
	}
	
}
