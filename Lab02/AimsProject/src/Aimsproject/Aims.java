package Aimsproject;

public class Aims {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cart anOrder = new Cart();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Aller", 87, 19.95f);
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.85f);
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		anOrder.addDigitalVideoDisc(dvd3);
		System.out.println("Total Cost is:");
		System.out.println(anOrder.totalCost());
		anOrder.addDigitalVideoDisc(dvd2);
		anOrder.addDigitalVideoDisc(dvd1);
		anOrder.display();
		//TEST
		/*
		DigitalVideoDisc [] dvdList = new DigitalVideoDisc[3];
		dvdList[0] = new DigitalVideoDisc("abc", "mnq", "def", 84, 19.2f);
		dvdList[1] = new DigitalVideoDisc("amsm", "msab", 19.1f);
		dvdList[2] = new DigitalVideoDisc("sad", "asgdh", 2.3f);
		anOrder.addDigitalVideoDisc(dvdList);
		System.out.println("Total Cost is:");
		System.out.println(anOrder.totalCost());
		anOrder.removeDigitalVideoDisc(dvdList[2]);
		System.out.println("Total Cost is:");
		System.out.println(anOrder.totalCost());
		*/
	}

}
