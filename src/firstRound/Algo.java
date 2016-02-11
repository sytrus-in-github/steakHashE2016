package firstRound;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Algo {
	
	PriorityQueue<Drone> drones;
	
	Algo(){
		this.drones = new PriorityQueue<Drone>();
		for(int i=0;i<Q.D;i++){
			int initX = Q.warehouses[0].x;
			int initY = Q.warehouses[0].y;
			drones.add(new Drone(initX, initY));
		}
	}
	
	ArrayList<Command> run(){
		while(!drones.isEmpty()){
			Drone d = drones.poll(); //first one that is available
			int pType = 
			int nItem = 
			Warehouse w = Chiaman.neareastWarehouseEnough(d.x,d.y,)
					
		}
	}
	
}
