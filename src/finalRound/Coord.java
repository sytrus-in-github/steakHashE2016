package finalRound;

public class Coord {
	public static final int LATMIN = -324000, LATMAX = 324000,
							LONMIN = -648000, LONMAX = 647999;
	public int lat, lon;
	
	public Coord(int la, int lo){
		lat = la;
		lon = lo;
	}
	
	public Coord(Pair p) {
		lat = p.a;
		lon = p.b;
	}
	
	Coord add(int la, int lo){
		lat += la;
		lon += lo;
		lat %= 1296000;
		if (lat >= 648000) {
			lat -= 1296000;
		} else if (lat < -648000) {
			lat += 1296000;
		}
		if (lat > 324000) {
			lon -= 648000;
			lat = 648000 - lat;
		} else if (lat < -324000) {
			lon -= 648000;
			lat = -648000 - lat;
		}
		lon %= 1296000;
		if (lon >= 648000) {
			lon -= 1296000;
		} else if (lon < -648000) {
			lon += 1296000;
		}
		return this;
	}
	
	Coord add(Coord c){
		return add(c.lat, c.lon);
	}
}
