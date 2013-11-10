/*
 * yakdere
 * Iterative vs Recursion counting to given number
 * Note that recursion counts up to down
 */
public class IteToRec {
 int x;
	public IteToRec(int x) {
		this.x = x;
		iterativeMethod(x);
		recursionMethod(x);
	}
	
	private void iterativeMethod(int x) {
		for (int i = 0; i <=x; i++ ) {
			System.out.println("The iterative number is: "+i);
		}
	}
	
	private void recursionMethod(int x) {
		// we need a local variable to write the number
		if (x == 0) { 
			return; 
			}
			System.out.println("The recursion number is: "+x);
			recursionMethod (x-1);
		}	
	
public static void main(String[] args) {	
	IteToRec test = new IteToRec(10);
 }
}