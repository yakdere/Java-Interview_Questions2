


/**
 * @author yakdere
 * This is not Binary Search Tree
 * just Binary Tree
 */

public class BinaryTree {
	BinaryNode root = null;
	BinaryTree() { 
	}
	

	public void  InsertLevelbyLevel(int data) {
		if (root == null) {
			root = new BinaryNode(data);
			return;
		}
		
		BinaryNode left_most_node = root;
		int level = 0;
		while (left_most_node.lchild != null){
			left_most_node = left_most_node.lchild;
			level++;
		}
		System.out.println("Left most node " + left_most_node.getData() + " at level " + level);
		BinaryNode new_node = new BinaryNode(data);
		if (!InsertLevelByLevel(root, 0, new_node, left_most_node, level)) {
			left_most_node.setLchild(new_node);
		}
	}
	
	private boolean InsertLevelByLevel(BinaryNode curr_node, int curr_level, 
									   BinaryNode new_node, 
									   BinaryNode left_most_node, int left_most_level) {
		if (curr_node == null) return false;
		
		if (curr_node.lchild == null || curr_node.rchild == null) {
			if (curr_node != left_most_node && curr_level < left_most_level) {
				if (curr_node.lchild == null)
					curr_node.setLchild(new_node);
				else 
					curr_node.setRchild(new_node);
				return true;
			}
		}
		return InsertLevelByLevel(curr_node.lchild, curr_level+1, new_node, left_most_node, left_most_level) ||
				InsertLevelByLevel(curr_node.rchild, curr_level+1, new_node, left_most_node, left_most_level);
	}
		
	
	public int getLevel() {
		return getLevel(root);
	}
	
	private int getLevel (BinaryNode node) {
		if (node == null) return -1;
			int rightlevel = getLevel (node.getRchild());
			int leftlevel = getLevel (node.getLchild());
		if ( rightlevel > leftlevel) {
			return rightlevel + 1;
		} else {
			return leftlevel + 1;
		}
	}
	public int SumofNodes() {
		return SumofNodes(root);
	}
	private int SumofNodes(BinaryNode node){
		//Base case
		if (node == null) { 
			return 0; 
		}
		if (node.getLchild() == null && node.getRchild() == null) { return 1; 
		} else {
			return SumofNodes(node.getRchild()) + SumofNodes(node.getLchild()) + 1;
		}
	}
	
	public void printTree() {
		printTree(root, 5);
	}

	private void printTree(BinaryNode node, int nspaces) {
		if(node != null) {
			int curr_value = node.getData();
			System.out.println(String.format("%1$" + nspaces + "s", "" + curr_value));

			printTree(node.getLchild(), nspaces + 2);
			printTree(node.getRchild(), nspaces + 2);
		}
	}
}
