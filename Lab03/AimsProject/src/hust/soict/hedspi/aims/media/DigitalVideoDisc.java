package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title,category,cost);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title,category,director,cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title,category,director,length,cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost,int id) {
		super(title,category,director,length,cost,id);
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		 System.out.println("Playing DVD: " + this.getTitle());  
		 System.out.println("DVD length: " + this.getLength()); 
	}

	@Override
	public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }
}
