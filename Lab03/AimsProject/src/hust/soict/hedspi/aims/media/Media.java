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
	@Override
	public boolean equals(Object o) {
	    if (this == o) return true;
	    if (o == null || getClass() != o.getClass()) return false;

	    Media media = (Media) o;
	    return title != null ? title.equals(media.title) : media.title == null;
	}
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
}
