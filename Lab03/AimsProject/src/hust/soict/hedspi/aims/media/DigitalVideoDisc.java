package hust.soict.hedspi.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
	// Attributes
	private String title;
	private String category;
	private float cost;
	// Added attributes
	private String director;
    private int length;
    private static int nbDigitalVideoDiscs = 0;

    // Getters and setters
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Constructors - now properly chained
    public DigitalVideoDisc(String title) {
        this(title, "Unknown", 0.0f); // Calls 3-arg constructor
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        this(title, category, null, 0, cost); // Calls full constructor
    }

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        this(title, category, director, 0, cost); // Calls full constructor
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, cost); // Initialize Media fields
        this.director = director;
        this.length = length;
        nbDigitalVideoDiscs++;
    }

    @Override
    public String toString() {
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + director +
               " - " + length + ": " + getCost() + "$";
    }

    public boolean isMatch(int id) {
        return getId() == id;
    }

    public boolean isMatch(String title) {
        if (title == null || getTitle() == null) return false;
        String[] tmp = title.split(" ");
        for (String s : tmp) {
            if (s != null && getTitle().toLowerCase().contains(s.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
    public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("Director length: " + this.getDirector());
	}
}