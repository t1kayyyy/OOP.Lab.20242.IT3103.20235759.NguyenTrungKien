package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart {
    public List<Media> itemsOrdered = new ArrayList<>();
    public static final int MAX_NUMBERS_ORDERED = 20;

    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public void display() {
        for (int i = 0; i < itemsOrdered.size(); i++) {
            System.out.println((i + 1) + " " + itemsOrdered.get(i).getCategory() + " " +
                    itemsOrdered.get(i).getCost() + " " + itemsOrdered.get(i).getId());
        }
        System.out.println("So luong cua gio hang la:");
        System.out.println(itemsOrdered.size());
    }

    public void print() {
        for (Media media : itemsOrdered) {
            System.out.println("DVD - " + media.getTitle() + " - " +
                    media.getCategory() + ": " + media.getCost());
        }
        System.out.println("Total cost is: " + totalCost());
    }

    public boolean checkMedia(Media m) {
        return itemsOrdered.contains(m);
    }

    public void addMedia(Media m) {
        if (!checkMedia(m)) {
            itemsOrdered.add(m);
            System.out.println("Da them");
        } else {
            System.out.println("Da co");
        }
    }

    public void removeMedia(Media m) {
        if (itemsOrdered.remove(m)) {
            System.out.println("da xoa");
        } else {
            System.out.println("Khong ton tai");
        }
    }

    public List<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
