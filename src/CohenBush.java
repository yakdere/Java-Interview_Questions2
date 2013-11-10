
import java.util.Vector;

public class CohenBush {

	static Vector<Double> ComputeBushHeights(Vector<Integer> heights) {
		Vector<Double> new_heights = new Vector<Double>();
		for (int i = 0; i < heights.size(); ++i) {
			new_heights.add(heights.get(i) + .0);
		}
		
		for (int i = 1; i < heights.size() - 1; ++i) {
			final double h = (new_heights.get(i-1) + new_heights.get(i+1)) / 2;
			new_heights.set(i, Math.min(h, new_heights.get(i)));
		}
				
		return new_heights;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Integer> bush_heights = new Vector<Integer>();
//		bush_heights.add(103);
//		bush_heights.add(147);
//		bush_heights.add(134);
//		bush_heights.add(101);
//		bush_heights.add(91);
//		bush_heights.add(127);
//		bush_heights.add(113);
//		bush_heights.add(37);
//		bush_heights.add(41);
//		
//		Vector<Double> new_heights = ComputeBushHeights(bush_heights); 
//		for(int i = 0; i < new_heights.size(); ++i) {
//			System.out.println("bush[" + (i + 1) + "] = " + new_heights.get(i));
//		}
//		
//		System.out.println("\n\n\n");
//		
//		bush_heights.clear();
//		bush_heights.add(1000);
//		for(int i = 1; i < 100; i++) {
//			bush_heights.add((int)(bush_heights.get(i - 1) - Math.random() * 20));
//			System.out.println("bush[" + (i + 1) + "] = " + bush_heights.get(i));
//		}
//		
//		new_heights = ComputeBushHeights(bush_heights); 
//		for(int i = 0; i < new_heights.size(); ++i) {
//			System.out.println("bush[" + (i + 1) + "] = " + new_heights.get(i));
//		}
//			
		int [] in = new int[] {766, 537, 321, 480, 419,738,736,848,636,789,829,282,275,732,350,318,886,646,737,272,775,516,399,84,767,567,589,992,361,141,42,126,677,714,605,447,452,693,295,87,833,475,369};
		bush_heights.clear();
		for (int x : in) bush_heights.add(x);
		
		Vector<Double> new_heights = ComputeBushHeights(bush_heights); 
		for(int i = 0; i < new_heights.size(); ++i) {
			System.out.println("bush[" + (i + 1) + "] = " + new_heights.get(i));
		}
	}
}
