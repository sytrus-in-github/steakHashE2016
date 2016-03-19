package finalRound;

import java.util.PriorityQueue;

public class Ruoqi {

	public static void Solve() {
		PriorityQueue<Album> sortedAlbums = Chiaman.sortedAlbum();
		for (Album a : sortedAlbums) {
			boolean albumGood = true;
			for (Photo p : a.photos) {
				boolean photoGood = false;
				for (int i = 0; i < Q.satellites.length; i++) {
					if (Q.satellites[i].setPhotoIfAvailable(a.intervals, p)) {
						photoGood = true;
						break;
					}
				}
				if (!photoGood) {
					albumGood = false;
					break;
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
