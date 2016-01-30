package TestRound;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import tools.Reader;

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
			Point p2 = link.get(i+1);
			double formerD = Point.distance(p1, p2);
			double newD = Point.distance(p1, a);
			if(newD<formerD){
				link.add(i+1, a);
				return;
			}
		}
		link.add(a);
	}
	
	public ArrayList<Integer> run(){
		ArrayList<Integer> result = new ArrayList<Integer>();
		int time = this.time;
		for(int i=0;i<link.size()-1;i++){
			Point p1 = link.get(i);
			Point p2 = link.get(i+1);
			time-=Point.distance(p1, p2);
			if(time<0)
				break;
			result.add(p2.id);
		}
		return result;
	}
	
	public static void main(String[] args) {
		input();
	}
	
	public static void input() {
		try {
			Reader r = new Reader("input_2.txt");
			LinkedAlgo la = new LinkedAlgo(r.readInt());
			try{
				while (true) {
					int id = r.readInt();
					int x = r.readInt();
					int y = r.readInt();
					la.addPoint(new Point(id, x, y));
				}
			} catch (Exception ex) {System.out.println("Finished Reading");}
			ArrayList<Integer> result = la.run();
			System.out.println("Result:"+result.size());
			r.close();
			FileWriter fw = new FileWriter("answer3.txt");
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
