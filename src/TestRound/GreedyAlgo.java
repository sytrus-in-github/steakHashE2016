package TestRound;

import java.util.ArrayList;

public class GreedyAlgo {
	ArrayList<Point> points;
	
	public GreedyAlgo() {
		this.points = new ArrayList<Point>();
	}
	
	public void addPoint(Point a){
		points.add(a);
	}
	
	public double nearestPoint(Point a){ //find the nearest point and remove it;
										//return the nearest value
		if(points.size()==0)
			return 0;
		Point p = points.get(0);
		double minD = Point.squareDistance(a, p);
		for(int i=1;i<points.size();i++){
			Point p1 = points.get(i);
			double d = Point.squareDistance(a, p1);
			if(d<minD){
				minD = d;
				p = p1;
			}		
		}
		points.remove(p);
		return minD;	
	}
}
