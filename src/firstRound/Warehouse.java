package firstRound;

public class Warehouse {
	int id;
	int x,y;
	int[] products;
	final int[] capacity;
	
	Warehouse(int id, int x, int y, int numberOfTypes){
		this.id = id;
		this.x = x;
		this.y = y;
		this.products = new int[numberOfTypes];
		this.capacity = new int[numberOfTypes];
	}
	
	void addInitialItems(String input){
		String[] types = input.split(" ");
		for(int i=0;i<types.length;i++)
			capacity[i] = products[i] = Integer.parseInt(types[i]);
	}
	
	boolean addItem(int type, int number){
		if(products[type]+number<=capacity[type]){
			products[type] += number;
			return true;
		} else {
			return false;
		}
	}
	
}
