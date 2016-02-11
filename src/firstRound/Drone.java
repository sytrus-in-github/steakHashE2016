package firstRound;

public class Drone {
	int id;	//identity
	int x,y;	//position
	final int capacity;
	int weight;
	int[] loads;	//loads[i] := number of product i
	
	public Drone(int initX, int initY, int capacity, int nbproduct){
		x = initX;
		y = initY;
		this.capacity = capacity;
		loads = new int[nbproduct];
		weight = 0;
	}
	
	//goto specified position and return rounds needed
	public int go(int xx,int yy){
		int r = (int) Math.ceil(Math.sqrt((x-xx)*(x-xx)+(y-yy)*(y-yy)+0.));
		x = xx;
		y = yy;
		return r;
	}
	
	//load specified number of a product if possible, return false otherwise
	public boolean load(int producttype,int productnb, int productweight){
		if( weight+productweight*productnb > capacity){
			return false;
		}
		loads[producttype] += productnb;
		weight+=productweight*productnb;
		return false;
	}
	
}
