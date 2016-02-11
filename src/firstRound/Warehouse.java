package firstRound;

public class Warehouse {
	int id;
	int x,y;
	int[] products;
	int[] capacity;
	
	Warehouse(int id, int x, int y, int numberOfTypes){
		this.id = id;
		this.x = x;
		this.y = y;
		this.products = new int[numberOfTypes];
	}
}
