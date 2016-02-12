package firstRound;

import java.util.ArrayList;
import java.util.HashMap;

public class Order {
	public int id;
	public int x, y;
	public HashMap<Integer, Integer> items; // to a type, associate the number
											// needed
	public HashMap<Integer, Warehouse> nearestWarehouse;
	public int cost;
	public int totalItem = 0;

	public Order(int id, int _x, int _y) {
		this.id = id;
		x = _x;
		y = _y;
		items = new HashMap<Integer, Integer>();
	}

	public Order(String coordinate) {
		String[] s = coordinate.split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		items = new HashMap<Integer, Integer>();
	}

	public void addOneItem(int itemType) {
		if (!items.containsKey(itemType))
			items.put(itemType, 1);
		else
			items.put(itemType, items.get(itemType) + 1);
		totalItem++;
	}

	public void receiveDelivery(int itemType, int number) {
		int oldNumber = items.get(itemType);
		if(oldNumber-number!=0)
			items.put(itemType, oldNumber-number);
		else
			items.remove(itemType);
		totalItem-=number;
	}
	
	public void initializeNearestWarehouse() {
		cost = 0;
		nearestWarehouse = new HashMap<Integer, Warehouse>();
		for (int i : items.keySet()) {
			int n = Math.min(items.get(i), Q.maxLoad / Q.products[i]);
			Warehouse house = Q.warehouses[Chiaman.nearestWarehouseEnough(x, y, i, n)];
			nearestWarehouse.put(i, house);
			cost += (items.get(i) / n) * Chiaman.turn(x, y, house.x, house.y);
		}
	}
	
	public int bestItemType(Drone drone) {
		int minTurn = Integer.MAX_VALUE;
		int minType = -1;
		for (int i : nearestWarehouse.keySet()) {
			Warehouse house = nearestWarehouse.get(i);
			int t = Chiaman.turn(house.x, house.y, drone.x, drone.y);
			if (t < minTurn) {
				minTurn = t;
				minType = i;
			}
		}
		return minType;
	}
	
	public int bestItemType2(Drone drone) {
//		int minTurn = Integer.MAX_VALUE;
		double MaxEfficiency = Double.MIN_VALUE;
		int minType = -1;
		for (int i : nearestWarehouse.keySet()) {
			Warehouse house = nearestWarehouse.get(i);
			int t = Chiaman.turn(house.x, house.y, drone.x, drone.y);
			double n = Math.min(items.get(i), Q.maxLoad / Q.products[i]);
			double efficiency = n/t;
			if (efficiency > MaxEfficiency) {
				MaxEfficiency = efficiency;
				minType = i;
			}
		}
		return minType;
	}
	
	public int bestItemType3(Drone drone) { //mother case, heaviest
		int type = -1;
		for(int t : items.keySet()){
			type = t;
			break;
		}
		for(int t : items.keySet()){
			if(Q.products[t]>Q.products[type])
				type = t;
		}
		return type;
	}
	
	public int generalScore(Drone drone, int type) {
		Warehouse house = nearestWarehouse.get(type);
		int turn = Chiaman.turn(house.x, house.y, drone.x, drone.y);
		return 11*turn + cost;
	}
	
	public static ArrayList<Order> nearestOrders(int x, int y, int minimumNumber) {
		int range = minimumNumber / 2;
		int n = 0;
		ArrayList<Order> result;
		do {
			n = 0;
			result = new ArrayList<Order>();
			for (Order o : Q.orders) {
				if (Chiaman.turn(o.x, o.y, x, y) < range) {
					n++;
					result.add(o);
				}
			}
			range *= 2;
		} while (n < minimumNumber);
		
		return result;
		
	}
	
}
