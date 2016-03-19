package finalRound;
import tools.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Q {
	static int T;
	static int S; // S = number of satellites
	static Satellite[] satellites;
	static int C; // C = number of collections of photos
	static Album[] albums;
	
	
	public static void main(String[] args) {
		run("constellation.in");
		//run("forever_alone.in");
		//run("overlap.in");
		//run("weekend.in");
		ZipControl.zipSrc();
	}
	
	public static void run(String fileName) {
		input(fileName);
		Ruoqi.Solve();
		output(fileName);
	}

	
	public static void input(String fileName) {
		try {
			Reader r = new Reader(fileName);
			T = r.readInt();
			//System.out.println(T);
			S = r.readInt();
			//System.out.println(S);
			satellites = new Satellite[S];
			for (int i = 0; i < S; i++) {
				satellites[i] = new Satellite(i, r.readInt(), r.readInt(), r.readInt(), r.readInt(), r.readInt());
				//if (i == 0) System.out.println(satellites[0].initCoord.lat + " " + satellites[0].initCoord.lon);
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
