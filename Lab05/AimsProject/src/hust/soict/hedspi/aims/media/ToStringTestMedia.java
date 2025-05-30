package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class ToStringTestMedia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Media> mediae = new ArrayList<Media>();


	        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);


	        // Create a CD with tracks
	        ArrayList<Track> cdTracks = new ArrayList<>();
	        cdTracks.add(new Track("HiHi", 123));
	        cdTracks.add(new Track("HaHa", 234));

	        CompactDisc cd = new CompactDisc("Thriller", "Pop", 12.99f, "Michael Jackson", cdTracks
	        );

	        //Create a Book with authors
	        ArrayList<String> bookAuthors = new ArrayList<>();
	        bookAuthors.add("Robert C. Martin");

	        Book book = new Book("BABA", "HEHE", 29.99f, bookAuthors);

	        // Add all media to the list
	        mediae.add(dvd);
	        mediae.add(cd);
	        mediae.add(book);

	        for(Media m : mediae) {
	            System.out.println(m.toString());
	        }
	}

}
