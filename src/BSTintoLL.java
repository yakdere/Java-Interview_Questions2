import java.util.Vector;

/// TODO work on it again...fail on the test!!
public class BSTintoLL {

	BSTintoLL() {
		
	}
	
	public BinaryNode CreateFromBST(BinaryNode curr) {
		BinaryNode bst_root = curr;	
		// Convert left side of the tree to linked list
		Vector<BinaryNode> left_list = inorder(curr.getLchild());
		
		
		// Convert right side of the tree to linked list
		Vector<BinaryNode> right_list = inorder(curr.getRchild());
				
		// add root beside left and right side of linked list
		left_list.elementAt(1).rchild = bst_root;
		bst_root.lchild= right_list.elementAt(0);
		
		return left_list.elementAt(0);
	}
	
	
	private Vector<BinaryNode> inorder(BinaryNode curr) {
		if( curr == null ) return null;
		Vector<BinaryNode> left_leaves = inorder(curr.lchild);
		Vector<BinaryNode> right_leaves = inorder(curr.rchild);
		Vector<BinaryNode> leftAndrightLeaves = new Vector<BinaryNode>();
		leftAndrightLeaves.add(left_leaves.lastElement());
		leftAndrightLeaves.add(right_leaves.lastElement());
		
		return leftAndrightLeaves;
	}

	public static void main(String[] args) {
		BinarySearchTree myTree = new BinarySearchTree();
		myTree.Insert(10);
		myTree.Insert(4);
		myTree.Insert(5);
		myTree.Insert(6);
		myTree.Insert(11);
		myTree.Insert(12);
		myTree.Insert(13);

		myTree.printTree();
		
		BSTintoLL my_list = new BSTintoLL();
		my_list.CreateFromBST(myTree.getRoot());
		
		myTree.printTree();
		
	}

}
