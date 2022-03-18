import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static final String LEAVE = "SAIR";

	public static String author;
	public static String title;
	public static int year;

	public static AlbumCollection albumCollection;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		albumCollection = new AlbumCollection();

		String command = nextLine(in);

		while (true) {
		 handleCommand(in, command);
		 
		 if(command.equals(LEAVE)) break;
		 
			command = nextLine(in);	
		}
	}
	
	public static String nextLine(Scanner in) {
		return in.nextLine().trim();
	}

	public static void handleCommand(Scanner in, String command) {
		switch (command) {
		case "RA":
			albumCollection.addAlbum(new Album(nextLine(in), nextLine(in), in.nextInt()));

			System.out.println("Album inserido");

			break;

		case "CA":
			if (albumCollection.hasAlbum(nextLine(in), nextLine(in))) {
				System.out.println("Album existente");
			} else {
				System.out.println("Album inexistente");
			}

			break;

		case "LC":
			ArrayList<Album> album = albumCollection.album;

			for (int i = 0; i < album.size(); i++) {
				System.out.println(album.get(i));
			}

			break;

		case "LAA":
            ArrayList<Album> album2 = albumCollection.album;
            String author = nextLine(in);

            for (int i = 0; i < album2.size(); i++) {
                if (album2.get(i).author.equals(author))
                    System.out.println(album2.get(i));
            }
            break;

		case "LCO":
			ArrayList<Album> sortedAlbum = AlbumCollection.sortAlbum(albumCollection.album);

			for (int i = 0; i < sortedAlbum.size(); i++) {
				System.out.println(sortedAlbum.get(i));
			}

			break;

		case "LAO":
			ArrayList<Album> sortedAuthorsAlbum = albumCollection.getAuthorsAlbum(nextLine(in));
			
			for (int i = 0; i < sortedAuthorsAlbum.size(); i++) {
				System.out.println(sortedAuthorsAlbum.get(i));
			}
			
			break;
			
		case "AA":
			albumCollection.removeAlbum(nextLine(in), nextLine(in));
			System.out.println("Album removido");
			break;
			
		case LEAVE:
			System.out.println("A colecao tem " + albumCollection.album.size() + " albuns");
			break;

		}
	}
}