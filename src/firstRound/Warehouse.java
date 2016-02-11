package firstRound;

public class Warehouse {
	int id;
	int x,y;
	int[] products;
	
	Warehouse(int id, int x, int y, int numberOfTypes){
		this.id = id;
		this.x = x;
		this.y = y;
		this.products = new int[numberOfTypes];
	}
	
	void addInitialItems(String input){
		String[] types = input.split(" ");
		for(int i=0;i<types.length;i++)
			products[i] = Integer.parseInt(types[i]);
	}
	
	void addItem(int type, int number){
		products[type] += number;
	}
	
}
