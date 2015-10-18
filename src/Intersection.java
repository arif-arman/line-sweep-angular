import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Intersection {
	
	ArrayList<Point> points;
	int n;
	
	public Intersection() throws FileNotFoundException {
		File file = new File("input.txt");
		Scanner input = new Scanner(file);
		n = input.nextInt();
		points = new ArrayList<>();
		for (int i=0;i<n;i++) {
			points.add(new Point(input.nextInt(), input.nextInt(), input.nextInt(), input.nextBoolean(), input.nextBoolean()));
		}
		input.close();
		Collections.sort(points, new CustomComparator());
		testPrint();
		findIntersections();
	}
	
	void findIntersections() {
		ArrayList<Integer> active = new ArrayList<>();
		int num = 0;
		for (int i=0;i<n;i++) {
			Point p = points.get(i);
			if (p.horizontal) {
				if (p.start) active.add(p.y);
				else active.remove((Object)p.y);
				
			}
			else {
				if (!p.start) {
					int y1 = points.get(i-1).y;
					int y2 = p.y;
					for (int j=0;j<active.size();j++) {
						if (y2 >= active.get(j) && y1 <= active.get(j)) num++;
					}
				}
			}
			System.out.println(active + " " + num);
			
		}
		System.out.println(num);
	}
	
	
	
	void testPrint() {
		for (int i=0;i<n;i++) {
			System.out.println(points.get(i).line + " " + points.get(i).x + " " + points.get(i).y + " " + points.get(i).start + " " + points.get(i).horizontal);
		}
	}
	
	class Point {
		int x, y;
		int line;
		boolean start;
		boolean horizontal;
		public Point(int line, int x, int y, boolean start, boolean horizontal) {
			// TODO Auto-generated constructor stub
			this.line = line;
			this.x = x;
			this.y = y;
			this.start = start;
			this.horizontal = horizontal;
		}
	}
	
	class CustomComparator implements Comparator<Point> {
	    @Override
	    //
	    public int compare(Point o1, Point o2) {
	        return Integer.compare(o1.x, o2.x);
	    }
	    /*
	    public int compare(Point o1, Point o2) {
	        if (Integer.compare(o1.x,  o2.x) == 0) {
	        	if (o1.horizontal && !o2.horizontal) {
	        		if (o1.start) return 1;
	        		else return -1;
	        	}
	        	else if (o2.horizontal && !o1.horizontal) {
	        		if (o2.start) return 1;
	        		else return -1;
	        	}
	        	else return 1;
	        }
	    	else return Integer.compare(o1.x, o2.x);
	    }
	    */
	}
	
	
	

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Intersection intersection = new Intersection();
		
		
	}

}
