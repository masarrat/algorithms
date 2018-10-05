package algo;

import java.util.Stack;

public class QueueUsingStack {

	Stack<Integer> stack;
	
	public QueueUsingStack(){
		stack = new Stack<Integer>();
	}

	public void enqueue(int item){
		stack.push(item);
	}
	
	public int dequeue(){
		if(stack.size()==1){
			return stack.pop();
		}
		int item = stack.pop();
		int lastItem = dequeue();
		enqueue(item);
		return lastItem;
	}
	
}
