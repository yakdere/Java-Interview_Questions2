import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;
//How to use Comparator example
//@author yakdere

public class PointSortingTest {

	class PointComparator implements Comparator<Point> {

		@Override
		public int compare(Point o1, Point o2) {
			if (o1.getX() < o2.getX()) {
				return -1;
			} else if (o1.getX() > o2.getX()) { 
				return 1; 
			} else if (o1.getY() < o2.getY()) {
					return -1; 
			} else if (o1.getY() > o2.getY()) {
					return 1;
			}
			return 0;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<Point> points = new Vector<Point>();
		
		points.add(new Point(5, 10));
		points.add(new Point(3, 12));
		points.add(new Point(3, 15));
		points.add(new Point(7, 12));
		
		PointSortingTest tester = new PointSortingTest();
		PointComparator comparator = tester.new PointComparator();
		Collections.sort(points, comparator);
	
		for (Point p : points) {
			System.out.println(p.getX() + ", " + p.getY());
		}
	}

}
