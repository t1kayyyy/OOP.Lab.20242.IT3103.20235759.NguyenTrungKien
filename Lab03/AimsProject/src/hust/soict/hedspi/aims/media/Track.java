package hust.soict.hedspi.aims.media;

public class Track implements Playable  {

	private String artist;
	private int length;
	private String title;

	public String getArtist() {
		return artist;
	}

	public int getLength() {
		return length;
	}

	public String getTitle() {
		return title;
	}

	public Track() {
		// TODO Auto-generated constructor stub
	}
	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}
	public Track(String title, int length, String artist) {
		this.title = title;
		this.length = length;
		this.artist = artist;
	}
	@Override
	public String toString() {
		return "Track [title=" + getTitle() + ", artist=" + artist + ", length=" + length + "]";
	}

	public void play() {
		System.out.println("Playing Track: " + title);
		System.out.println("Track length: " + length);
	}
	public boolean equals(Object obj) {
		if (obj instanceof Track) {
			Track track = (Track) obj;
			return track.title.equals(this.title) && track.length == this.length;
		}
		return false;
	}
}
