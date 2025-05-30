package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

public class Track implements Playable{
	private String title;
	private int length;
	public Track() {
		// TODO Auto-generated constructor stub
		
	}
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title) {
		this.title=title;
	}
	public Track(String title,int length) {
		this.title=title;
		this.length=length;
	}
	@Override
	public void play() throws PlayerException {
	    if (this.getLength() > 0) {
	        System.out.println("Playing track: " + this.getTitle());
	        System.out.println("Track length: " + this.getLength());
	    } else {
	        System.err.println("ERROR: Track length is non-positive!");
	        throw new PlayerException("ERROR: Track length is non-positive!");
	    }
	}

	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Track)) return false;
	    Track track = (Track) o;
	    return length == track.length && title.equals(track.title);
	}

}
