package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Track;
import java.util.ArrayList;
import java.util.List;

public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public String getArtist() {
		return artist;
	}

	public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public CompactDisc(String title, String category, float cost, String artist) {
        super(title, category, cost);
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, int length, String director, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);

        this.artist = artist;
        this.tracks = tracks;
    }

	public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track \"" + track.getTitle() + "\" already exists in the list.");
        } else {
            tracks.add(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been added.");
        }
    }

	public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track \"" + track.getTitle() + "\" has been deleted.");
        } else {
            System.out.println("Track \"" + track.getTitle() + "\" does not exist in the list.");
        }
    }

	public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

	@Override
	public void play() {
		// TODO Auto-generated method stub
        System.out.println("Playing CompactDisc: " + this.getTitle());
        System.out.println("Artist: " + this.getArtist());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
	}

    public String toString() {
        return "ID: " + this.getId() + " - CD: " + this.getTitle() + " - Category: " + this.getCategory() +
                " - Artist" + this.getArtist() + " - Length: " + this.getLength() + " seconds" +
                " - Cost: " + this.getCost() + "$";
    }

}
