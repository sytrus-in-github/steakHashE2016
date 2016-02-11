package firstRound;

import java.util.HashMap;

public class Command {
	int x,y;
	HashMap<Integer, Integer> items; //to a type, associate the number needed
	
	Command(String coordinate){
		String[] s = coordinate.split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		items = new HashMap<Integer, Integer>();
	}
	
	void addItems(String input){
		String[] s = input.split(" ");
		for(String str : s){
			if(!items.containsKey(Integer.parseInt(str)))
				items.put(Integer.parseInt(str), 1);
			else
				items.put(Integer.parseInt(str), items.get(Integer.parseInt(str))+1);
		}
	}
	
	
}
