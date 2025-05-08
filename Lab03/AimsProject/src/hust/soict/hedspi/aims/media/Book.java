package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book  extends Media{
	
	private ArrayList<String> A = new ArrayList<>();
    public Book(String title, String category, float cost,ArrayList<String>authors) {
        super(title, category, cost);
        this.A=authors;    
        }
	public Book() {
		// TODO Auto-generated constructor stub
	}
	public boolean checkAuthor(String authorName) {
		for(int i=0;i<A.size();i++) {
			if(A.get(i).equalsIgnoreCase(authorName)) {
				return true;
			}
		}
		return  false;
	}
	public void addAuthor(String authorName) {
		if(checkAuthor(authorName)==false) {
			A.add(authorName);
			System.out.println("Da them");
		}else {
			System.out.println("Da co tac gia nay");
		}
	}
	public void removeAuthor(String authorName) {
		if(checkAuthor(authorName)==true) {
			A.remove(authorName);
			System.out.println("Da xoa");
		}else {
			System.out.println("Khong ton tai");
		}
	}
	@Override
	public String toString() {
		return "BOOK - " + this.getTitle()+" - "+ this.getCategory()
				+ " : "+ this.getCost() + " $";
	}
}
