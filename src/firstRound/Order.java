package firstRound;

import java.util.HashMap;

public class Order {
	public int x,y;
	public HashMap<Integer, Integer> items; //to a type, associate the number needed
	
	public Order(int _x, int _y) {
		x = _x;
		y = _y;
		items = new HashMap<Integer, Integer>();
	}
	
	public Order(String coordinate){
		String[] s = coordinate.split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		items = new HashMap<Integer, Integer>();
	}
	
	public void addOneItem(int itemType){
		Integer itemTypeInteger = new Integer(itemType);
			if(!items.containsKey(itemTypeInteger))
				items.put(itemTypeInteger, 1);
			else
				items.put(itemTypeInteger, items.get(itemTypeInteger) + 1);
	}
	
	public void addItems(String input){
		String[] s = input.split(" ");
		for(String str : s){
			if(!items.containsKey(Integer.parseInt(str)))
				items.put(Integer.parseInt(str), 1);
			else
				items.put(Integer.parseInt(str), items.get(Integer.parseInt(str))+1);
		}
	}
	
	
}
