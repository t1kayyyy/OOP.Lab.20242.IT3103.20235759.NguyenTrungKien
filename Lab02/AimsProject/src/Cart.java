
public class Cart {
	public int qtyOrdered=0;
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if(qtyOrdered==MAX_NUMBERS_ORDERED) {
			System.out.println("Error");
		}else {
			itemsOrdered[qtyOrdered] = disc;
			DigitalVideoDisc.nbDigitalVideoDisc++;
			qtyOrdered++;
		}
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		int check = 0;
		int check_index=0;
		for(int i=0;i<qtyOrdered;i++) {
			if(itemsOrdered[i].equals(disc)) {
				check=1;
				check_index=i;
				break;
				}
			}
		if(check==1) {
			for(int i=check_index;i<qtyOrdered-1;i++) {
				itemsOrdered[i]=itemsOrdered[i+1];
			}
			itemsOrdered[qtyOrdered-1]=null;
			DigitalVideoDisc.nbDigitalVideoDisc--;
			qtyOrdered--;
		}
	}
	public float totalCost() {
		float sum=0;
		for(int i=0;i<qtyOrdered;i++) {
			sum+=itemsOrdered[i].cost;
		}
		return sum;
	}
	public void display() {
		for(int i=0;i<qtyOrdered;i++) {
			itemsOrdered[i].id=i+1;
			System.out.println((i+1)+" "+itemsOrdered[i].category+" "+itemsOrdered[i].cost+" "+itemsOrdered[i].id);
		}
		System.out.println("So luong cua gio hang la:");
		System.out.println(DigitalVideoDisc.nbDigitalVideoDisc);
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		if(dvdList.length+qtyOrdered>MAX_NUMBERS_ORDERED) {
			System.out.println("Error");
		}else {
			for(int i=0;i<dvdList.length;i++) {
				itemsOrdered[qtyOrdered]=dvdList[i];
				qtyOrdered++;
				DigitalVideoDisc.nbDigitalVideoDisc++;
			}
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList,int n) {
		if(MAX_NUMBERS_ORDERED<n+qtyOrdered) {
			System.out.println("Error");
		}else {
			for(int i=0;i<n;i++) {
				itemsOrdered[qtyOrdered]=dvdList[i];
				qtyOrdered++;
				DigitalVideoDisc.nbDigitalVideoDisc++;
			}
		}
	}
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
		if(MAX_NUMBERS_ORDERED<qtyOrdered+2) {
			System.out.println("Error");
		}else {
			itemsOrdered[qtyOrdered]=dvd1;
			qtyOrdered++;
			DigitalVideoDisc.nbDigitalVideoDisc++;
			itemsOrdered[qtyOrdered]=dvd2;
			qtyOrdered++;
			DigitalVideoDisc.nbDigitalVideoDisc++;
		}
	}
}
