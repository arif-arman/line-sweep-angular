import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class LineSweep {
	
	ArrayList<AX> points;
	
	public LineSweep(ArrayList<AX> points) {
		// TODO Auto-generated constructor stub
		this.points = points;
		testPrint(points);
		Collections.sort(this.points, new CustomComparator());
		
	}
		
	public void mOverlapping(int m) {
		int count = 0;
		//testPrint(points);
		int n = points.size();
		int init = -1, fin = -1, angle = 0;
		for (int i=0;i<n;i++) {
			
			if (points.get(i).getStart()) {
				count++;
				if (count == m) init = points.get(i).getCoord();
				else {
					if (init != -1) {
						fin = points.get(i).getCoord();
						angle += (fin - init);
						fin = -1;
						init = -1;
					}
					
				}
			}
			else {
				count--;
				if (count == m) init = points.get(i).getCoord();
				else {
					if (init != -1) {
						fin = points.get(i).getCoord();
						angle += (fin - init);
						fin = -1;
						init = -1;
					}
				}
				
			}	
			//System.out.println(count);
		}
		System.out.println(angle);
	}
	
	class CustomComparator implements Comparator<AX> {
	    @Override
	    public int compare(AX o1, AX o2) {
	    	if (o1.getCoord() == o2.getCoord()) {
	    		if (o1.getStart() && !o2.getStart()) return -1;
	    		else if (o2.getStart() && !o1.getStart()) return 1;
	    		return 0;
	    	}
	        return Integer.compare(o1.getCoord(), o2.getCoord());
	    }
	}
	
	private void testPrint(ArrayList<AX> points) {
		
		for (int i=0;i<points.size();i++) System.out.println(points.get(i));
		System.out.println();
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		int m;
		int test;
		File file = new File("input.txt");
		Scanner input = new Scanner(file);
		m = input.nextInt();
		int n = 2*m;
		ArrayList<AX> points = new ArrayList<>();
		for (int i=0;i<n;i++) {
			if (i%2 == 0) {
				AX p = new AX(input.nextInt(),i/2, true);
				points.add(p);
			}
			else {
				int coord = input.nextInt();
				if (coord < points.get(i-1).getCoord()) {
					points.add(new AX(360,i/2, false));
					points.add(new AX(0,i/2, true));
				}

				points.add(new AX(coord, i/2, false));
				
				
			}
		}
		
		LineSweep sweep = new LineSweep(points);
		sweep.testPrint(points);
		for (int i=1;i<=m;i++) {
			sweep.mOverlapping(i);
		}
		input.close();
		System.out.println();
		//sweep.mOverlapping(2);
		
	}
	
	
	
	

}
