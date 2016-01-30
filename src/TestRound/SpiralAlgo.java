package TestRound;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import tools.Reader;

public class SpiralAlgo {
	int time;
	ArrayList<Point> points;
	Point currentPoint;
	
	public SpiralAlgo(int time) {
		this.time = time;
		this.points = new ArrayList<Point>();
		currentPoint = new Point(-1,0,0);
	}
	
	public void addPoint(Point a){
		points.add(a);
	}
	
	public Point searchInDirection(int direction){
		if(points.size()==0)
			return null;
		double minD = Double.MAX_VALUE;
		Point next = null;
		switch(direction){
		case 0:
			for(int i=0;i<points.size();i++){
				Point p = points.get(i);
				if(p.x<=currentPoint.x&&p.y<=currentPoint.y){
					double d = Point.distance(currentPoint, p);
					if(d<minD){
						next = p;
						minD = d;
					}
				}
			}
			return next;
		case 1:
			for(int i=0;i<points.size();i++){
				Point p = points.get(i);
				if(p.x>=currentPoint.x&&p.y<=currentPoint.y){
					double d = Point.distance(currentPoint, p);
					if(d<minD){
						next = p;
						minD = d;
					}
				}
			}
			return next;
		case 2:
			for(int i=0;i<points.size();i++){
				Point p = points.get(i);
				if(p.x>=currentPoint.x&&p.y>=currentPoint.y){
					double d = Point.distance(currentPoint, p);
					if(d<minD){
						next = p;
						minD = d;
					}
				}
			}
			return next;
		case 3:
			for(int i=0;i<points.size();i++){
				Point p = points.get(i);
				if(p.x<=currentPoint.x&&p.y>=currentPoint.y){
					double d = Point.distance(currentPoint, p);
					if(d<minD){
						next = p;
						minD = d;
					}
				}
			}
			return next;
		}
		return null;
	}
	
	public ArrayList<Integer> run(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		int time = this.time;
		int direction = 0;
		while(points.size()>0){
			Point p = searchInDirection(direction);
			time-=Point.distance(p, currentPoint);
			if(time<0)
				break;
			result.add(p.id);
			currentPoint = p;
			points.remove(p);
			direction = (direction+1)%4;
		}
		return result;
	}
	
	public static void main(String[] args) {
		input();
	}
	
	public static void input() {
		try {
			Reader r = new Reader("input_2.txt");
			SpiralAlgo sa = new SpiralAlgo(r.readInt());
			try{
				while (true) {
					int id = r.readInt();
					int x = r.readInt();
					int y = r.readInt();
					sa.addPoint(new Point(id, x, y));
				}
			} catch (Exception ex) {System.out.println("Finished Reading");}
			ArrayList<Integer> result = sa.run();
			System.out.println("Result:"+result.size());
			r.close();
			FileWriter fw = new FileWriter("answer2.txt");
			PrintWriter pw = new PrintWriter(fw);
		
			for (int i = 0; i < result.size(); i++) {
				pw.println(result.get(i));
			}
			pw.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
