package firstRound;

import java.util.ArrayList;

public class Yuesong {
	
	public static boolean isUseful(Order o, Warehouse w,int producttype){
		if(o.items.get(producttype)>0 && w.products[producttype]>0){
			return true;
		}
		else
			return false;
	}
	
	public static int closestOrder(Drone dr){
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
	
	public static int closestOrderThatNeedsType(Drone dr, int type){
		int id = -1,distmin = Q.nCol+Q.nRow,d;
		for(int i = 0;i<Q.C;i++){
			Order o = Q.orders[i];
			if(o.items.containsKey(type)){
				d = Chiaman.turn(dr.x,dr.y,o.x,o.y);
				if(d<distmin){
					distmin = d;
					id = i;
				}
			}
		}
		return id;
	}
	
	public static int findNearestUsefulWarehouse(Order o,int producttype){
		int min = -1,distmin = Q.nCol+Q.nRow,d;
		for(int i = 0;i<Q.W;i++){
			if(isUseful(o,Q.warehouses[i],producttype)){
				d = Chiaman.turn(Q.warehouses[i].x,Q.warehouses[i].y,o.x,o.y);
				if(d<distmin){
					distmin = d;
					min = i;
				}
			}
		}
		return min;
	}
	
	public static int displace(Order o, Warehouse w){
		return 0;
	}
	
	public int alwaysNearest(Order i, ArrayList<Integer> warehouses){
		Order o = null;
		return 0;
	}
}
