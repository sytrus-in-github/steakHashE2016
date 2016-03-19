package finalRound;

import java.util.PriorityQueue;

public class Ruoqi {

	public static void Solve() {
		//System.out.println(Q.satellites[0].initCoord.lat + " " + Q.satellites[0].initCoord.lon);
		//System.out.println(Q.satellites[0].getPosition(1).lat + " " + Q.satellites[0].getPosition(1).lon);
		//System.out.println(Q.satellites[0].getPosition(1113).lat + " " + Q.satellites[0].getPosition(1113).lon);
		System.out.println(Q.satellites[0].getPosition(10196).lat + " " + Q.satellites[0].getPosition(10196).lon);
		
		PriorityQueue<Album> sortedAlbums = Chiaman.sortedAlbum();
		int nAlbum = 0;
		for (Album a : sortedAlbums) {
			System.out.println("album" + nAlbum++);
			boolean albumGood = true;
			for (Photo p : a.photos) {
				if (!a.isTaken(p)) {
					boolean photoGood = false;
					for (int i = 0; i < Q.satellites.length; i++) {
						int timeTaken = Q.satellites[i].setPhotoIfAvailable(a.intervals, p);
						if (timeTaken >= 0) {
							photoGood = true;
							for (Album aa : sortedAlbums) {
								aa.update(p, timeTaken, i);
							}
							break;
						}
					}
					if (!photoGood) {
						albumGood = false;
						break;
					}
				}
			}
			if (!albumGood) {
				for (int i = 0; i < Q.satellites.length; i++) {
					Q.satellites[i].removePhotos(a);
				}
			}
		}
	}
}
