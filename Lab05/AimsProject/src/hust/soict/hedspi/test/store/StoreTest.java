package hust.soict.hedspi.test.store;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Store anOrder = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",	
		        "Animation", "Roger Allers", 87, 19.95f);
		    anOrder.addMedia(dvd1);

		    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
		        "Science Fiction", "George Lucas", 87, 24.95f);
		    anOrder.addMedia(dvd2);

		    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
		        "Animation", 18.99f);
		    anOrder.addMedia(dvd3);
		    System.out.println("gio hang khi chua cap nhat:");
		    anOrder.display();
		    anOrder.removeMedia(dvd2);
		    anOrder.removeMedia(dvd3);
		    //print total cost of the items in the cart
		    System.out.println("gio hang khi da cap nhat:");
		    anOrder.display();
		    
	}

}
