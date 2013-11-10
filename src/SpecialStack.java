import java.util.Stack;

//How would you design a stack which, in addition to push and pop, also has a function min which returns the minimum element?
//Push, pop and min should all operate in O(1) time.
public class SpecialStack {

	Stack <Integer> mStack;
	
	SpecialStack() {
		mStack = new Stack<Integer>();
	}
	
	void push(int value) {
		if (value <= min()) {
			mStack.push(value);
		}
	}
	
	private int min() {
		if(mStack.isEmpty()) {
		return 0;
		} else {
			return mStack.peek();
		}
	}
	
	int pop() {
		int value = this.pop();
		if( value == min()) {
			mStack.pop();
		}
		return value;
	}

	public static void main(String[] args) {
		Stack <Integer> newStack = new Stack<Integer>();
		newStack.push(8);
		System.out.println("peek: "+newStack.peek());
		newStack.push(1);
		System.out.println("peek: "+newStack.peek());
		newStack.push(3);
		System.out.println("Min value in stack: "+newStack.pop());
		System.out.println("peek: "+newStack.peek());
		newStack.push(2);
		System.out.println("peek: "+newStack.peek());
		newStack.push(9);
		System.out.println("peek: "+newStack.peek());
		
		System.out.println("Min value in stack: "+newStack.pop());
	}

}
