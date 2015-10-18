import java.util.ArrayList;
import java.util.Random;

class InputGenerator {
	ArrayList<AX> generatePoints(int n) {
		ArrayList<AX> list = new ArrayList<>();
		int[] points = new int[n];
		Random rand = new Random();
		boolean start = true;
		for (int i = 0; i < n; ) {
			int x = rand.nextInt(n * n);
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (points[j] == x) {
					flag = true;
					break;
				}
			}
			//System.out.println(i + " " + x + " " + flag + " " + start);
			if (flag) continue;
			if (start) list.add(new AX(x, i/2, start));
			else {
				if (list.get(i-1).getCoord() >= x) continue;
				list.add(new AX(x, i/2, start));
			}
			points[i++] = x;
			start = !start;
		}
		return list;
	}
}