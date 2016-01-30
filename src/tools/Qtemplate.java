package tools;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Qtemplate {

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
			Reader r = new Reader("data.in");
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
