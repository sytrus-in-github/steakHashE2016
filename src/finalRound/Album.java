package finalRound;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Album implements Comparable<Album>{
	public int value;
	public int nbPhoto;
	public int nbInterval;
	public HashSet<Photo> photos;
	public ArrayList<Pair> intervals;
	public HashMap<Photo,Integer> taken;
	
	public Album(int value, int nbfoto, int nbrange){
		this.value = value;
		this.nbPhoto = nbfoto;
		this.nbInterval = nbrange;
		this.photos = new HashSet<>(nbPhoto);
		this.intervals = new ArrayList<>(nbInterval);
		this.taken = new HashMap<>();
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
		taken.put(ret, -1);
		return ret;
	}
	
	public Pair addInterval(Pair p){
		intervals.add(p);
		return p;
	}
	
	public Pair addInterval(int s, int e){
		Pair p = new Pair(s,e);
		return addInterval(p);
	}
	
	public void take(Photo p,int satindex){
		if(!photos.contains(p))
			System.out.println("photo does not belong to the album!");
		taken.put(p, satindex);
	}
	
	public void untake(Photo p){
		if(!photos.contains(p))
			System.out.println("photo does not belong to the album!");
		taken.put(p, -1);
	}
	
	public boolean isTaken(Photo p){
		if(!photos.contains(p))
			System.out.println("photo does not belong to the album!");
		return taken.get(p) != -1;
	}
	
	public boolean done(){
		for(Photo p: photos)
			if(taken.get(p) == -1)
				return false;
		return true;
	}
	
	public void update(Photo p, int t, int sat){
		if(p.album != this)
			return;
		if(inInterval(0, Q.T, t))
			taken.put(p, sat);
	}
	
	public boolean inInterval(int s, int e, int t){
		if(s >= e)
			return false;
		else if(s + 1 == e){
			Pair p = this.intervals.get(s);
			return t>=p.a & t<=p.b;
		}
		else {
			int m = (s+e)/2;
			return inInterval(s, m, t)||inInterval(m, e, t);
		}
	}
	
	@Override
	public int compareTo(Album that) {
		// TODO Auto-generated method stub
		if(this.value / (double)this.nbPhoto < that.value / (double) that.nbPhoto)	return -1;
		if(this.value / (double)this.nbPhoto > that.value / (double) that.nbPhoto)	return 1;
		return 0;
	}
}
