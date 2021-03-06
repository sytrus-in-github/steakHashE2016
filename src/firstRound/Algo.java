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
//			Order order = null;
//			for(Order o : Q.orders)
//				if(o.totalItem>0){
//					order = o;
//					break;
//				}
			
//			int orderId = Yuesong.closestOrder(d);
//			if(orderId==-1)
//				break;
//			Order order = Q.orders[orderId];
////			if(order==null)
////				break;
//			
//			int pType=-1;
//			for(int i: order.items.keySet()){
//				pType = i;
//				break;
//			}
			
			Order bestOrder = null;
			int bestType = -1;
			int bestScore = Integer.MAX_VALUE;
			Order[] orders = Q.orders;
			for (Order o : orders) {
				o.initializeNearestWarehouse();
				int typeTemp = o.bestItemType2(d);
				if (typeTemp == -1) continue;
				int score = o.generalScore(d, typeTemp);
				if (score < bestScore) {
					bestOrder = o;
					bestType = typeTemp;
					bestScore = score;
				}
			}
			int pType = bestType;
			Order order = bestOrder;
			if (bestType == -1) break;
			
			
			int nItem = order.items.get(pType);
			nItem = Math.min(nItem, Q.maxLoad/Q.products[pType]);
			
			Warehouse w = Q.warehouses[Chiaman.nearestWarehouseEnough(d.x,d.y,pType,nItem)];
			
			w.removeItem(pType, nItem);
			order.receiveDelivery(pType, nItem);
	
			int remainingWeight = Q.maxLoad - Q.products[pType]*nItem;
			int pType2=0;
			
			ArrayList<Command> loads = new ArrayList<Command>();
			Command load = new Command(CommandType.Load,d.id , w.id, pType, nItem);
			loads.add(load);
			ArrayList<Command> unloads = new ArrayList<Command>();
			Command unload = new Command(CommandType.Deliver, d.id, order.id, pType, nItem);
			unloads.add(unload);
			
			while(pType2!=-1){
				pType2=-1;
				for(int i: order.items.keySet()){
					if(Q.products[i]<=remainingWeight&&w.products[i]>0){
						pType2 = i;
						break;
					}
				}
	
				if(pType2!=-1){ //if can load another type of item
					int nItem2 = order.items.get(pType2);
					nItem2 = Math.min(nItem2, remainingWeight/Q.products[pType2]);
					nItem2 = Math.min(nItem2, w.products[pType2]);
					w.removeItem(pType2, nItem2);
					order.receiveDelivery(pType2, nItem2);
					remainingWeight -= Q.products[pType2]*nItem2;
					Command load2 = new Command(CommandType.Load,d.id , w.id, pType2, nItem2);
					Command unload2 = new Command(CommandType.Deliver,d.id , order.id, pType2, nItem2);
					loads.add(load2);
					unloads.add(unload2);
				}
			}	
			int toWarehouse = Chiaman.turn(d.x, d.y, w.x, w.y);
			int warehouseToOrder = Chiaman.turn(w.x,w.y,order.x,order.y);
			d.available += (toWarehouse+warehouseToOrder+loads.size()*2);
			d.x = order.x;
			d.y = order.y;
			if(d.available<=Q.T)
				drones.add(d);
			res.addAll(loads);
			res.addAll(unloads);
		}
		return res;
	}
	
	ArrayList<Command> run2(){ //mother case
		ArrayList<Command> res = new ArrayList<Command>();
		PriorityQueue<Order> ordersQueue = new PriorityQueue<Order>(new Test(Q.warehouses[0]));
		for(Order o:Q.orders)
			ordersQueue.add(o);
		while(!drones.isEmpty()&&!ordersQueue.isEmpty()){
			Drone d = drones.poll(); //first one that is available
			Order order = ordersQueue.poll();
			order.initializeNearestWarehouse();
			int pType = order.bestItemType(d);
			if (pType == -1){ //order completed
				drones.add(d);
				continue;		
			}

			int nItem = order.items.get(pType);
			nItem = Math.min(nItem, Q.maxLoad/Q.products[pType]);
			
			Warehouse w = Q.warehouses[0];
			
			w.removeItem(pType, nItem);
			order.receiveDelivery(pType, nItem);
	
			int remainingWeight = Q.maxLoad - Q.products[pType]*nItem;
			int pType2 =0;
			ArrayList<Command> loads = new ArrayList<Command>();
			Command load = new Command(CommandType.Load,d.id , w.id, pType, nItem);
			loads.add(load);
			ArrayList<Command> unloads = new ArrayList<Command>();
			Command unload = new Command(CommandType.Deliver, d.id, order.id, pType, nItem);
			unloads.add(unload);
			
			while(pType2!=-1){
				pType2=-1;
				for(int i: order.items.keySet()){
					if(Q.products[i]<=remainingWeight&&w.products[i]>0){
						if(pType2==-1)
							pType2 = i;
						else{
							if(Q.products[pType2]<Q.products[i])
								pType2 = i;
						}
					}
				}
	
				if(pType2!=-1){ //if can load another type of item
					int nItem2 = order.items.get(pType2);
					nItem2 = Math.min(nItem2, remainingWeight/Q.products[pType2]);
					nItem2 = Math.min(nItem2, w.products[pType2]);
					w.removeItem(pType2, nItem2);
					order.receiveDelivery(pType2, nItem2);
					remainingWeight -= Q.products[pType2]*nItem2;
					Command load2 = new Command(CommandType.Load,d.id , w.id, pType2, nItem2);
					Command unload2 = new Command(CommandType.Deliver,d.id , order.id, pType2, nItem2);
					loads.add(load2);
					unloads.add(unload2);
				}
			}
			int toWarehouse = Chiaman.turn(d.x, d.y, w.x, w.y);
			int warehouseToOrder = Chiaman.turn(w.x,w.y,order.x,order.y);
			d.available += (toWarehouse+warehouseToOrder+loads.size()*2);
			d.x = order.x;
			d.y = order.y;
			
			while(remainingWeight>0){
				
			}
			
			
			
			if(d.available<=Q.T)
				drones.add(d);
			ordersQueue.add(order);
			res.addAll(loads);
			res.addAll(unloads);
		}
		return res;
	}
	
	
}
