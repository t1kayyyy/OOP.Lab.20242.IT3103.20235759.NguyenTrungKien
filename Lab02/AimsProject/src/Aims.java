
public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		    //Create a new cart
		    Cart anOrder = new Cart();

		    //Create new dvd objects and add them to the cart
		    DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",	
		        "Animation", "Roger Allers", 87, 19.95f);
		    anOrder.addDigitalVideoDisc(dvd1);

		    DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
		        "Science Fiction", "George Lucas", 87, 24.95f);
		    anOrder.addDigitalVideoDisc(dvd2);

		    DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin",
		        "Animation", 18.99f);
		    anOrder.addDigitalVideoDisc(dvd3);
		    DigitalVideoDisc[] dvdList= new DigitalVideoDisc[7];
		    for(int i=0;i<dvdList.length;i++) {
		    	dvdList[i] = new DigitalVideoDisc("The Lion King222",
		        "Animation", "Roger Allers", 87, 19.95f);
		    }
		    anOrder.addDigitalVideoDisc(dvdList);
		    anOrder.addDigitalVideoDisc(dvdList, 5);
		    System.out.println("gio hang khi chua cap nhat:");
		    anOrder.display();
		    anOrder.removeDigitalVideoDisc(dvd2);
		    anOrder.removeDigitalVideoDisc(dvd3);
		    anOrder.addDigitalVideoDisc(dvd2, dvd3);
		    //print total cost of the items in the cart
		    System.out.println("gio hang khi da cap nhat:");
		    anOrder.display();
		    System.out.println("Total Cost is: ");
		    System.out.println(anOrder.totalCost());
		    
	}

}
