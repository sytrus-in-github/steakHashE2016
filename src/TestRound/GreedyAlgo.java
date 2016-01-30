package TestRound;

import java.util.ArrayList;

public class GreedyAlgo {
	int time;
	ArrayList<Point> points;
	
	public GreedyAlgo(int time) {
		this.time = time;
		this.points = new ArrayList<Point>();
	}
	
	public void addPoint(Point a){
		points.add(a);
	}
	
	public Point nearestPoint(Point a){ //find the nearest point
										//return the nearest point
		if(points.size()==0)
			return null;
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
		return p;	
	}
	
	public ArrayList<Integer> run(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		int time = this.time;
		while(points.size()>0){
			Point a = points.get(0);
			points.remove(a);
			Point p = nearestPoint(a);
			double minD = Point.distance(a, p);
			time-=minD;
			if(time<0)
				break;
			else
				result.add(p.id);
		}
		return result;
	}
}
