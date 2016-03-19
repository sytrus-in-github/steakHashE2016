package finalRound;

import java.util.SortedMap;
import java.util.TreeMap;

class PhotoTaken {
	public Photo photo;
	public int t;
	public int dLat;
	public int dLon;
	public PhotoTaken(Photo photo, int t, int dLat, int dLon) {
		this.photo = photo;
		this.t = t;
		this.dLat = dLat;
		this.dLon = dLon;
	}
}

public class Satellite {

	public Coord initCoord;
	public int v;
	public int w;
	public int d;
	
	TreeMap<Integer, PhotoTaken> photos;
	public Satellite(int initLat, int initLon, int v, int w, int d) {
		initCoord = new Coord(initLat, initLon);
		this.v = v;
		this.w = w;
		this.d = d;
		photos = new TreeMap<Integer, PhotoTaken>();
	}
	
	public Coord getPosition(int t) {
		return initCoord.add(v * t, -15 * t);
	}
	
	public void setPhoto(int t, Photo photo) {
		Coord current = getPosition(t);
		int dLat = photo.coord.lat - current.lat;
		int dLon = photo.coord.lon - current.lon;
		if (dLon >= 180 * 3600) dLon -= 180 * 3600;
		else if (dLon < - 180 * 3600) dLon += 180 * 3600;
		photos.put(t, new PhotoTaken(photo, t, dLat, dLon));
	}
	
	public Rect getAvailableArea(int t) {
		return null;
	}
}
