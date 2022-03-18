
public class Album {
	public String author;
	public String title;
	public int year;

	public Album(String author, String title, int year) {
		this.author = author;
		this.title = title;
		this.year = year;
	}
	
	public String toString() {
		return this.author  + " ; " + this.title +  " ; " + this.year;
	}
}
