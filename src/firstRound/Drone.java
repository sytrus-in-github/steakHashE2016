package firstRound;

public class Drone implements Comparable<Drone>{
	int id;	//identity
	int x,y;	//position
	int weight;
	int[] loads;	//loads[i] := number of product i
	int available;	//first available round
	
	public Drone(int initX, int initY){
		x = initX;
		y = initY;
		loads = new int[Q.P];
		weight = 0;
		available = 0;
	}
	
	//goto specified position and return rounds needed
	public int go(int xx,int yy){
		int r = (int) Math.ceil(Math.sqrt((x-xx)*(x-xx)+(y-yy)*(y-yy)+0.));
		x = xx;
		y = yy;
		return r;
	}
	
	//load specified number of a product if possible, return false otherwise
	public void load(int producttype,int productnb) throws Exception{
		if( weight+Q.products[producttype]*productnb > Q.maxLoad){
			throw new Exception("Too heavy! Current weight: " + weight + ", capacity: "+Q.maxLoad+", try to load "+productnb+" product of type "+producttype);
		}
		loads[producttype] += productnb;
		weight+=Q.products[producttype]*productnb;
	}
	
	//unload specified number of a product if possible, return false otherwise
		public void unload(int producttype,int productnb) throws Exception{
			if(loads[producttype] < productnb){
				throw new Exception("Not enough stock! Current stock of product " + producttype + "is: "+loads[producttype]+" < "+productnb);
			}
			loads[producttype] -= productnb;
			weight -= Q.products[producttype]*productnb;
		}

		@Override
		public int compareTo(Drone that) {
			// TODO Auto-generated method stub
			if(this.available<that.available)	return -1;
			if(this.available>that.available)	return 1;
			return 0;
		}
}
