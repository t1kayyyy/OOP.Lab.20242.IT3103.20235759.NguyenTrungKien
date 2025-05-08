package hust.soict.hedspi.aims.media;

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
	public void play() {
		// TODO Auto-generated method stub
		 System.out.println("Playing DVD: " + this.getTitle());  
		 System.out.println("DVD length: " + this.getLength()); 
	}
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (!(o instanceof Track)) return false;
	    Track track = (Track) o;
	    return length == track.length && title.equals(track.title);
	}

}
