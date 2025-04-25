package hust.soict.hedspi.aims;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.media.Disc;
import hust.soict.hedspi.aims.media.MediaComparatorByCostTitle;
import hust.soict.hedspi.aims.media.MediaComparatorByTitleCost;

public class Aims {
	 static Scanner scanner = new Scanner(System.in);
	 static Store store = new Store();
	 static Cart cart = new Cart();

	public static void showMenu() {
		while(true) {
			System.out.println("AIMS: ");
			System.out.println("--------------------------------");
			System.out.println("1. View store");
			System.out.println("2. Update store");
			System.out.println("3. See current cart");
			System.out.println("0. Exit");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3");

			int choice = scanner.nextInt();
            if (choice == 0) {
            	System.out.println("Exiting...");
                break;
            }
            else if (choice == 1) {
                store.printStore();
                storeMenu();
            }
            else if (choice == 2) {
                updateStore();
            }
            else if (choice == 3) {
            	cart.print();
                cartMenu();
            }
		}

	}

	public static void storeMenu() {
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. See a media’s details");
			System.out.println("2. Add a media to cart");
			System.out.println("3. Play a media");
			System.out.println("4. See current cart");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4");

			int choice = scanner.nextInt();
            if (choice == 0) {
            	break;
            }
            else if (choice == 1) {
                System.out.print("Please enter the title of media: ");
                scanner.nextLine();
                String mediaName = scanner.nextLine();
                Media media = store.getMedia(mediaName);
                if (media == null)
                	System.out.println("Media " + mediaName + " not found.");
                else{
                    System.out.println(media);
                    mediaDetailsMenu(media);
                }
            }
            else if (choice == 2) {
                System.out.print("Please enter the title of media: ");
                scanner.nextLine();
                String mediaName = scanner.nextLine();
                Media media = store.getMedia(mediaName);
                if (media == null)
                	System.out.println("Media " + mediaName + " not found.");
                else{
                    cart.addMedia(media);
                    cart.print();
                }
            }
            else if (choice == 3) {
                System.out.print("Please enter the title of media: ");
                scanner.nextLine();
                String mediaName = scanner.nextLine();
                Media media = store.getMedia(mediaName);
                if (media == null)
                	System.out.println("Media " + mediaName + " not found.");
                else if (media instanceof Book)
                	System.out.println("Media need be CD or DVD.");
                else store.playMedia(media);
            }
            else if (choice == 4) {
            	cart.print();
            	cartMenu();
            }
		}
	}

	public static void mediaDetailsMenu(Media media) {
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Add to cart");
			if (!(media instanceof Book)) System.out.println("2. Play");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.print("Please choose a number: 0-1");
			if (!(media instanceof Book)) System.out.println("-2");
			else System.out.println();

			int choice = scanner.nextInt();

			if (choice == 0) {
				break;
			}
			else if (choice == 1) {
				cart.addMedia(media);
				cart.print();
			}
			else if (choice == 2 && !(media instanceof Book)) {
				store.playMedia(media);
			}
		}
	}

    public static void updateStore() {
    	while(true) {
    		System.out.println("Options: ");
    		System.out.println("--------------------------------");
    		System.out.println("1. Add a media to store");
    		System.out.println("2. Remove a media from store");
    		System.out.println("0. Back");
    		System.out.println("--------------------------------");
    		System.out.println("Please choose a number: 0-1-2");

    		int choice = scanner.nextInt();
    		if (choice == 0) {
    			break;
    		}
    		else if (choice == 1) {
    			addMedia();
    		}
    		else if (choice == 2) {
    			System.out.print("Please enter the title of media: ");
    			scanner.nextLine();
    			String mediaName = scanner.nextLine();
    			Media media = store.getMedia(mediaName);
    			if (media == null)
    				System.out.println("Media " + mediaName + " not found in the cart");
    			else{
    				store.removeMedia(media);
    			}
    		}
    	}
    }

    static public void addMedia(){
        while(true) {
        	System.out.println("Options: ");
        	System.out.println("-------------------------------");
        	System.out.println("1. Add a book");
        	System.out.println("2. Add a CD");
        	System.out.println("3. Add a DVD");
        	System.out.println("0. Back");
        	System.out.println("-------------------------------");
        	System.out.println("Please choose a number: 0-1-2-3");

        	int choice = scanner.nextInt();

        	if (choice == 0){
        		break;
        	}
        	else {
        		System.out.println("Enter the title: ");
        		scanner.nextLine();
        		String title = scanner.nextLine();
        		System.out.println("Enter the category: ");
        		String category = scanner.nextLine();
        		System.out.println("Enter the cost: ");
        		float cost = scanner.nextFloat();
        		if (choice == 1){
        			System.out.println("Enter the authors(different names separated by spaces): ");
        			scanner.nextLine();
        			String authors = scanner.nextLine();
        			if(authors != ""){
        				String[] authorsArray = authors.split(" ");
        				List<String> authorsList = Arrays.asList(authorsArray);
        				store.addMedia(new Book(title, category, cost, authorsList));
        			}
        			else store.addMedia(new Book(title, category, cost));
        		}
        		else if (choice == 2){
        			System.out.println("Enter the length (leave blank if unknown): ");
        			scanner.nextLine();
        			String inp = scanner.nextLine();
        			if (inp.isEmpty()) store.addMedia(new CompactDisc(title, category, cost));
        			else {
        				int length = Integer.parseInt(inp);
        				System.out.println("Enter the director: ");
        				String director = scanner.nextLine();
        				System.out.println("Enter the artist: ");
        				String artist = scanner.nextLine();
        				System.out.println("Enter the number of tracks: ");
        				int tracks = scanner.nextInt();
        				ArrayList<Track> trackList = new ArrayList<Track>();
        				for (int i = 0; i < tracks; i++) {
        					System.out.println("Track " + (i+1) + " : ");
        					System.out.println("Enter the title of the track: ");
        					scanner.nextLine();
        					String trackTitle = scanner.nextLine();
        					System.out.println("Enter the duration of the track: ");
        					int duration = scanner.nextInt();
        					trackList.add(new Track(trackTitle, duration));
        					System.out.println("Track " + trackTitle + " has been added to the CD");
        				}
        				store.addMedia(new CompactDisc(title, category, cost, length, director, artist, trackList));
        			}
        		}
        		else if (choice == 3){
        			System.out.println("Enter the length (leave blank if unknown): ");
        			scanner.nextLine();
        			String inp = scanner.nextLine();
        			if (inp.isEmpty()) store.addMedia(new DigitalVideoDisc(title, category, cost));
        			else {
        				int length = Integer.parseInt(inp);
        				System.out.println("Enter the director: ");
        				String director = scanner.nextLine();
        				store.addMedia(new DigitalVideoDisc(title, category, director, length, cost));
        			}
        		}
        	}

        }
    }

	public static void cartMenu() {
		while(true) {
			System.out.println("Options: ");
			System.out.println("--------------------------------");
			System.out.println("1. Filter medias in cart");
			System.out.println("2. Sort medias in cart");
			System.out.println("3. Remove media from cart");
			System.out.println("4. Play a media");
			System.out.println("5. Place order");
			System.out.println("0. Back");
			System.out.println("--------------------------------");
			System.out.println("Please choose a number: 0-1-2-3-4-5");

			int choice = scanner.nextInt();
    		if (choice == 0) {
    			break;
    		}
            else if (choice == 1) {
                filterCartMenu();
            }
            else if (choice == 2) {
                sortCartMenu();
            }
    		else if (choice == 3) {
                System.out.print("Please enter the title of media: ");
                scanner.nextLine();
                String mediaName = scanner.nextLine();
                Media media = cart.search(mediaName);
                if (media == null) System.out.println("Media " + mediaName + " not found in the cart");
                else{
                    cart.removeMedia(media);
                }
    		}
    		else if (choice == 4) {
                System.out.print("Please enter the title of media: ");
                scanner.nextLine();
                String mediaName = scanner.nextLine();
                Media media = store.getMedia(mediaName);
                if (media == null)
                	System.out.println("Media " + mediaName + " not found in cart.");
                else if (media instanceof Book)
                	System.out.println("Media need be CD or DVD.");
                else cart.playMedia(media);
    		}
    		else if (choice == 5) {
                System.out.println("Order is created");
                cart = new Cart();
    		}
		}
	}

    public static void filterCartMenu(){
    	while(true) {
    		System.out.println("Options: ");
    		System.out.println("--------------------------------");
    		System.out.println("1. By id");
    		System.out.println("2. By title");
    		System.out.println("0. Back");
    		System.out.println("--------------------------------");
    		System.out.println("Please choose a number: 0-1-2");

    		int choice = scanner.nextInt();

    		if (choice == 0) {
    			break;
    		}
    		else if (choice == 1) {
    			System.out.println("Enter the id: ");
    			int id = scanner.nextInt();
    			ArrayList<Media> media = cart.filterById(id);
    			if (!media.isEmpty()){
    				for (Media item : media) {
    					System.out.println(item.toString());
    				}
    			}
    			else System.out.println("Media with id " + id + " not found");
    		}
    		else if (choice == 2) {
    			System.out.println("Enter the title: ");
    			scanner.nextLine();
    			String title = scanner.nextLine();
    			ArrayList<Media> media = cart.filterByTitle(title);
    			if (!media.isEmpty()) {
    				for (Media item : media) {
    					System.out.println(item.toString());
    				}
    			}
    			else System.out.println("Media name " + title + " not found");
    		}
    	}
    }

    public static void sortCartMenu(){
        while(true) {
        	System.out.println("Options: ");
        	System.out.println("--------------------------------");
        	System.out.println("1. By title");
        	System.out.println("2. By cost");
        	System.out.println("0. Back");
        	System.out.println("--------------------------------");
        	System.out.println("Please choose a number: 0-1-2");

        	int choice = scanner.nextInt();

        	if (choice == 0) {
        		break;
        	}
        	else if (choice == 1) {
        		cart.sortMediaByTitle();
        	}
        	else if (choice == 2) {
        		cart.sortMediaByCost();
        	}
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers",87,19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
        Book book1 = new Book("Clean Code", "Programming", 45.5f, Arrays.asList("Robert C. Martin"));
        Book book2 = new Book("The Pragmatic Programmer", "Programming", 50.0f, Arrays.asList("Andrew Hunt David Thomas"));
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(book1);
        store.addMedia(book2);
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        showMenu();


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
