package finalRound;

import java.util.PriorityQueue;

public class Ruoqi {

	public static void Solve() {
		PriorityQueue<Album> sortedAlbums = null;
		for (Album a : sortedAlbums) {
			boolean albumGood = true;
			for (Photo p : a.photos) {
				boolean photoGood = false;
				nextPhoto:
				for (Pair interval : a.intervals) {
					for (int i = 0; i < Q.satellites.length; i++) {
						if (Q.satellites[i].setPhotoIfAvailable(interval, p)) {
							photoGood = true;
							break nextPhoto;
						}
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
