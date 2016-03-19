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
		Coord result = new Coord(lat, lon);
		result.lat += la;
		result.lon += lo;
		result.lat %= 1296000;
		if (result.lat >= 648000) {
			result.lat -= 1296000;
		} else if (result.lat < -648000) {
			result.lat += 1296000;
		}
		if (result.lat > 324000) {
			result.lon -= 648000;
			result.lat = 648000 - result.lat;
		} else if (result.lat < -324000) {
			result.lon -= 648000;
			result.lat = -648000 - result.lat;
		}
		result.lon %= 1296000;
		if (result.lon >= 648000) {
			result.lon -= 1296000;
		} else if (result.lon < -648000) {
			result.lon += 1296000;
		}
		return result;
	}
	
	Coord add(Coord c){
		return add(c.lat, c.lon);
	}
}
