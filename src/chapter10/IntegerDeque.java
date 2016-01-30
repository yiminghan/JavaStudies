package chapter10;

/* 
 * A double ended Integer Queue that allows insertion and deletion from both ends
 * This is implemented by an integer array
 */
public class IntegerDeque {
	private int[] data;
	private int head;
	private int tail;
	
	public IntegerDeque(int size){
		data = new int[size];
		head = 0;
		tail = 1;
	}	
	
	public boolean isFull(){
		if(head == tail + 1) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isEmpty(){
		if(head == tail){
			return true;
		} else {
			return false;
		}
	}
	
	public void insertHead(int x) throws OverflowException{
		if(isFull()){
			throw new OverflowException();
		} else {
			data[head] = x;
			if(head == 0){
				head = data.length - 1;
			} else {
				head--;
			}
		}
	}
	
	public void insertTail(int x) throws OverflowException{
		if(isFull()){
			throw new OverflowException();
		} else {
			data[tail] = x;
			if(tail == data.length - 1) {
				tail = 0;
			} else {
				tail++;
			}
		}
	}
	
	public int releaseHead() throws UnderflowException{
		if(isEmpty()) {
			throw new UnderflowException();
		} else {
			if (head == data.length - 1){
				head = 0;
			} else {
				head++;
			}
			return data[head];
		}
	}
	
	public int releaseTail() throws UnderflowException{
		if(isEmpty()){
			throw new UnderflowException();
		} else {
			if (tail == 0) {
				tail = data.length - 1;
			} else {
				tail--;
			} 
			return data[tail];
		}
	}
	
	public String toString(){
		String out = "[";
		int i = head;
		if (i == data.length - 1){
			i = 0;
		} else {
			i++;
		}
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
	
}
