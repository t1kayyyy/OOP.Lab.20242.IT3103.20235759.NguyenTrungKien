package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	public Media() {
		// TODO Auto-generated constructor stub
	}
	public Media(String title, String category, float cost) {
		this.title=title;
		this.category=category;
		this.cost=cost;
	}
	public Media(String title, String category, float cost,int id) {
		this.title=title;
		this.category=category;
		this.cost=cost;
		this.id=id;
	}
	public  Media(String title) {
		this.title=title;
	}

	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	@Override
	public boolean equals(Object obj) {
	    if (obj == null) return false;
	    if (!(obj instanceof Media)) return false;
	    Media other = (Media) obj;
	    return this.getTitle().equals(other.getTitle()) && this.getCost() == other.getCost();
	}

	public int compareTo(Media other) {
	    if (other == null) throw new NullPointerException("Cannot compare with null");
	    int titleCompare = this.getTitle().compareTo(other.getTitle());
	    if (titleCompare != 0) return titleCompare;
	    return Float.compare(this.getCost(), other.getCost());
	}

}
