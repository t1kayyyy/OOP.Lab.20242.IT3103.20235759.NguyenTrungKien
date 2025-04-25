package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;


public class Book extends Media {

	private List<String> authors = new ArrayList<>();

	public List<String> getAuthors() {
		return authors;
	}
	public Book() {
		// TODO Auto-generated constructor stub
	}

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
        } else {
            System.out.println("Author already exists: " + authorName);
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
        } else {
            System.out.println("Author not found: " + authorName);
        }
    }

    @Override
    public String toString() {
        return "ID: " + this.getId() + " - Book: " + this.getTitle() +
                " - Category: " + this.getCategory() +
                " - Cost: " + this.getCost() + "$";
    }

    // Optional getter for authors
}