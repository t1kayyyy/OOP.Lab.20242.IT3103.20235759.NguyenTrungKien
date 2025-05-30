package hust.soict.hedspi.aims.media;
import java.util.ArrayList;

import hust.soict.hedspi.aims.exception.PlayerException;
public class CompactDisc extends Disc implements Playable{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();
    public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
    }
   
	public CompactDisc(String title, String category, float cost) {
        super(title, category, cost);
    }
	public CompactDisc() {
		// TODO Auto-generated constructor stub
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public CompactDisc(String artist) {
		this.artist=artist;
	}
	public boolean checkTrack(Track t) {
		for(int i=0;i<tracks.size();i++) {
			if(tracks.get(i).equals(t)) {
				return true;
			}
		}
		return false;
	}
	public void addTrack(Track t) {
		if(!checkTrack(t)) {
			tracks.add(t);
			System.out.println("Da them");
		}else {
			System.out.println("Da co trong danh sach");
		}
	}
	public void removeTrack(Track t) {
		if(checkTrack(t)) {
			tracks.remove(t);
			System.out.println("Da xoa");
		}else {
			System.out.println("Khong ton tai");
		}
	}
	public int getLength() {
		int sum=0;
		for(int i=0;i<tracks.size();i++) {
			sum+=tracks.get(i).getLength();
		}
		return sum;
	}
	@Override
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing CD: " + this.getTitle());
	        for (Track track : tracks) {
	            try {
	                track.play();
	            } catch (PlayerException e) {
	                System.err.println(e.getMessage());
	                throw e;
	            }
	        }
	    } else {
	        System.err.println("ERROR: CD length is non-positive!");
	        throw new PlayerException("ERROR: CD length is non-positive!");
	    }
	}

    @Override
    public String toString() {
    	return String.format("CD - %s - %s - %s - %d: %.2f $", getTitle(), getCategory(), getArtist(), getLength(), getCost());
    }
}
