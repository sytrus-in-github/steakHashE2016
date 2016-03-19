package finalRound;

public class Coord {
	public static final int LATMIN = -324000, LATMAX = 324000,
							LONMIN = -648000, LONMAX = 647999;
	public int lat,lon;
	
	public Coord(int la,int lo){
		lat = la;
		lon = lo;
	}
	
	Coord add(int la, int lo){
		la %= 648000;
		lat += la;
		
	}
	
	Coord add(Coord c){
		return add(c.lat, c.lon);
	}
}
