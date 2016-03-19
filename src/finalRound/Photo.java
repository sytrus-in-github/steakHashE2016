package finalRound;

public class Photo{
	
	public Album album;
	public Coord coord;
	
	public Photo(Coord c, Album a){
		this.coord = c;
		this.album = a;
	}
	
	public Photo(int lat, int lon, Album a){
		this.coord = new Coord(lat, lon);
		this.album = a;
	}
	
	public Photo(Pair p, Album a){
		this.coord = new Coord(p);
		this.album = a;
	}
}
