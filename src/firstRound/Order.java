package firstRound;

import java.util.HashMap;

public class Order {
	public int x, y;
	public HashMap<Integer, Integer> items; // to a type, associate the number
											// needed
	public int totalItem = 0;

	public Order(int _x, int _y) {
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
		items.put(itemType, oldNumber-number);
		totalItem-=number;
	}

}
