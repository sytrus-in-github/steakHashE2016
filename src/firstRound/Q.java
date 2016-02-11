package firstRound;
import tools.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Q {
	static int nRow, nCol, D, T, maxLoad;
	static int P;
	static int[] products;
	static int W;
	static Warehouse[] warehouses;
	
	static int n;
	static int[][] data;
	static int[] result;
	
	public static void main(String[] args) {
		input();
		solve();
		output();
	}
	
	public static void solve() {
		for (int i = 0; i < n; i++) {
			
		}
	}
	
	public static void input() {
		try {
			Reader r = new Reader("busy_day.in");
			// Reader r = new Reader("mother_of_all_warehouse.in");
			// Reader r = new Reader("redundancy.in");
			nRow = r.readInt();
			nCol = r.readInt();
			D = r.readInt();
			T = r.readInt();
			maxLoad = r.readInt();
			
			P = r.readInt();
			for (int i = 0; i < P; i++) {
				products[i] = r.readInt();
			}
			
			W = r.readInt();
			warehouses = new Warehouse[W];
			for (int i = 0; i < W; i++) {
//				warehouse
//				warehouses[i].id = i;
//				warehouse[i].x = r.readInt();
			}
			
			n = r.readInt();
			data = new int[n][];
			result = new int[n];
			for (int i = 0; i<n; i++) {
				int t = r.readInt();
				data[i] = new int[t+1];
				for (int j = 0; j<=t; j++) {
					data[i][j] = r.readInt();
				}
			}
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void output() {
		try {
			FileWriter fw = new FileWriter("answer.txt");
			PrintWriter pw = new PrintWriter(fw);
		
			for (int i = 0; i<n; i++) {
				pw.println("Case #"+(i+1)+": "+result[i]);
			}
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

}
