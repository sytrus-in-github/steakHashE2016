package finalRound;

import java.util.ArrayList;
import java.util.HashMap;

public class Album {
	public int value;
	public int nbPhoto;
	public int nbInterval;
	public ArrayList<Photo> photos;
	public ArrayList<Pair> intervals;
	public HashMap<Photo,Boolean> taken;
	
	public Album(int value, int nbfoto, int nbrange){
		this.value = value;
		this.nbPhoto = nbfoto;
		this.nbInterval = nbrange;
		this.photos = new ArrayList<>(nbPhoto);
		this.intervals = new ArrayList<>(nbInterval);
	}
	
	public Photo addPhoto(Coord c){
		Photo ret = new Photo(c, this);
		photos.add(ret);
		return ret;
	}
	
	public Photo addPhoto(Pair p){
		Photo ret = new Photo(p, this);
		photos.add(ret);
		return ret;
	}
	
	public Photo addPhoto(int lat,int lon){
		Photo ret = new Photo(lat, lon, this);
		photos.add(ret);
		taken.put(ret, false);
		return ret;
	}
	
	public void take(Photo p){
		if(!photos.contains(p))
			System.out.println("photo does not belong to the album!");
		taken.put(p, true);
	}
	
	public boolean isTaken(Photo p){
		if(!photos.contains(p))
			System.out.println("photo does not belong to the album!");
		return taken.get(p);
	}
}
