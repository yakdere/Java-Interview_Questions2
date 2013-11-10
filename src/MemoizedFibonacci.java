import java.util.Vector;


public class MemoizedFibonacci {

	// recursive with memorization
	static int fibonacci(int x, Vector<Integer> mem) {
		if (mem.isEmpty()) {
			for (int i = 0; i < x; i++)
				mem.add(null);
		}
		
		if (x > 1) {
			if (mem.get(x-1) == null)
				mem.set(x-1, fibonacci(x-1, mem));
			if (mem.get(x-2) == null)
				mem.set(x-2, fibonacci(x-2, mem));
			return mem.get(x-1) + mem.get(x-2);
		} else 
			mem.set(x, 1);
			return 1;
	}
	
	static int fibonacci(int x) {
		if (x <= 1)
			return 1;
		
		int fibo1 = 1;
		int fibo2 = 1;
		for (int i = 2; i < x; i++) {
			int tmp = fibo1;
			fibo1 = fibo1 + fibo2;
			fibo2 = tmp;
		}
		return fibo1 + fibo2;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// compute fibonacci(5)
		Vector<Integer> mem = new Vector<Integer>();
		System.out.println("fibonacci(5) = " + fibonacci(5, mem));
		System.out.println("mem: " + mem.toString());
		
		System.out.println("fibonacci(5) = " + fibonacci(5));
	}

}
