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
	
	public int closestOrder(Drone dr){
		int id = -1,distmin = Q.nCol+Q.nRow,d;
		for(int i = 0;i<Q.C;i++){
			Order o = Q.orders[i];
			if(o.totalItem>0){
				d = Chiaman.turn(dr.x,dr.y,o.x,o.y);
				if(d<distmin){
					distmin = d;
					id = i;
				}
			}
		}
		return id;
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
	
	public int displace(Order o, Warehouse w){
		return 0;
	}
	
	public int alwaysNearest(Order i, ArrayList<Integer> warehouses){
		Order o = null;
		return 0;
	}
}
