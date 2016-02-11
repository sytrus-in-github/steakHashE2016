package firstRound;

import java.util.ArrayList;

public class Yuesong {
	
	public boolean isUseful(Order o, Warehouse w){
		for(int i:o.items.keySet()){
			if(o.items.get(i)>0 && w.products[i]>0){
				return true;
			}
		}
		return false;
	}
	
	public int findNearestUsefulWarehouse(Order o){
		int min = -1,distmin = Q.nCol+Q.nRow,d;
		for(int i = 0;i<Q.W;i++){
			if(isUseful(o,Q.warehouses[i])){
				d = Chiaman.turn(Q.warehouses[i].x,Q.warehouses[i].y,o.x,o.y);
				if(d<distmin){
					distmin = d;
					min = i;
				}
			}
		}
		return min;
	}
	
	public int alwaysNearest(Order i, ArrayList<Integer> warehouses){
		return 0;
	}
}
