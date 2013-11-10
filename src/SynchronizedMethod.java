
public class SynchronizedMethod {
	int x;
	String s;
	/**
	 * @author yakdere
	 * 
	 */
	SynchronizedMethod(int x, String s) {
		this.x= x;
		this.s= s;
	}
	public synchronized int Method1() {
		return x;
	}
	public synchronized String Method2() {
		return s;
	}
	
	public static void main(String[] args) {
		int y = 3;
		String str = "Test";
		SynchronizedMethod sm = new SynchronizedMethod(y, str);
		System.out.println(sm.Method1());
		System.out.println(sm.Method2());
	}

}
