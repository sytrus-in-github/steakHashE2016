package finalRound;

import java.util.PriorityQueue;

public class Chiaman {

	static PriorityQueue<Album> sortedAlbum() {
		PriorityQueue<Album> sortedAlbums = new PriorityQueue<Album>();
		for (int i = 0; i < Q.C; i++) {
			sortedAlbums.add(Q.albums[i]);
		}
		return sortedAlbums;
	}
}
