package TestRound;

public class Point {
	int id,x,y;
	public Point(int id, int x, int y){
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public static double squareDistance(Point a, Point b){
		return Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2));
	}
	public static double distance(Point a, Point b){
		return Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2);
	}
}
