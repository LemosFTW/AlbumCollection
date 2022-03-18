import java.util.ArrayList;
import java.util.Collections;

public class AlbumCollection {
	public ArrayList<Album> album;

	public AlbumCollection() {
		album = new ArrayList<Album>();
	}

	public void addAlbum(Album album) {
		this.album.add(album);
	}

	public void removeAlbum(String author, String title) {
		for (int i = 0; i < this.album.size(); i++) {
			Album album = this.album.get(i);
			if (album.author.equals(author) && album.title.equals(title)) {
				this.album.remove(i);
				break;
			}
		}
	}

	public boolean hasAlbum(String author, String title) {
		for (int i = 0; i < this.album.size(); i++) {
			Album album = this.album.get(i);
			if (album.author.equals(author) && album.title.equals(title))
				return true;
		}

		return false;
	}

	public static ArrayList<Album> sortAlbum(ArrayList<Album> originalAlbum) {
		@SuppressWarnings("unchecked")
		ArrayList<Album> album = (ArrayList<Album>) originalAlbum.clone();

		int albumSize = album.size();

		for (int i = 1; i < albumSize; i++) {
			for (int j = albumSize - 1; j >= i; j--) {
				Album prev = album.get(j - 1);
				Album next = album.get(j);

				if (prev.year > next.year || (prev.year == next.year && (prev.author.compareTo(next.author) > 0
						|| (prev.author.equals(next.author) && prev.title.compareTo(next.title) > 0)))) {
					Collections.swap(album, j - 1, j);
				}

			}
		}

		return album;
	}

	public ArrayList<Album> getAuthorsAlbum(String author) {
		ArrayList<Album> album = new ArrayList<Album>();

		for (int i = 0; i < this.album.size(); i++) {
			if (this.album.get(i).author.equals(author))
				album.add(this.album.get(i));
		}

		return AlbumCollection.sortAlbum(album);
	}
}
