package TestRound;

import java.util.ArrayList;

public class LinkedAlgo {
	int time;
	ArrayList<Point> link;
	
	public LinkedAlgo(int time) {
		this.time = time; 
		this.link = new ArrayList<Point>();
		link.add(new Point(-1,0,0));
	}
	
	public void addPoint(Point a){
		if(link.size()==1){
			link.add(a);
			return;
		}
		for(int i=0;i<link.size()-1;i++){
			Point p1 = link.get(i);
		}
	}
	
	public static void main(String[] args) {
		
	}
}
