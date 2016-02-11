package firstRound;

import java.util.HashMap;

public class Command {
	int x,y;
	HashMap<Integer, Integer> items; //to a type, associate the number needed
	
	Command(String input){
		String[] s = input.split(" ");
		x = Integer.parseInt(s[0]);
		y = Integer.parseInt(s[1]);
		items = new HashMap<Integer, Integer>();
	}
}
