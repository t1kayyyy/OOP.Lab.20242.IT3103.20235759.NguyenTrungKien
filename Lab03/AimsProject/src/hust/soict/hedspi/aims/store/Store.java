package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

public class Store {
	 public ArrayList<Media> itemsInStore = new ArrayList <>();
		public boolean checkMedia(Media m) {
			for(int i=0;i<itemsInStore.size();i++) {
				if(itemsInStore.get(i).equals(m)) {
					return true;
				}
			}
			return false;
		}
		public void addMedia(Media m) {
			if(!checkMedia(m)) {
				itemsInStore.add(m);
				System.out.println("Da them");
			}else {
				System.out.println("Da co");
			}
		}
		public void removeMedia(Media m) {
			if(checkMedia(m)) {
				itemsInStore.remove(m);
				System.out.println("da xoa");
			}else {
				System.out.println("Khong tonn tai");
			}
		}
		public void addMedia(DigitalVideoDisc[] dvdList) {
			for(int i=0;i<dvdList.length;i++) {
				itemsInStore.add(dvdList[i]);
			}
		}
		public void addMedia(DigitalVideoDisc[] dvdList,int n) {
				for(int i=0;i<n;i++) {
					itemsInStore.add(dvdList[i]);
				}
		}
	    public void display() {
			for(int i=0;i<itemsInStore.size();i++) {
				System.out.println((i+1)+" "+itemsInStore.get(i).getTitle()+" "+itemsInStore.get(i).getCategory()+" "+itemsInStore.get(i).getCost()+" "+itemsInStore.get(i).getId()+1);
			}
		}
		public float totalCost() {
			float sum=0;
			for(int i=0;i<itemsInStore.size();i++) {
				sum+=itemsInStore.get(i).getCost();
			}
			return sum;
		}
}
