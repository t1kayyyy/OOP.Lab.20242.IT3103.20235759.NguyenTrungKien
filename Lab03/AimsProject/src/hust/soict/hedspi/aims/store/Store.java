package hust.soict.hedspi.aims.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.*;
import java.util.ArrayList;

public class Store {
	//private DigitalVideoDisc[] itemsInStore;
	//private int numberOfItemsInStore;
	private ArrayList<Media> itemsInStore;
	public Store(){
		itemsInStore = new ArrayList<Media>();
	}
	public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
        	itemsInStore.add(media);
            System.out.println(media.getTitle() + " has been added to the store.");
        } else {
            System.out.println(media.getTitle() + " is already in the store.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
        	itemsInStore.remove(media);
            System.out.println(media.getTitle() + " has been removed from the store.");
        } else {
            System.out.println(media.getTitle() + " is not in the store.");
        }
    }

    public Media getMedia(String title) {
        for (Media m : itemsInStore) {
            if (m.getTitle().equals(title)) {
                return m;
            }
        }
        return null;
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

    public void printStore(){
        System.out.println("***********************STORE***********************");
        System.out.println("Items in Store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }

	/*
	public Store(int maxItem){
        itemsInStore = new DigitalVideoDisc[maxItem];
        numberOfItemsInStore = 0;
    }

    public void addDVD(DigitalVideoDisc dvd){
        if (numberOfItemsInStore < itemsInStore.length){
            itemsInStore[numberOfItemsInStore] = dvd;
            numberOfItemsInStore++;
            System.out.println("Added DVD: " + dvd.getTitle());
        }
        else {
            System.out.println("Store is full");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd){
        boolean removed = false;
        for (int i = 0; i < numberOfItemsInStore; i++){
            if (itemsInStore[i].equals(dvd)){
                removed = true;
                for(int j = i; j < numberOfItemsInStore-1; j++){
                    itemsInStore[j] = itemsInStore[j+1];
                }
                numberOfItemsInStore--;
                System.out.println("Removed DVD: " + dvd.getTitle());
                break;
            }
        }
        */
}
