package finalRound;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;
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
	
	public int index;
	public Coord initCoord;
	public int v;
	public int w;
	public int d;
	
	TreeMap<Integer, PhotoTaken> photos;
	public Satellite(int index, int initLat, int initLon, int v, int w, int d) {
		this.index = index;
		initCoord = new Coord(initLat, initLon);
		this.v = v;
		this.w = w;
		this.d = d;
		photos = new TreeMap<Integer, PhotoTaken>();
		photos.put(0, new PhotoTaken(new Photo(initCoord, null), 0, 0, 0));
		photos.put(10000 + Q.T, new PhotoTaken(new Photo(getPosition(10000 + Q.T), null), 0, 0, 0));
	}
	
	public Coord getPosition(int t) {
		return initCoord.add(v * t, -15 * t);
	}
	
	public boolean inRange(int t, Photo photo) {
		Coord current = getPosition(t);
		int dLat = photo.coord.lat - current.lat;
		int dLon = photo.coord.lon - current.lon;
		if (dLon >= 180 * 3600) dLon -= 180 * 3600;
		else if (dLon < - 180 * 3600) dLon += 180 * 3600;
		
		return  (dLat >= d && dLat <= d && dLon >= d && dLon <= d);
	}
	
	public int trySetPhoto(int t, Photo photo) {
		if (photos.containsKey(t)) return -1;
		
		Coord current = getPosition(t);
		int dLat = photo.coord.lat - current.lat;
		int dLon = photo.coord.lon - current.lon;
		if (dLon >= 180 * 3600) dLon -= 180 * 3600;
		else if (dLon < - 180 * 3600) dLon += 180 * 3600;
		if (dLat > d || dLat < d || dLon > d || dLon < d) return -1;
		
		Entry<Integer, PhotoTaken> before = photos.floorEntry(t);
		Entry<Integer, PhotoTaken> after = photos.ceilingEntry(t);
		if (Math.abs(dLat - before.getValue().dLat) > w * (t - before.getKey())) return -1;
		if (Math.abs(dLon - before.getValue().dLon) > w * (t - before.getKey())) return -1;
		if (Math.abs(dLat - after.getValue().dLat) > w * (after.getKey() - t)) return -1;
		if (Math.abs(dLon - after.getValue().dLon) > w * (after.getKey() - t)) return -1;
		return 1;
	}
	public void setPhoto(int t, Photo photo) {
		Coord current = getPosition(t);
		int dLat = photo.coord.lat - current.lat;
		int dLon = photo.coord.lon - current.lon;
		if (dLon >= 180 * 3600) dLon -= 180 * 3600;
		else if (dLon < - 180 * 3600) dLon += 180 * 3600;
		photos.put(t, new PhotoTaken(photo, t, dLat, dLon));
	}
	public void removePhotos(Album album) {
		ArrayList<Integer> toBeRemoved = new ArrayList<Integer>();
		for (PhotoTaken p : photos.values()) {
			if (p.photo.album == album) {
				toBeRemoved.add(p.t);
			}
		}
		for (Integer i : toBeRemoved) {
			photos.remove(i);
		}
	}
	
	public boolean setPhotoIfAvailable(Pair time, Photo photo) {
		LinkedList<Pair> availableTime = null;
		for (Pair interval : availableTime) {
			for (int t = interval.a; t <= interval.b; t++) {
				if (trySetPhoto(t, photo) >= 0) {
					setPhoto(t, photo);
					return true;
				}
			}
		}
		return false;
	}
	public Rect getAvailableArea(int t) {
		return null;
	}
	
	public String output() {
		String res = "";
		for (PhotoTaken p : photos.values()) {
			res += p.photo.coord.lat + " " + p.photo.coord.lon + " " + p.t + " " + index + "\n";
		}
		return res;
	}
}
