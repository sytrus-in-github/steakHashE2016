package finalRound;

public class Album {
	public int value;
	public int nbPhoto;
	public int nbInterval;
	public Photo[] photos;
	public Pair[] intervals;
	
	public Album(int value, int nbfoto, int nbrange){
		this.value = value;
		this.nbPhoto = nbfoto;
		this.nbInterval = nbrange;
		this.photos = new Photo[nbPhoto];
		this.intervals = new Pair[nbInterval];
	}
	
}
