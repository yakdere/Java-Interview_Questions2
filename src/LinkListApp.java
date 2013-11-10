
public class LinkListApp {

	    public static void main(String[] args) throws EmptyException {

	        LinkedList list1 = new LinkedList(LinkedList.ListMode.LIFO);
	        LinkedList list2 = new LinkedList(LinkedList.ListMode.LIFO);

	        list1.insert(10);
	        list1.insert(20);
	        list1.insert(30);
	        list1.insert(40);
	        list1.insert(50);
	        list1.insert(60);
	        list1.insert(70);
	       
	        list1.printlist();
	        list1.reverse();
	        list1.printlist();
	        list1.createStack();
	        //list1.deletethemiddle(40);
	        //list1.printlist();
	        
	        list2.insert(1);
	        list2.insert(10);
	        list2.insert(-3);
	        list2.insert(4);
	        list2.insert(5);
	        list2.insert(6);
	        list2.insert(-4);
	        list2.insert(-5);
	        list2.insert(3);
	        list2.insert(2);
	        list2.insert(1);
	        list2.insert(5);
	        
	        list2.printlist();
	        //list2.BubbleSortforLinkedList();
	        //list2.printlist();
	        
	        	        
	        System.out.println("40 exists in list: " + list1.Exists(40));
	        System.out.println("100 exists in list: " + list1.Exists(100));
	        
	        System.out.println("the largest number in first list: " + list1.Largest());
	        System.out.println("the smallest number in first list: " + list1.Smallest());
	        
	        System.out.println("the largest number in second list: " + list2.Largest());
	        System.out.println("the smallest number in second list: " + list2.Smallest());
	        
	        System.out.println("the longest positive sequence lenght in list: " + list2.findLongestPositiveSequenceLength());
	        
	        
	        
	               
	    }
	}