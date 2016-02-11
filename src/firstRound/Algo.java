package firstRound;

import java.util.ArrayList;
import java.util.PriorityQueue;

import firstRound.Command.CommandType;

public class Algo {
	
	PriorityQueue<Drone> drones;
	
	Algo(){
		this.drones = new PriorityQueue<Drone>();
		for(int i=0;i<Q.D;i++){
			int initX = Q.warehouses[0].x;
			int initY = Q.warehouses[0].y;
			drones.add(new Drone(i, initX, initY));
		}
	}
	
	ArrayList<Command> run(){
		ArrayList<Command> res = new ArrayList<Command>();
		while(!drones.isEmpty()){
			Drone d = drones.poll(); //first one that is available
			Order order = null;
			for(Order o : Q.orders)
				if(o.totalItem>0){
					order = o;
					break;
				}
			if(order==null)
				break;
			
			int pType=-1;
			for(int i: order.items.keySet()){
				pType = i;
				break;
			}
			
			int nItem = order.items.get(pType);
			nItem = Math.min(nItem, Q.maxLoad/Q.products[pType]);
			Warehouse w = Q.warehouses[Chiaman.nearestWarehouseEnough(d.x,d.y,pType,nItem)];
			w.removeItem(pType, nItem);
			order.receiveDelivery(pType, nItem);
			int toWarehouse = Chiaman.turn(d.x, d.y, w.x, w.y);
			int warehouseToOrder = Chiaman.turn(w.x,w.y,order.x,order.y);
			d.available += (toWarehouse+warehouseToOrder+2);
			if(d.available<=Q.T)
				drones.add(d);
			Command load = new Command(CommandType.Load,d.id , w.id, pType, nItem);
			Command unload = new Command(CommandType.Deliver, d.id, order.id, pType, nItem);
			res.add(load);
			res.add(unload);
		}
		return res;
	}
	
}
