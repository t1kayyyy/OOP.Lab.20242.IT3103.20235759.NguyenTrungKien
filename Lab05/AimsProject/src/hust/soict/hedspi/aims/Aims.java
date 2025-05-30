package hust.soict.hedspi.aims;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Playable;
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
        int a = sc.nextInt();
        sc.nextLine();
        if (a == 0) {
            return;
        } else if (a == 1) {
            StoreMenu();
        } else if (a == 2) {
            UpdateMenu();
        } else if (a == 3) {
            cartMenu();
        }
    }

    public static void StoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        int a = sc.nextInt();
        sc.nextLine();
        if (a == 0) {
            showMenu();
        } else if (a == 1) {
            Check();
        } else if (a == 2) {
            AddAMediaToCart();
        } else if (a == 3) {
            PlayAMedia();
        } else if (a == 4) {
            cartMenu();
        }
    }

    public static void PlayAMedia() {
        int check = 1;
        InStore.display();
        System.out.println("Nhap vao tieu de de play:");
        String title = sc.nextLine();
        for (int i = 0; i < InStore.itemsInStore.size(); i++) {
            if (InStore.itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
                check = 0;
            }
        }
        if (check == 1) {
            System.out.println("Khong co trong cua hang");
        }
    }

    public static void AddAMediaToCart() {
        int check = 1;
        InStore.display();
        System.out.println("Nhap vao tieu de de them vao gio hang:");
        String title = sc.nextLine();
        for (int i = 0; i < InStore.itemsInStore.size(); i++) {
            if (InStore.itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
                anOrder.addMedia(InStore.itemsInStore.get(i));
                check = 0;
            }
        }
        if (check == 1) {
            System.out.println("Khong co trong cua hang");
        }
    }

    public static void Check() {
        int check = 1;
        System.out.println("Dien vao tieu de muon tim kiem:");
        String title = sc.nextLine();
        for (int i = 0; i < InStore.itemsInStore.size(); i++) {
            if (InStore.itemsInStore.get(i).getTitle().equalsIgnoreCase(title)) {
                System.out.println(InStore.itemsInStore.get(i).toString());
                check = 0;
            }
        }
        if (check == 1) {
            System.out.println("Khong co Media can tim");
        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Play a media");
        System.out.println("2. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int a = sc.nextInt();
        sc.nextLine();
        if (a == 0) {
            showMenu();
        } else if (a == 1) {
            PlayAMedia();
        } else if (a == 2) {
            PlaceOrder();
        }
    }

    public static void PlaceOrder() {
        System.out.println("Don hang da duoc tao");
        anOrder.itemsOrdered.clear();
    }

    public static void UpdateMenu() {
        System.out.println("1. AddMedia");
        System.out.println("2. RemoveMedia");
        int a = sc.nextInt();
        sc.nextLine();
        if (a == 1) {
            System.out.println("Dien vao tieu de:");
            String title = sc.nextLine();
            System.out.println("Dien vao the loai:");
            String category = sc.nextLine();
            System.out.println("Dien gia:");
            float cost = sc.nextFloat();
            sc.nextLine();
            DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, "Director", 120, cost);
            InStore.addMedia(dvd);
        }
    }

    public static void main(String[] args) {
        Book book1 = new Book("Clean Code", "Programming", 300, new ArrayList<>(List.of("Robert C. Martin")));
        CompactDisc cd1 = new CompactDisc("Best Hits", "Music", 150.0f);
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Inception", "Sci-fi", "Christopher Nolan", 148, 200.0f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Error DVD", "Sci-fi", "Error", 0, 100.0f); // Test lỗi PlayerException

        InStore.addMedia(book1);
        InStore.addMedia(cd1);
        InStore.addMedia(dvd1);
        InStore.addMedia(dvd2);

        showMenu();
    }
}
