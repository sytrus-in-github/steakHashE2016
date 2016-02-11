package firstRound;

public class Chiaman {
	public static double dist2(double x1, double y1, double x2, double y2) {
		return (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
	}
	
	public static double dist(double x1, double y1, double x2, double y2) {
		return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
	}
	
	public static int turn(double x1, double y1, double x2, double y2) {
		return (int) Math.ceil(Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));
	}

	public static int nearestWarehouseEnough(int x, int y, int pType, int nItems) {
		int id = -1;
		double maxDist2 = Double.MAX_VALUE;
		for (int i = 0; i < Q.W; i++) {
			if (Q.warehouses[i].products[pType] >= nItems) {
				double tempDist2 = dist2(x, y, Q.warehouses[i].x, Q.warehouses[i].y);
				if (tempDist2 < maxDist2) {
					id = i;
					maxDist2 = tempDist2;
				}
			}
		}
		return id;
	}
}
