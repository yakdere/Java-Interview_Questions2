import java.util.Stack;


class LinkedList {

	public enum ListMode {
		FIFO,
		LIFO 
	}
	class Node {
		public int data;
		public Node next;

		Node (int d1) {
			data = d1;
		}
	}
	
	// Define Class Variables.
	private Node head;
	private Node tail;
	private ListMode mode;
	
	// Constructor
	public LinkedList(ListMode mode) {
		head = null;
		tail = null;
		this.mode = mode;  
	}		

	boolean isEmpty() {
		return head == null;
	}

	// Inserts at head, d1 becomes the first node in the list.
	void insert(int d1) {
		if (mode == ListMode.LIFO) {
			Node new_node = new Node(d1);
			new_node.next = head;
			head = new_node;
		} else if (mode == ListMode.FIFO) {
			Node new_node = new Node(d1);
			if (tail != null) tail.next = new_node;
			tail = new_node;
		}
	}

	Node getHead() {
		return head;
	}

	Node removeFirst() {
		// remove head and return it
		// TODO: what happens to tail?
		Node tmp = head;
		head = head.next;
		return tmp;
	}
	
	Node removeLast() {
		// remove the last list element and return it
		if (isEmpty()) return null;
		
		// Is there a better way using tail?
		Node curr = head;
		while (curr.next != null)
			curr = curr.next;
		return curr;
	}
	
	boolean Exists(int value) {
		 // return true if value exists in LinkedList 
		Node curr = head;
		while (curr != null) {
			if (curr.data == value)
				return true;
			curr = curr.next;
		}
		return false;
	}

	
	int Largest() throws EmptyException {
		if (isEmpty()) {
			throw new EmptyException();
		}
		
		Node curr = head;
		int max_num = curr.data ;
		while (curr.next != null) {
			curr = curr.next;
			if (curr.data > max_num) {
				max_num = curr.data;
			}
		}
		return max_num;
	}
	//when we try to find small or max number in the list. We set the head the smallest/largest and compared other elements
	//therefore we started to chech curr.next and differently end of the loop curr appointed the last number of the last element(tail)
	//it means curr = tail end of the loop
	int Smallest()throws EmptyException {
		if (isEmpty()) {
			throw new EmptyException();
		}
		Node curr = head;
		int min = curr.data;
		while (curr.next != null) {
			if (curr.next.data < min) {
				min = curr.next.data;
			}
			curr = curr.next;
		}
		return min;
	}
	//delete the max element from the list
	
	
	Stack<Integer> createStack() {
		Stack<Integer> my_stack = new Stack<Integer>();
		
		// Add all numbers in linkedlist to stack one by one
		Node curr = head;
		while (curr != null) {
			my_stack.push(curr.data);
			curr = curr.next;
		}
		return my_stack;
	}
	
	// 1 10 -3 4 5 6 -4 -5 3 2 1 5  --> return 4
	// -3 -4 2 3 4 5 4 1 -3 -4 -5 3 2 --> return 6
	int findLongestPositiveSequenceLength() {
		int counter = 0;
		int max_count = 0;
		Node curr = head;
	
		while (curr != null) {
				
			if (curr.data > 0){
				counter++;
				if (max_count < counter)
					max_count = counter;
			} else {
				counter = 0;
			}
			curr = curr.next;
		}
		return max_count;
	}
 

	void printlist() {
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.data + " ");
			curr = curr.next;
		}
		System.out.println();
	}
	
	//Bubblesort is like bubble on the sea, cuz it find the largest element on the list and carry it to tail
	//therefore bubblesort reach the last order on every iteration for last element
	// 7 2 3 -1    it start 2 and compare 7 and if need swap
	// 2 7 3 -1    now it continue to carry 7
	// 2 3 7 -1
	// 2 3 -1 7  now first iteration is finished and first element setted the right order
	void BubbleSortforLinkedList() {
		if (isEmpty() || head.next == null) return;
		Node curr = head;
		Boolean change = true;
		while (change) {
			change = false;
			while (curr != null) {
				if (curr.next.data < curr.data) {
					int temp = curr.data;
					curr.data = curr.next.data;
					curr.next.data = temp;
					change = true;
				}
			curr = curr.next;
			} 
		}
	}
	
	void DeleteMaxElement() {
		if (isEmpty()) return;
		
		Node curr = head;
		Node pre = null;
		Node max = curr; 
		//compare all data with head(we pointed it is max number) and if a data is bigger than it, save this node with name 'max',
		//also you need to keep previous node to delete max number after while loop
		while (curr.next != null) {
			if (max.data < curr.next.data) {
				max = curr.next;
				pre = curr;
			}
			curr = curr.next; //to walk all data get the next node in the list
		}
		//if previous is null which means max node is head, we have to delete first element/head
		//to do this head is now next node
		if (pre == null) {
			head = head.next;
			return;
		}
		//else max num is in between nodes you need to pass this max node. Previous data is saved for this operation
		//also you now where is the max node, therefore you can also say pre.next == max.next;
		pre.next = pre.next.next;
	}
    //we just can access to that given c node. Therefore only thing how we can delete this middle node even though dont know what is previous node
	// is just swap the data next node and delete the next node.
	// a b c d e ..is list c is given to us
	// give the c data to d and pass the next node
	// last list looks like a b d e
	Boolean deletethemiddle( Node c){
    	if ( c==null || c.next == null) return false;
    	Node curr = c;
    	while (curr.next != null) {
    		Node tmp = curr.next; //temprorary node setted current node
    		curr.data = tmp.data; //current node data setted the temproray node so they swapped
    		curr.next = tmp.next; //to remove pass the next node
    		
    		curr = curr.next; //this is for while loop
    	}
    	return true;
    }
    
	void reverse() {
		if (isEmpty() || head.next == null) return;
		Node curr = head;
		while(head.next != null) {
			Node temp = head.next;
			head.next = temp.next;
			temp.next = curr;
			curr = temp;
		}
		head = curr;
	}
	
	
}
