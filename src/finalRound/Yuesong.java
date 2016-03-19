package finalRound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Yuesong {
	
	public static LinkedList<Pair> possibleIntervalsSlow(Coord c, Satellite s){
		return null;
	}
	
	public static LinkedList<Pair> getLatitude(Coord c, Satellite sat){
		return null;
	}
	
	public static LinkedList<Pair> getLongitude(Coord c, Satellite sat){
		int range = Coord.LONMAX-Coord.LONMIN+1;
		Coord s = sat.initCoord;
		int d = sat.d;
		int v = -15;
		int cpos = c.lon,spos = s.lon;
		LinkedList<Pair> ret = new LinkedList<>();
		int T = 180*3600/15;
		
		
		return ret;
	}
	// assume intervals in l1, l2 already sorted
	public static LinkedList<Pair> mergeIntervals(LinkedList<Pair> l1, LinkedList<Pair> l2){
		Iterator<Pair> i1 = l1.iterator(), i2 = l2.iterator();
		LinkedList<Pair> ret = new LinkedList<Pair>();
		try{
			Pair p1 = i1.next(), p2 = i2.next();
			while(true){
				if(p1.a <= p2.a){
					if (p1.b > p2.a)
						if( p1.b < p2.b){
							ret.add(new Pair(p2.a, p1.b));
							p1 = i1.next();
						}
						else{
							ret.add(new Pair(p2.a, p2.b));
							p2 = i2.next();
						}
					else
						p1 = i1.next();
				}
				else{
					if (p2.b > p1.a)
						if( p2.b < p1.b){
							ret.add(new Pair(p1.a, p2.b));
							p2 = i2.next();
						}
						else{
							ret.add(new Pair(p1.a, p1.b));
							p1 = i1.next();
						}
					else
						p2 = i2.next();
				}
			}
		}
		catch(NoSuchElementException e){}
		return ret;
	}
	
}
