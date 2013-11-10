import java.util.LinkedList;
import java.util.Queue;

/*
 * @author yakdere
 * get the nth element of the Binary Tree in a level-based order
 */

public class GetNthElement {
	
	public int FindNthelement(BinaryNode node, int n) {
		if (node == null) return -1;
		if (n == 0) return node.getData(); // for first element return root
		// otherwise visit level by level every node
		Queue<BinaryNode> Q = new LinkedList<BinaryNode>();
		BinaryNode curr_node = null;
		Q.add(node);
		int count = 0;
		while (!Q.isEmpty()) {
			curr_node = Q.remove();
			count++;
			if (count == n) { 
				return curr_node.getData();
			}
			if (node.getLchild() != null) {
				Q.add(node.getLchild());
			}
			if (node.getRchild() != null) {
				Q.add(node.getRchild());
			}	
		}
		//error case
		return -1;
	}
	
	public static void main(String[] args) {
		BinaryTree myBinTree = new BinaryTree();
		int[] nodes_data = new int[] {3,5,7,9,12,8,5,1,2};
		for (int i = 0; i < nodes_data.length; i++) {
			myBinTree.InsertLevelbyLevel(i);
		}
		myBinTree.printTree();
		GetNthElement mysearch = new GetNthElement();
		int Result = mysearch.FindNthelement( myBinTree.root , 7);
		System.out.println( "7th element of your tree is :" +Result);
	}

}
