package firstRound;
import tools.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Q {
	static int nRow, nCol, D, T, maxLoad; // D = number of drones, T = deadline, maxLoad = max load of a drone
	static int P; // P = number of different product types
	static int[] products; // weight of products
	static int W; // W = number of warehouses
	static Warehouse[] warehouses;
	static int C; // C = number of customer orders
	static Order[] orders;
	
	static int nCommand;
	
	
	public static void main(String[] args) {
//		input("busy_day.in");
//		output("busy_day.in");
		input("mother_of_all_warehouses.in");
		output("mother_of_all_warehouses.in");
//		input("redundancy.in");
//		output("redundancy.in");
	}

	
	public static void input(String fileName) {
		try {
			Reader r = new Reader(fileName);
			nRow = r.readInt();
			nCol = r.readInt();
			D = r.readInt();
			T = r.readInt();
			maxLoad = r.readInt();
			
			P = r.readInt();
			products = new int[P];
			for (int i = 0; i < P; i++) {
				products[i] = r.readInt();
			}
			
			W = r.readInt();
			warehouses = new Warehouse[W];
			for (int i = 0; i < W; i++) {
				warehouses[i] = new Warehouse(i, r.readInt(), r.readInt());
				for (int j = 0; j < P; j++) {
					warehouses[i].products[j] = r.readInt();
				}
			}
			
			C = r.readInt();
			orders = new Order[C];
			int temp;
			for (int i = 0; i < C; i++) {
				orders[i] = new Order(i, r.readInt(), r.readInt());
				temp = r.readInt();
				for (int j = 0; j < temp; j++) {
					orders[i].addOneItem(r.readInt());
				}
			}			
			
			
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void output(String fileName) {
		Algo algo = new Algo();
		ArrayList<Command> result;
		if(fileName.equals("mother_of_all_warehouses.in"))
			result = algo.run2();
		else
			result = algo.run();
		
		try {
			FileWriter fw = new FileWriter("out_" + fileName);
			PrintWriter pw = new PrintWriter(fw);
			
			int n = result.size();
			pw.println(n);
			
			for (int i = 0; i < n; i++) {
				pw.println(result.get(i));
			}
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
