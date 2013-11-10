//Question4.6 
//Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. 
//Avoid storing additional nodes in a data structure. 
//NOTE: This is not necessarily a binary search tree.
//Find Common Ancestor class


public class FCA {
	//inner class or nested class. We prefer Result class is a inner class of FCA to access to members of Result.
	//this feature is calling 'increased encapsulation'
	class Result {
		//constructors of class Result
		Result() { 
			this.is_ancestorof_p = false;
			this.is_ancestorof_q = false;
			this.common_ancestor = null;
		};
		
		public boolean is_ancestorof_p;
		public boolean is_ancestorof_q;
		public BinaryNode common_ancestor;

	}
	FCA() { }

	Result FindCommonAncestor(BinaryNode curr_node, BinaryNode p, BinaryNode q) {
		Result r = new Result(); //Result r turn to the class of Result. to call the node we have to use result.common_ancestor
		if (curr_node.IsLeaf()) { //instead of writing if next of current node is not empty I used the BinaryNode's method
			r.is_ancestorof_p = (curr_node == p);//if it is a leaf I have to also check if curr node equal to p or q
			r.is_ancestorof_q = (curr_node == q);
			return r; 
		}
		
		// First step I am searching is p or q at the left side
		Result rleft = new Result();
		if (curr_node.getLchild() != null) {
			rleft = FindCommonAncestor(curr_node.getLchild(), p, q);
		}
		
		if(rleft.common_ancestor != null) return rleft;
		
		Result rright = new Result();
		if(curr_node.getRchild() != null) {
			rright = FindCommonAncestor(curr_node.getRchild(), p, q);
		}
		
		if(rright.common_ancestor != null) return rright;
		
		if (rleft.is_ancestorof_q || rright.is_ancestorof_q) {
			r.is_ancestorof_q = true;
		}
		if (rleft.is_ancestorof_p || rright.is_ancestorof_p) {
			r.is_ancestorof_p = true;
		}
		if(r.is_ancestorof_p && r.is_ancestorof_q) {
			r.common_ancestor = curr_node;
		}
		return r;
	}
	
	public static void main (String[] args) {
		BinaryTree myBinTree = new BinaryTree();
		//BinaryNode A = new BinaryNode(10);
		//BinaryNode B = new BinaryNode(21);
		int[] nodes = new int[] { 35, 10, 21, 32, 46};
		for(int i = 0; i < nodes.length; i++) {
			myBinTree.InsertLevelbyLevel(nodes[i]);
		}
		myBinTree.printTree();
		//System.out.println("Parent of these two nodes:"+FCA.FindCommonAncestor(myBinTree, p, q));
		System.out.println("Your tree's level is:"+myBinTree.getLevel());
		System.out.println("Total number of nodes on your tree:"+myBinTree.SumofNodes());
	}
	
	
}
