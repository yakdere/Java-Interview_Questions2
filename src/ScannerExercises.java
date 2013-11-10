import java.util.ArrayList;
import java.util.Scanner;


public class ScannerExercises {
	  public static void run(Scanner scanner) {
		    int inputlines_count = Integer.parseInt(scanner.nextLine());
		    ArrayList<Character> allnodes = new ArrayList<Character>();
		    char[] inputs = new char[inputlines_count*2];
		    while ( scanner.hasNext()) { 
		        String s = scanner.next();
		        inputs = s.toCharArray(); 
		      for ( int i = 0; i < inputs.length; i++) {
		          if(!allnodes.contains(inputs[i])) { 
		                allnodes.add(inputs[i]);
		          }
		      }
		    }
		    BinaryNode root = new BinaryNode(allnodes.get(0));
		    level_order_insert(root, allnodes, 0, allnodes.size());
		    print_preorder(root);
		  }
		  public static class BinaryNode {
		      char data;
		      BinaryNode right;
		      BinaryNode left;
		     BinaryNode(char data) { 
		        this.data = data; 
		        right = null;
		        left = null;
		    }      
		  }
		  public static class BinaryTree {
		     BinaryNode root = null;
		     BinaryTree() { }
		  }
		  public static void level_order_insert(BinaryNode root, ArrayList<Character> a , int start, int size) {
		    int l = 2*start +1;
		    int r = 2*start +2;
		    if(l > size || r > size) { return; }
		    if(root == null) { 
		         BinaryNode newtop = new BinaryNode(a.get(start)); root = newtop; 
		    }
		    if(root.left == null || root.right == null) {
		      if(l<size) { 
		         root.left = new BinaryNode(a.get(l));
		      }
		      if(r<size) {
		         root.right = new BinaryNode(a.get(r));
		      }
		    }
		    level_order_insert(root.left, a, l, size);
		    level_order_insert(root.right, a, r, size);
		   }
		  public static void print_preorder(BinaryNode root) {
		    System.out.println(root.data);
		    if(root.left != null) { print_preorder(root.left); }
		    if(root.right != null) { print_preorder(root.right); }
		  }
		  
		  public static void main(String[] args) {
		    Scanner scanner = new Scanner(System.in);
		    int cases = Integer.parseInt(scanner.nextLine());
		    for(int i = 0; i < cases; i++) {
		      run(scanner);
		    }
		  }
		}
