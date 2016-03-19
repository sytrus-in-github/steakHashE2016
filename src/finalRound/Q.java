package finalRound;
import tools.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class Q {
	static int T;
	static int S; // S = number of satellites
	static Satellite[] satellites;
	static int C; // C = number of collections of photos
	static Album[] albums;
	
	
	public static void main(String[] args) {
		input("constellation.in");
		output("constellation.in");
//		input("forever_alone.in");
//		output("forever_alone.in");
//		input("overlap.in");
//		output("overlap.in");
//		input("weekend.in");
//		output("weekend.in");
	}

	
	public static void input(String fileName) {
		try {
			Reader r = new Reader(fileName);
			T = r.readInt();
			S = r.readInt();
			satellites = new Satellite[S];
			for (int i = 0; i < S; i++) {
				satellites[i] = new Satellite(i, r.readInt(), r.readInt(), r.readInt(), r.readInt(), r.readInt());
			}
			C = r.readInt();
			albums = new Album[C];
			for (int i = 0; i < C; i++) {
				albums[i] = new Album(r.readInt(), r.readInt(), r.readInt());
				for (int iPhoto = 0; iPhoto < albums[i].nbPhoto; iPhoto++) {
					albums[i].addPhoto(r.readInt(), r.readInt());
				}
				for (int iRange = 0; iRange < albums[i].nbInterval; iRange++) {
					albums[i].addInterval(r.readInt(), r.readInt());
				}
			}
			
			r.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void output(String fileName) {
		
		
		try {
			FileWriter fw = new FileWriter("out_" + fileName);
			PrintWriter pw = new PrintWriter(fw);
			
			int nPhoto = 0;
			for (int i = 0; i < satellites.length; i++) {
				nPhoto += satellites[i].nPhoto();
			}
			pw.println(nPhoto);
			
			for (int i = 0; i < satellites.length; i++) {
				pw.print(satellites[i].output());
			}
			pw.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
