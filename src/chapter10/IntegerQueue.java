package chapter10;

public class IntegerQueue{
	//Default Size of 15
	private int[] data = new int[15];
	private int tail = 0;
	private int head = 0;
	
	public String toString(){
		String out = "[";
		int i = head;
		while(i != tail){
			out = out + data[i] + " ";
			if(i == data.length - 1){
				i = 0;
			}
			else{
				i++;
			}
		}
		return out + "]";
	}
	
	public int size(){
		if(tail > head){
			return tail - head;
		} else{
			return data.length - head + tail;
		}
	} 
	
	public IntegerQueue(int size){
		data = new int[size];
	}
	
	private boolean isFull(){
		if(head == tail + 1){
			return true;
		} else {
			return false;
		}
	} 
	
	private boolean isEmpty(){
		if(head == tail){
			return true;
		} else {
			return false;
		}
	}
	
	public void enQueue(int x) throws OverflowException{
		if(isFull()){
			throw new OverflowException();
		} else {
			data[tail] = x;
			if(data[tail] == data.length - 1){
				tail = 0;
			} else {
				tail++;
			}
		}
	}
	
	public int deQueue() throws UnderflowException{
		if(isEmpty()) {
			throw new UnderflowException();
		}
		int x = data[head];
		if(head == data.length - 1){
			head = 0;
		} else {
			head++;
		}
		return x;
	}
}
