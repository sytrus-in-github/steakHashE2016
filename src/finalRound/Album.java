package finalRound;

import java.util.ArrayList;
import java.util.HashMap;

public class Album {
	public int value;
	public int nbPhoto;
	public int nbInterval;
	public ArrayList<Photo> photos;
	public ArrayList<Pair> intervals;
	public boolean[] taken;
	
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
	
}
