package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	public Disc() {
		// TODO Auto-generated constructor stub
	}
	public Disc(int length) {
		this.length=length;
	}
	public Disc(int length,String director) {
		this.length=length;
		this.director=director;
	}
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}
	public Disc(String title, String category, float cost) {
		super(title,category,cost);
	}
	public Disc(String title, String category, String director, int length, float cost,int id) {
		super(title,category,cost,id);
		this.director=director;
		this.length=length;
	}
	public Disc(String title, String category, String director, float cost) {
		super(title,category,cost);
		this.director=director;
	}
	public Disc(String title, String category, String director, int length, float cost) {
		super(title,category,cost);
		this.director=director;
		this.length=length;
	}
	public Disc(String title) {
		super(title);
	}
}
