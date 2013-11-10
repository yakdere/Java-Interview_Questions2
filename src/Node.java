import java.util.Vector;

public class Node {
	Vector<Node> children = null;
	int value;
	
	public Node(int value) {
		children = new Vector<Node>();
		this.value = value;
	}
		
	public boolean IsLeaf() {
		return children.size() == 0; 
	}

	public void Insert(Node child) {
		children.add(child);
	}
	
	public Node Child(int index) {
		return children.get(index);
	}
	
	public int NumChildren() {
		return children.size();
	}
	
	public void PrintTree(int padding) {
		String out_str = "";
		for (int i = 0; i < padding; i++) out_str += " ";  // out_str = out_str + " "
		System.out.println(out_str + value);
		for (int i = 0; i < NumChildren(); ++i) {
			Child(i).PrintTree(padding + 2);
		}
	}
	
}
