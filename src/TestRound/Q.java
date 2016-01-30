package TestRound;
import tools.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Q {

	static ArrayList<Integer> result;
	
	public static void main(String[] args) {
		input();
		solve();
		output();
	}
	
	public static void solve() {
		
	}
	
	public static void input() {
		try {
			Reader r = new Reader("input_2.txt");
			GreedyAlgo ga = new GreedyAlgo(r.readInt());
			ga.addPoint(new Point(-1,0,0));
			try{
				while (true) {
					int id = r.readInt();
					int x = r.readInt();
					int y = r.readInt();
					ga.addPoint(new Point(id, x, y));
				}
			} catch (Exception ex) {System.out.println("Finished Reading");}
			result = ga.run();

			System.out.println(result.size());

			System.out.println("Result:"+result.size());

			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void output() {
		try {
			FileWriter fw = new FileWriter("answer.txt");
			PrintWriter pw = new PrintWriter(fw);
		
			for (int i = 0; i < result.size(); i++) {
				pw.println(result.get(i));
			}
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
			
	}

}
