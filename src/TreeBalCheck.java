import java.util.Random;
import java.util.Vector;


//Implement a function to check if a tree is balanced. For the purposes of this question, a balanced tree is defined 
//...to be a tree such that no two leaf nodes differ in distance from the root by more than one.
public class TreeBalCheck {
	
	Integer minh = null;
	Integer maxh = null;
	
	public TreeBalCheck() { minh = new Integer(-1); maxh = new Integer(-1); }
	
	public boolean IsBalanced(Node root) {
		minh = -1;
		maxh = -1;
		return IsBalanced(root, 0);
	}

	private boolean IsBalanced(Node node, int h) {
		if(node.IsLeaf()) {
			int myheight = h;
			maxh = Math.max(maxh, myheight);
			minh = (minh == -1) ? myheight : Math.min(minh, myheight);
			return maxh - minh <= 1;
		}
		
		boolean res = true;
		for (int i = 0; i < node.NumChildren(); ++i) {
			res = res && IsBalanced(node.Child(i), h + 1);
		}
		
		return res;
	}

	public static void main(String[] args) {
		final int id_range = 100 + 1; //id range represent here data of nodes, random number will be around 100
		Random r = new Random(); //random class setted
		final int num_nodes = r.nextInt(10);  //number of nodes will be random also
		Node root = new Node(r.nextInt(id_range)); // node of root described here, we dont know what is the root number, depends
		Vector<Node> all_nodes = new Vector<Node>(); //..on what random method will creates. At this line we create a vector 
		all_nodes.add(root); //..to put all nodes inside of this vector and firstly we should add the root
		
		//till here we setted root and a vector to keep other child nodes
		for (int i = 0; i < num_nodes; ++i) { 
			Node new_node = new Node(r.nextInt(id_range)); // i times we will create new nodes as childrens with randomly integers
			Node parent_node = all_nodes.get(r.nextInt(all_nodes.size())); // all nodes size will increase every circle and i th element of all nodes 
			                                                      //..will be the parent node.
			parent_node.Insert(new_node); //now time to create tree..we have to add childrens to parent nodes
			all_nodes.add(new_node); // i pieces new nodes are adding in allnodes vector
		}
		
		root.PrintTree(0);
		TreeBalCheck checker = new TreeBalCheck();
		System.out.println("Is Balanced: " + checker.IsBalanced(root));
		
	}
	
}
