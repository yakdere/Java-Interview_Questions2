import java.util.ArrayList;


public class LevelOrderedBTPreOrderPrint {
	LevelOrderedBTPreOrderPrint() { }
	
	public void run(ArrayList<Character> allnodes) {
		BinaryNode root = new BinaryNode(allnodes.get(0));
		level_ordered_insert(allnodes, root, 0, allnodes.size());
		preorder_print(root);
	}
	public class BinaryNode {
		char data;
		BinaryNode right;
		BinaryNode left;
	BinaryNode(char data) { 
			this.data = data;
			right = null;
			left = null;
	}
	}
	public class BinaryTree {
		BinaryNode root = null;
	BinaryTree() { }
	}
	
	
	private void level_ordered_insert(ArrayList<Character> allnodes, BinaryNode root, int start, int end) {
		int l = 2*start + 1;
		int r = 2*start + 2;
		if ( l > end || r > end ) { return; }
		if(root == null) { 
			BinaryNode newtop = new BinaryNode(allnodes.get(start)); 
			root = newtop; 
		}
		if ( root.left == null && root.right == null) {
			if ( l < end ) {
				root.left = new BinaryNode(allnodes.get(l));
			}
			if ( r < end ) {
				root.right = new BinaryNode(allnodes.get(r));
			}
		}
		level_ordered_insert(allnodes,root.left,l,end);
		level_ordered_insert(allnodes,root.right,r,end);
	}
	
	private void preorder_print(BinaryNode root) {
		  System.out.println(root.data);
		  if(root.left != null) { preorder_print(root.left); }
		  if(root.right != null) { preorder_print(root.right); }	
	}


	public static void main(String[] args) {
		ArrayList<Character> mynodes = new ArrayList<Character>();
		mynodes.add('A');
		mynodes.add('C');
		mynodes.add('F');
		mynodes.add('B');
		mynodes.add('D');
		mynodes.add('E');
        LevelOrderedBTPreOrderPrint test_one = new LevelOrderedBTPreOrderPrint();
        test_one.run(mynodes);
	}

}
