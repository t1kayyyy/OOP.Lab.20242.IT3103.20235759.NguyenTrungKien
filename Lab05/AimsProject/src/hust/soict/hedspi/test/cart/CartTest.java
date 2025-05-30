package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {

	public static void main(String[] args) {
		 //Create a new cart
        Cart cart = new Cart();

        //Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", 
                "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", 
                "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", 
                "Animation", 18.99f);
        cart.addMedia(dvd3);

        //Test the print method
        cart.print();
        //To-do: Test the search methods here
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("The Lion King123", 
                "Animation123", "Roger Allers123", 87, 19.95f,1234);
        cart.addMedia(dvd4);

        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Star Wars123", 
                "Science Fiction123", "George Lucas123", 87, 24.95f,2345);
        cart.addMedia(dvd5);

	}

}
