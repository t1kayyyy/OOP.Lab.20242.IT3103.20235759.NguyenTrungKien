package hust.soict.hedspi.aims.cart;
import java.util.ArrayList;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Cart  {
	public ArrayList<Media> itemsOrdered = new ArrayList<Media>();  
	public static final int MAX_NUMBERS_ORDERED = 20;
	public float totalCost() {
		float sum=0;
		for(int i=0;i<itemsOrdered.size();i++) {
			sum+=itemsOrdered.get(i).getCost();
		}
		return sum;
	}
	public void display() {
		for(int i=0;i<itemsOrdered.size();i++) {
			System.out.println((i+1)+" "+itemsOrdered.get(i).getCategory()+" "+itemsOrdered.get(i).getCost()+" "+itemsOrdered.get(i).getId());
		}
		System.out.println("So luong cua gio hang la:");
		System.out.println(itemsOrdered.size());
	}
	public void print() {
		for(int i=0;i<itemsOrdered.size();i++) {
			System.out.println("DVD - "+itemsOrdered.get(i).getTitle()+" - "+itemsOrdered.get(i).getCategory()+": "+itemsOrdered.get(i).getCost());
		}
		System.out.println("Total cost is: "+ totalCost());
	}
	public void checkDigitalVideoDisc(int id) {	
		int check=0;
		for(int i=0;i<itemsOrdered.size();i++) {
			if(itemsOrdered.get(i).getId() == id ) {
				check=1;
				break;
			}
		}
		if(check==0) {
			System.out.println("Khong tim thay dia phu hop");
		}else {
			System.out.println("Co dia trong gio hang");
		}
	}
	public void checkDigitalVideoDisc(String title) {
		int check=0;
		for(int i=0;i<itemsOrdered.size();i++) {
			if(itemsOrdered.get(i).getTitle().equals(title)) {
				check=1;
				break;
			}
		}
		if(check==0) {
			System.out.println("Khong tim thay dia phu hop");
		}else {
			System.out.println("Co dia trong gio hang");
		}
	}
	public boolean checkMedia(Media m) {
		for(int i=0;i<itemsOrdered.size();i++) {
			if(itemsOrdered.get(i).equals(m)) {
				return true;
			}
		}
		return false;
	}
	public void addMedia(Media m) {
		if(!checkMedia(m)) {
			itemsOrdered.add(m);
			System.out.println("Da them");
		}else {
			System.out.println("Da co");
		}
	}
	public void removeMedia(Media m) {
		if(checkMedia(m)) {
			itemsOrdered.remove(m);
			System.out.println("da xoa");
		}else {
			System.out.println("Khong tonn tai");
		}
	}
	public void addMedia(DigitalVideoDisc[] dvdList) {
		for(int i=0;i<dvdList.length;i++) {
			itemsOrdered.add(dvdList[i]);
		}
	}
	public void addMedia(DigitalVideoDisc[] dvdList,int n) {
		if(MAX_NUMBERS_ORDERED - itemsOrdered.size() < n) {
			System.out.println("khong du cho cho phan tu");
		}else {
			for(int i=0;i<n;i++) {
				itemsOrdered.add(dvdList[i]);
			}
		}
	}
	public void SearchById(int id) {
		for(int i=0;i<itemsOrdered.size();i++) {
			if(itemsOrdered.get(i).getId()==id) {
				System.out.println("Da co");
				return;
			}
		}
		System.out.println("khong co");
	}
	public void SearchByTitle(String title) {
		for(int i=0;i<itemsOrdered.size();i++) {
			if(itemsOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
				System.out.println("Da co");
				return;
			}
		}
		System.out.println("khong co");
	}
}
