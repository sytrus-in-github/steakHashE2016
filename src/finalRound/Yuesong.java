package finalRound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Yuesong {
	
	public static LinkedList<Pair> possibleIntervals(Coord c, Satellite s){
		LinkedList<Pair> l1 = generateIntervals(s.v, s.initCoord.lat, c.lat-s.d, s.d*2+1, Coord.LATMAX-Coord.LATMIN - s.d*2),
						l2 = getLongitude(c, s.initCoord, s.d, Coord.LONMAX-Coord.LONMIN+1);
	}
	
	public static LinkedList<Pair> getLatitude(Coord c, Satellite sat){
		
	}
	
	public static LinkedList<Pair> getLongitude(Coord c, Satellite sat){
		int range = Coord.LONMAX-Coord.LONMIN+1;
		Coord s = sat.initCoord;
		int d = sat.d;
		int v = -15;
		LinkedList<Pair> ret = new LinkedList<>();
		int t = 0;
		int start, end;
		int cpos = c.lon;
		while(t<Q.T){
			int spos = s.add(0, v*t).lon;
			if(Math.abs(cpos-spos)<=d){//in range
				start = t;
				end = start + (d+spos-cpos)/v;
				t = end +1;
			}
			else{//not in range, go in range
				if(spos>cpos){
					t += (cpos-spos-d-1)/v+1;
				}
				else{
					t += (cpos+range-spos-d-1)/v+1;
				}
			}
		}
		
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
