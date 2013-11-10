

public class BinarySearchTree {

	BinaryNode root = null;
	BinarySearchTree() {

	}

	public void Insert(int value) {
		if (root == null) {
			root = new BinaryNode(value);
		} else {
			Insert(root, value);
		}
	}

	private void Insert(BinaryNode node, int value) {
		if (value <= node.getData()) {
			if (node.getLchild() == null) {
				node.setLchild(new BinaryNode(value));
			} else {
				Insert(node.getLchild(), value);
			}
		} else {  // value > node.getData()
			if (node.getRchild() == null) {
				node.setRchild(new BinaryNode(value));
			} else {
				Insert(node.getRchild(), value);
			}
		}
	}

	public int size() {
		return size(root);
	}
	public BinaryNode getRoot() {
		return root;
	}

	private int size(BinaryNode node) {
		if (node == null) return 0;
		return 1 + size(node.getLchild()) + size(node.getRchild());
	}

	public int getLevel() {
	return getLevel(root);
	}
	private static int getLevel(BinaryNode node) {
		if (node == null) return -1;
			int u = getLevel(node.lchild);
			int v = getLevel(node.rchild);
		if (u > v ) { 
			return u+1;
		} else { 
			return v+1;
		}
	}
		
	public int minValue() throws EmptyException {
		if (root == null) throw new EmptyException();

		return minValue(root); //
	}

	private int minValue(BinaryNode node) throws EmptyException {
		int min_value = node.getData();
		if (node.getLchild() != null) {
			int left_min = minValue(node.getLchild());
			if (left_min < min_value)
				min_value = left_min;
		}
		if (node.getRchild() != null) {
			int right_min = minValue(node.getRchild());
			if (right_min < min_value)
				min_value = right_min;
		}
		return min_value;
	}
	//Min value should stay on left childs.We inserted lower number to left childs on insert method
	public int minValueThroughLeftNode() throws EmptyException {
		if(root == null) throw new EmptyException();

		BinaryNode node = root;
		int min_value = node.getData();
		while (node.getLchild() != null) {
			min_value = node.lchild.getData();
			node = node.getLchild();
		}
		return min_value;
	}

	//Max value find method checks both right and left children
	public int maxValue() throws EmptyException{
		if (root == null) throw new EmptyException();
		return maxValue(root); //
	}
	
	private int maxValue(BinaryNode node) {
		int max_value = node.getData();
		if (node.getLchild() != null) {
			int left_max = maxValue(node.getLchild());
			if (left_max > max_value)
				max_value = left_max;
		}
		if (node.getRchild() != null) {
			int right_max = maxValue(node.getRchild());
			if (right_max > max_value)
				max_value = right_max;
		}
		return max_value;
	}
	//
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

	// sysout...
	// 5
	//   3
	//     2
	//     4
	//   7
	//     6
	//     8
}
	
