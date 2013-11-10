

public class BinaryNode {
	int data;
	BinaryNode lchild = null;
	BinaryNode rchild = null;
	//Constructors
	public BinaryNode(int data) {
		this.data = data;
		lchild = null;
		rchild= null;
	}
	
	public boolean IsLeaf() { return lchild == null && rchild == null; }
	
	public BinaryNode getLchild() {
		return lchild;
	}
	public void setLchild(BinaryNode lchild) {
		this.lchild = lchild;
	}
	public BinaryNode getRchild() {
		return rchild;
	}
	public void setRchild(BinaryNode rchild) {
		this.rchild = rchild;
	}
	public int getData() {
		return data;
	}
	
	
}

