package hust.soict.hedspi.aims;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.MediaComparatorByCostTitle;
import hust.soict.hedspi.aims.media.MediaComparatorByTitleCost;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
	static Scanner sc = new Scanner(System.in);
    static Store InStore = new Store();
    static Cart anOrder = new Cart();
	public static void showMenu() {  
	    System.out.println("AIMS: ");  
	    System.out.println("--------------------------------");  
	    System.out.println("1. View store");  
	    System.out.println("2. Update store");  
	    System.out.println("3. See current cart");  
	    System.out.println("0. Exit");  
	    System.out.println("--------------------------------");  
	    System.out.println("Please choose a number: 0-1-2-3");  
	    int a= sc.nextInt();
	    if(a==0) {
	    	return;
	    }else if(a==1) {
	    	StoreMenu();
	    }else if(a==2) {
	    	UpdateMenu();
	    }else if(a==3) {
	    	cartMenu();
	    }
	}  
	public static void UpdateMenu() {
		// TODO Auto-generated method stub
		System.out.println("1. AddMedia");
		System.out.println("2. RemoveMedia");
		int a = sc.nextInt();
		sc.nextLine();
		if(a==1) {
			System.out.println("Dien vao the loai ban muon them(Book,DVD,CD):");
			String type = sc.nextLine();
			if(type.equals("Book")) {
				System.out.println("Dien tieu de:");
				String title= sc.nextLine();
				System.out.println("Dien the loai:");
				String category = sc.nextLine();
				System.out.println("Dien gia:");
				int cost = sc.nextInt();
				ArrayList<String> author= new ArrayList<>();
				System.out.println("so luong tac gia:");
				int ntacgia=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<ntacgia;i++) {
					String n = sc.nextLine();
					author.add(n);
				}
				Book book = new Book(title,category,cost,author);
				InStore.addMedia(book);
			}else if(type.equals("DVD")) {
				System.out.println("Dien tieu de:");
				String title = sc.nextLine();
				System.out.println("Dien the loai:");
				String category = sc.nextLine(); 
				System.out.println("Dien giam doc:");
				String director = sc.nextLine();
				System.out.println("Dien do dai:");
				int length = sc.nextInt();
				System.out.println("Dien gia:");
				float cost = sc.nextFloat();
				DigitalVideoDisc dvd = new DigitalVideoDisc(title,category,director,length,cost);
				InStore.addMedia(dvd);
			}else if(type.equals("CD")) {
				System.out.println("Dien tieu de:");
				String title = sc.nextLine();
				System.out.println("Dien the loai:");
				String category = sc.nextLine();
				System.out.println("Dien gia:");
				float cost = sc.nextInt();
				CompactDisc cd = new CompactDisc(title,category,cost);
				InStore.addMedia(cd);
			}
		}else if(a==2) {
			System.out.println("Dien vao the loai ban xoa di(Book,DVD,CD):");
			String type = sc.nextLine();
			if(type.equals("Book")) {
				System.out.println("Dien tieu de:");
				String title= sc.nextLine();
				System.out.println("Dien the loai:");
				String category = sc.nextLine();
				System.out.println("Dien gia:");
				int cost = sc.nextInt();
				ArrayList<String> author= new ArrayList<>();
				System.out.println("so luong tac gia:");
				int ntacgia=sc.nextInt();
				sc.nextLine();
				for(int i=0;i<ntacgia;i++) {
					String n = sc.nextLine();
					author.add(n);
				}
				Book book = new Book(title,category,cost,author);
				int check=1;
				for(int i=0;i<InStore.itemsInStore.size();i++) {
					if(InStore.itemsInStore.get(i).equals(book)) {
						check=0;
						InStore.removeMedia(book);
						System.out.println("Da xoa");
					}
				}
				if (check==1) {
					System.out.println("Khong ton tai trong Store");
				}
			}else if(type.equals("DVD")) {
				System.out.println("Dien tieu de:");
				String title = sc.nextLine();
				System.out.println("Dien the loai:");
				String category = sc.nextLine(); 
				System.out.println("Dien giam doc:");
				String director = sc.nextLine();
				System.out.println("Dien do dai:");
				int length = sc.nextInt();
				System.out.println("Dien gia:");
				float cost = sc.nextFloat();
				DigitalVideoDisc dvd = new DigitalVideoDisc(title,category,director,length,cost);
				int check=1;
				for(int i=0;i<InStore.itemsInStore.size();i++) {
					if(InStore.itemsInStore.get(i).equals(dvd)) {
						check=0;
						InStore.removeMedia(dvd);
						System.out.println("Da xoa");
					}
				}
				if (check==1) {
					System.out.println("Khong ton tai trong Store");
				}
			}else if(type.equals("CD")) {
				System.out.println("Dien tieu de:");
				String title = sc.nextLine();
				System.out.println("Dien the loai:");
				String category = sc.nextLine();
				System.out.println("Dien gia:");
				float cost = sc.nextInt();
				CompactDisc cd = new CompactDisc(title,category,cost);
				int check=1;
				for(int i=0;i<InStore.itemsInStore.size();i++) {
					if(InStore.itemsInStore.get(i).equals(cd)) {
						check=0;
						InStore.removeMedia(cd);
						System.out.println("Da xoa");
					}
				}
				if (check==1) {
					System.out.println("Khong ton tai trong Store");
				}
		}
	}
}
	public static void StoreMenu() {
		// TODO Auto-generated method stub 
		    System.out.println("Options: ");  
		    System.out.println("--------------------------------");  
		    System.out.println("1. See a media’s details");  
		    System.out.println("2. Add a media to cart");  
		    System.out.println("3. Play a media");  
		    System.out.println("4. See current cart");  
		    System.out.println("0. Back");  
		    System.out.println("--------------------------------");  
		    System.out.println("Please choose a number: 0-1-2-3-4");  
		    int a=sc.nextInt();
		    sc.nextLine();
		    if(a==0) {
		    	 showMenu();
		    }else if(a==1) {
		    	Check();
		    }else if(a==2) {
		    	AddAMediaToCart();
		    }else if(a==3) {
		    	PlayAMedia();
		    }else if(a==4) {
		    	cartMenu();
		    }
	}
	public static void Check() {
		// TODO Auto-generated method stub
		int check=1;
		System.out.println("Dien vao the loai muon tim kiem(Book,DVD,CD):");
		String theloai = sc.nextLine();
		if(theloai.equalsIgnoreCase("Book")) {
			System.out.println("Dien vao tieu de book:");
			String title = sc.nextLine();
			for(int i=0;i<InStore.itemsInStore.size();i++) {
				if(InStore.itemsInStore.get(i) instanceof Book) {
					if(InStore.itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
						System.out.println(InStore.itemsInStore.get(i).toString());
						check=0;
					}
				}
			}
		}else if(theloai.equalsIgnoreCase("DVD")) {
			System.out.println("Dien vao tieu de DVD:");
			String title = sc.nextLine();
			for(int i=0;i<InStore.itemsInStore.size();i++) {
				if(InStore.itemsInStore.get(i) instanceof DigitalVideoDisc) {
					if(InStore.itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
						System.out.println(InStore.itemsInStore.get(i).toString());
						check=0;
						mediaDetailsMenu();
					}
				}
			}
		}else if(theloai.equalsIgnoreCase("CD")){
			System.out.println("Dien vao tieu de CD:");
			String title = sc.nextLine();
			for(int i=0;i<InStore.itemsInStore.size();i++) {
				if(InStore.itemsInStore.get(i) instanceof CompactDisc) {
					if(InStore.itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
						System.out.println(InStore.itemsInStore.get(i).toString());
						check=0;
						mediaDetailsMenu();
					}
				}
			}
		}
		if(check==1) {
			System.out.println("Khong co Media can tim");
		}
	}
	public static void mediaDetailsMenu() {
		// TODO Auto-generated method stub
	    System.out.println("Options: ");  	
	    System.out.println("--------------------------------");  
	    System.out.println("1. Add to cart");  
	    System.out.println("2. Play");  
	    System.out.println("0. Back");  
	    System.out.println("--------------------------------");  
	    System.out.println("Please choose a number: 0-1-2");
	    int a = sc.nextInt();
	    sc.nextLine();
	    if(a==1) {
	    	AddAMediaToCart();
	    }else if(a==2) {
	    	System.out.println("dang choi");
	    }else if(a==3) {
	    	showMenu();
	    }
	}
	public static void AddAMediaToCart() {
		int check=1;
		InStore.display();
		System.out.println("Nhap vao tieu de de them vao gio hang:");
		String title = sc.nextLine();
		for(int i=0;i<InStore.itemsInStore.size();i++) {
			if(InStore.itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
				anOrder.addMedia(InStore.itemsInStore.get(i));
				check=0;
			}
		}
		if(check==1) {
			System.out.println("Khong co trong cua hang");
		}
	}
	public static void PlayAMedia() {
		int check=1;
		InStore.display();
		System.out.println("Nhap vao tieu de de play:");
		String title = sc.nextLine();
		for(int i=0;i<InStore.itemsInStore.size();i++) {
			if(InStore.itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
				System.out.println("Dang choi ");
				check=0;
			}
		}
		if(check==1) {
			System.out.println("Khong co trong cua hang");
		}
	}
	public static void cartMenu() {  
	    System.out.println("Options: ");  
	    System.out.println("--------------------------------");  
	    System.out.println("1. Filter media in cart");  
	    System.out.println("2. Sort media in cart");  
	    System.out.println("3. Remove media from cart");  
	    System.out.println("4. Play a media");  
	    System.out.println("5. Place order");  
	    System.out.println("0. Back");  
	    System.out.println("--------------------------------");  
	    System.out.println("Please choose a number: 0-1-2-3-4-5");  
	    int a = sc.nextInt();
	    sc.nextLine();
	    if(a==0) {
	    	showMenu();
	    }else if(a==1) {
	    	Feic();
	    }else if(a==2) {
	    	SortMediaIncart();
	    }else if(a==3) {
	    	System.out.print("Da xoa");
	    }else if(a==4) {
	    	PlayAMedia();
	    }else if(a==5) {
	    	PlaceOrder();	
	    }
	} 
	public static void PlaceOrder() {
		System.out.println("Don hang da duoc tao");
		for(int i=0;i<anOrder.itemsOrdered.size();i++) {
			anOrder.removeMedia(anOrder.itemsOrdered.get(i));
		}
	}
	public static void Feic() {
		System.out.println("1. Loc theo tieu de");
		System.out.println("2. Loc theo Id");
		int a=sc.nextInt();
		sc.nextLine();
		if(a==1) {
		int check=1;
		System.out.println("Dien vao the loai muon loc(Book,DVD,CD):");
		String theloai = sc.nextLine();
		if(theloai.equalsIgnoreCase("Book")) {
			System.out.println("Dien vao tieu de book:");
			String title = sc.nextLine();
			for(int i=0;i<anOrder.itemsOrdered.size();i++) {
				if(anOrder.itemsOrdered.get(i) instanceof Book) {
					if(anOrder.itemsOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
						System.out.println(anOrder.itemsOrdered.get(i).toString());
						check=0;
					}
				}
			}
		}else if(theloai.equalsIgnoreCase("DVD")) {
			System.out.println("Dien vao tieu de DVD:");
			String title = sc.nextLine();
			for(int i=0;i<anOrder.itemsOrdered.size();i++) {
				if(anOrder.itemsOrdered.get(i) instanceof DigitalVideoDisc) {
					if(anOrder.itemsOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
						System.out.println(anOrder.itemsOrdered.get(i).toString());
						check=0;
					}
				}
			}
		}else if(theloai.equalsIgnoreCase("CD")){
			System.out.println("Dien vao tieu de CD:");
			String title = sc.nextLine();
			for(int i=0;i<anOrder.itemsOrdered.size();i++) {
				if(anOrder.itemsOrdered.get(i) instanceof CompactDisc) {
					if(anOrder.itemsOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
						System.out.println(anOrder.itemsOrdered.get(i).toString());
						check=0;
					}
				}
			}
		}
		if(check==1) {
			System.out.println("Khong co Media can tim");
		}
	}else if(a==2) {
		int check=1;
		System.out.println("Dien vao the loai muon tim kiem(Book,DVD,CD):");
		String theloai = sc.nextLine();
		if(theloai.equalsIgnoreCase("Book")) {
			System.out.println("Dien vao ID book:");
			String title = sc.nextLine();
			for(int i=0;i<anOrder.itemsOrdered.size();i++) {
				if(anOrder.itemsOrdered.get(i) instanceof Book) {
					if(anOrder.itemsOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
						System.out.println(anOrder.itemsOrdered.get(i).toString());
						check=0;
					}
				}
			}
		}else if(theloai.equalsIgnoreCase("DVD")) {
			System.out.println("Dien vao ID DVD:");
			String title = sc.nextLine();
			for(int i=0;i<anOrder.itemsOrdered.size();i++) {
				if(anOrder.itemsOrdered.get(i) instanceof DigitalVideoDisc) {
					if(anOrder.itemsOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
						System.out.println(anOrder.itemsOrdered.get(i).toString());
						check=0;
					}
				}
			}
		}else if(theloai.equalsIgnoreCase("CD")){
			System.out.println("Dien vao ID CD:");
			String title = sc.nextLine();
			for(int i=0;i<anOrder.itemsOrdered.size();i++) {
				if(anOrder.itemsOrdered.get(i) instanceof CompactDisc) {
					if(anOrder.itemsOrdered.get(i).getTitle().equalsIgnoreCase(title)) {
						System.out.println(anOrder.itemsOrdered.get(i).toString());
						check=0;
					}
				}
			}
		}
		if(check==1) {
			System.out.println("Khong co Media can tim");
		}
	}
}
	public static void SortMediaIncart() {
		System.out.println("1. SortByCostTitle");
		System.out.println("2. SortByTitleCost");
		int a= sc.nextInt();
		sc.nextLine();
		if(a==1) {
			anOrder.itemsOrdered.sort(new MediaComparatorByCostTitle());
			System.out.println("Da sx");
		}else if(a==2) {
			anOrder.itemsOrdered.sort(new MediaComparatorByTitleCost());
			System.out.println("Da sx");
	}
}
	public static void main(String[] args) {
		  Book book1 = new Book("Clean Code", "Programming", 300, new ArrayList<>(List.of("Robert C. Martin")));
		    Book book2 = new Book("Java Core", "Programming", 250, new ArrayList<>(List.of("Cay Horstmann")));
		    CompactDisc cd1 = new CompactDisc("Best Hits", "Music", 150.0f);
		    DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-fi", "Christopher Nolan", 148, 200.0f);
		    DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Matrix", "Action", "Wachowski", 136, 180.0f);

		    InStore.addMedia(book1);
		    InStore.addMedia(book2);
		    InStore.addMedia(cd1);
		    InStore.addMedia(dvd1);
		    InStore.addMedia(dvd2);

	        JFrame frame = new JFrame("AIMS - Quản Lý Cửa Hàng");
	        frame.setSize(400, 300);
	        frame.setLayout(new GridLayout(5, 1, 10, 10));
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setLocationRelativeTo(null);

	        JButton viewStoreBtn = new JButton("1. View Store");
	        JButton updateStoreBtn = new JButton("2. Update Store");
	        JButton seeCartBtn = new JButton("3. See Current Cart");
	        JButton exitBtn = new JButton("4. Exit");
	        exitBtn.addActionListener(e -> frame.dispose());
	        viewStoreBtn.addActionListener(e -> new ViewStoreScreen(InStore));
	        updateStoreBtn.addActionListener(e -> new UpdateStoreScreen(InStore));
	        seeCartBtn.addActionListener(e -> new CartScreen(anOrder));

	        frame.add(viewStoreBtn);
	        frame.add(updateStoreBtn);
	        frame.add(seeCartBtn);
	        frame.add(exitBtn);

	        frame.setVisible(true);
	}
}
