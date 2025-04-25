package hust.soict.hedspi.aims.cart;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Disc;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();
	public int qtyOrdered = 0;

	//12
	public void addMedia(Media media) {
		if (itemsOrdered.size() >= MAX_NUMBER_ORDERED) {
			System.out.println("The cart is full.");
			return;
		}
		if (!itemsOrdered.contains(media)) {
			itemsOrdered.add(media);
			System.out.println(media.getTitle() + " has been added to the cart.");
		} else {
			System.out.println(media.getTitle() + " is already in the cart.");
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			System.out.println(media.getTitle() + " has been removed from the cart.");
		} else {
			System.out.println(media.getTitle() + " is not in the cart.");
		}
	}
	/*
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBER_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;
			System.out.println( "The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	*/
	/*/14.1
	public void addDigitalVideoDisc(DigitalVideoDisc [] dvdList) {
		if(qtyOrdered < MAX_NUMBER_ORDERED) {
			for(int i =0; i < dvdList.length; i++) {
				itemsOrdered[qtyOrdered++] = dvdList[i];
			}
			System.out.println("The list dvd has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	//14.2
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
		if(qtyOrdered < MAX_NUMBER_ORDERED) {
			itemsOrdered[qtyOrdered++] = dvd1;
			itemsOrdered[qtyOrdered++] = dvd2;
			System.out.println("The disc " + dvd1.getTitle()  + "has been added");
			System.out.println("The disc " + dvd2.getTitle()  + "has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered == 0) {
			System.out.println("The cart is empty");
		}else {
			for(int i =0; i < qtyOrdered; i++) {
				if(itemsOrdered[i].equals(disc)) {
					for (int j = i; j < qtyOrdered - 1; j++) {
						itemsOrdered[j] = itemsOrdered[j + 1];
					}
					itemsOrdered[qtyOrdered - 1] = null;
					System.out.println("The disc has been removed");
					qtyOrdered--;
				}
			}
		}
	}
	*/
	public float totalCost() {
		float total = 0;
		for (Media media : itemsOrdered) {
			total += media.getCost();
		}
		return Math.round(total * 100.0f) / 100.0f;
	}
	/*
	public void display() {
		for(int i = 0; i < qtyOrdered; i++) {
			System.out.println(i+1 + " " + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost());

		}
			System.out.println( "  " + "Total Cost" + "\t" + totalCost());
	}
	public void print(){
        System.out.println("**********************CART**********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            System.out.println(i+1 + "." + itemsOrdered[i].toString());
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("*************************************************");
    }

	public void searchCart(int id){
        int check = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(id)) {
                check = 1;
                System.out.println("Item found: " + itemsOrdered[i].toString());
                break;
            }
        }
        if (check == 0) {
            System.out.println("Item not found");
        }
    }

	public void searchCart(String title){
        int check = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i].isMatch(title)) {
                check = 1;
                System.out.println("Item found: " + itemsOrdered[i].toString());
                break;
            }
        }
        if (check == 0) {
            System.out.println("Item not found");
        }
    }
    */
	public void searchCart(String title) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Media with title \"" + title + "\" were not found.");
        }
    }

    public void searchCart(int id) {
        boolean matchFound = false;
        for (Media media : itemsOrdered) {
            if (media.isMatch(id)) {
                System.out.println("Found " + media);
                matchFound = true;
            }
        }
        if (!matchFound) {
            System.out.println("Media with id " + id + " were not found.");
        }
    }

    public Media search(int id) {
        for (Media item : itemsOrdered){
            if (item.getId() == id){
                return item;
            }
        }
        return null;
    }

    public Media search(String title) {
        for (Media item : itemsOrdered){
            if (item.isMatch(title)){
                return item;
            }
        }
        return null;
    }

    public ArrayList<Media> filterById(int id) {
        ArrayList<Media> media = new ArrayList<Media>();
        for (Media item : itemsOrdered){
            if (item.getId() == id){
                media.add(item);
            }
        }
        return media;
    }

    public ArrayList<Media> filterByTitle(String title) {
        ArrayList<Media> media = new ArrayList<Media>();
        for (Media item : itemsOrdered){
            if (item.isMatch(title)){
                media.add(item);
            }
        }
        return media;
    }

    public void sortMediaByTitle() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void sortMediaByCost() {
        Collections.sort((List<Media>)itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        Iterator<Media> iterator = itemsOrdered.iterator();
        iterator = itemsOrdered.iterator();

        while (iterator.hasNext()) {
            System.out.println(((Media)iterator.next()).toString());
        }
    }
    public void playMedia(Media media) {
        if (media instanceof DigitalVideoDisc) {
            DigitalVideoDisc dvd = (DigitalVideoDisc) media;
            dvd.play();
        }
        if (media instanceof CompactDisc) {
            CompactDisc cd = (CompactDisc) media;
            cd.play();
        }
    }
    public void print(){
        System.out.println("**********************CART**********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsOrdered.size(); i++) {
            Media media = itemsOrdered.get(i);
            if (media != null) {
                System.out.println((i + 1) + ". " + media.getTitle() + " - " + media.getCost());
            } else {
                System.out.println((i + 1) + ". Null item");
            }
        }
        System.out.println("Total cost: " + totalCost());
        System.out.println("*************************************************");
    }
}
