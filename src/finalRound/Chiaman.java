package finalRound;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Chiaman {

	static PriorityQueue<Album> sortedAlbum() {
		PriorityQueue<Album> sortedAlbums = new PriorityQueue<Album>();
		for (int i = 0; i < Q.C; i++) {
			sortedAlbums.add(Q.albums[i]);
		}
		return sortedAlbums;
	}
	
	public static LinkedList<Pair> getLongitude(Coord c, Satellite sat){
		LinkedList<Pair> ret = new LinkedList<Pair>();
		int v = -15;
		int start = -1;
		int end = -1;
		int period = 180 * 3600 / v;
		
		int startD = (c.lon - sat.initCoord.lon - sat.d) % (180 * 3600);
		if (startD < 0) startD += 180 * 3600;
		int endD = (c.lon - sat.initCoord.lon + sat.d) % (180 * 3600);
		if (endD < 0) endD += 180 * 3600;
		
		start = (int) Math.floor(startD / (double) v);
		end = (int) Math.ceil(endD / (double) v);
		
		if (c.lon - sat.initCoord.lon < 2 * sat.d) {
			start = 0;
			end = (int) Math.ceil((c.lon - sat.initCoord.lon + sat.d) / (double) v);
			ret.add(new Pair(start, end));
		} else {
			start = (int) Math.floor((c.lon - sat.initCoord.lon - sat.d) / (double) v);
			end = (int) Math.ceil((c.lon - sat.initCoord.lon + sat.d) / (double) v);
			ret.add(new Pair(start, end));
		}
		start = (int) Math.floor((c.lon - sat.initCoord.lon - sat.d) / (double) v);
		
		while (end + period < Q.T) {
			start += period;
			end += period;
			ret.add(new Pair(start, end));
		}
		
		if (start + period < Q.T) {
			start += period;
			ret.add(new Pair(start, Q.T - 1));
		}
		return ret;
	}
}
