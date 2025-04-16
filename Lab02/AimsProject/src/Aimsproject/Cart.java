package Aimsproject;

public class Cart {
	public static final int MAX_NUMBER_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBER_ORDERED];
	public DigitalVideoDisc[] getItemsOrdered() {
		return itemsOrdered;
	}
	public void setItemsOrdered(DigitalVideoDisc[] itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
	public int qtyOrdered = 0;
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered < MAX_NUMBER_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;
			System.out.println( "The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	//14.1
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
	public float totalCost() {
		if (qtyOrdered == 0) {
			return 0;
		}
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered && itemsOrdered[i] != null; i++) {
			totalCost += itemsOrdered[i].getCost();
		}
		return totalCost;
	}
	public void display() {
		for(int i = 0; i < qtyOrdered; i++) {
			System.out.println(i+1 + " " + itemsOrdered[i].getTitle() + "\t" + itemsOrdered[i].getCost());

		}
			System.out.println( "  " + "Total Cost" + "\t" + totalCost());
	}
}
