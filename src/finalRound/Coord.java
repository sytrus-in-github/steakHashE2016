package finalRound;

public class Coord {
	public static final int LATMIN = -324000, LATMAX = 324000,
							LONMIN = -648000, LONMAX = 647999;
	public int lat, lon;
	
	public Coord(int la, int lo){
		lat = la;
		lon = lo;
		refit();
	}
	
	public Coord(Pair p) {
		lat = p.a;
		lon = p.b;
		refit();
	}
	
	Coord add(int la, int lo){
		Coord result = new Coord(lat, lon);
		result.lat += la;
		result.lon += lo;
		result.refit();
		return result;
	}
	
	public void refit(){
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
	}
	
	Coord add(Coord c){
		return add(c.lat, c.lon);
	}
}
