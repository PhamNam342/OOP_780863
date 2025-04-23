package hust.soict.hedspi.aims;
import java.util.List;
import java.util.Scanner;
import java.util.*;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
public class Aims {
    static Scanner scanner = new Scanner(System.in);
    static Store store = new Store();
    static Cart cart = new Cart();

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }
    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-4");
    }
    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void filterCartMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart by Id");
        System.out.println("2. Filter medias in cart by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
    public static void cartMenu() {
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
    }

    public static void updateStoreMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add media to store");
        System.out.println("2. Remove Media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void sortCartMenu(){
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by Title and Cost");
        System.out.println("2. Sort by Cost and Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }
	public static void main(String[] args) {
		CompactDisc cd1 = new CompactDisc("P3 Reload OST", "Music", 10.99f, "Atlus", 180, "Atlus");
		CompactDisc cd2 = new CompactDisc("Final Fantasy VII Rebirth OST", "Music", 12.49f, "Square Enix", 200, "Square Enix");
		CompactDisc cd3 = new CompactDisc("Zelda: Tears of the Kingdom OST", "Music", 11.99f, "Nintendo", 175, "Nintendo");
		CompactDisc cd4 = new CompactDisc("Hollow Knight OST", "Music", 9.99f, "Team Cherry", 160, "Team Cherry");
		CompactDisc cd5 = new CompactDisc("NieR:Automata OST", "Music", 13.50f, "Square Enix", 190, "Keiichi Okabe");
		CompactDisc cd6 = new CompactDisc("Elden Ring OST", "Music", 14.25f, "FromSoftware", 210, "Yuka Kitamura");

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.95f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Spirited Away", "Animation", "Hayao Miyazaki", 125, 21.50f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Inception", "Science Fiction", "Christopher Nolan", 148, 18.75f);
 
        Book book1 = new Book("Dune Book", "Sci-fi", 9.99f);
        Book book2 = new Book("1984", "Dystopian", 8.49f);
        Book book3 = new Book("Pride and Prejudice", "Romance", 7.99f);
        Book book4 = new Book("The Hobbit", "Fantasy", 10.25f);
        Book book5 = new Book("The Catcher in the Rye", "Classic", 6.75f);
        Book book6 = new Book("To Kill a Mockingbird", "Historical", 8.95f);

        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(cd4);
        store.addMedia(cd5);

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);

        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);
        store.addMedia(book4);
        store.addMedia(book5);
        
        List<Media> media = new ArrayList<Media>();
        media.add(cd1);
        media.add(book4);
        media.add(dvd3);
        media.add(dvd2);
        for(Media m : media) {
        	System.out.println(m.toString());
        }
        
        int choice;
        String userTitle;
        Media mediaByTitle;
        do {
            showMenu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: 
                    int storeChoice;
                    do {
                        store.print();
                        storeMenu();
                        storeChoice = scanner.nextInt();
                        switch (storeChoice) {
                            case 1:
                                System.out.println("Enter the title of media: ");
                                scanner.nextLine();
                                userTitle = scanner.nextLine().trim();
                                mediaByTitle = store.findMediaByTitle(userTitle);
                                if (mediaByTitle != null) {
                                    int mediaDetailMenu_Choice;
                                    mediaDetailsMenu();
                                    mediaDetailMenu_Choice = scanner.nextInt();
                                    switch (mediaDetailMenu_Choice) {
                                        case 1:
                                            System.out.println("Enter the title of media: ");
                                            cart.addMedia(mediaByTitle);
                                            break;
                                        case 2:
                                            System.out.println("Playing :" + mediaByTitle.getTitle());
                                            break;
                                        case 0:
                                            System.out.println("Returning to store menu!");
                                            break;
                                        default:
                                            System.out.println("Invalid choice. Please try again!");
                                    }
                                }
                                break;
                            case 2:
                                System.out.println("Enter the title of media: ");
                                scanner.nextLine();
                                userTitle =  scanner.nextLine().trim();
                                mediaByTitle = store.findMediaByTitle(userTitle);
                                if(mediaByTitle != null){
                                    cart.addMedia(mediaByTitle);
                                }else{
                                    System.out.println("Title does not exist");
                                }
                                break;
                            case 3:
                                System.out.println("Enter the title of the media to play: ");
                                scanner.nextLine(); 
                                String titleToPlay = scanner.nextLine();

                                Media mediaToPlay = store.findMediaByTitle(titleToPlay);
                                if (mediaToPlay != null) {
                                    if (mediaToPlay instanceof Playable) {
                                        ((Playable) mediaToPlay).play();
                                    } else {
                                        System.out.println("The selected media is not playable.");
                                    }
                                } else {
                                    System.out.println("Media not found in the store.");
                                }
                                break;

                            case 4:
                                int cartChoice;
                                do {
                                    cart.print();
                                    cartMenu();
                                    cartChoice = scanner.nextInt();
                                    CartMenuChoice(cartChoice, cart);
                                } while (cartChoice != 0);
                                break;
                            case 0:
                                System.out.println("Returning to main menu...");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (storeChoice != 0);
                    break;

                case 2: 
                    int updateChoice;
                    do {
                        updateStoreMenu();
                        updateChoice = scanner.nextInt();
                        scanner.nextLine(); 
                        switch (updateChoice) {
                            case 1: 
                                System.out.println("Enter details of the media to add:");
                                System.out.print("Type (CD/DVD/Book): ");
                                String type = scanner.nextLine();
                                System.out.println(type);
                                Media newMedia = null;
                                if ("CD".equalsIgnoreCase(type)) {

                                    System.out.print("Enter Title: ");
                                    String title = scanner.nextLine();

                                    System.out.print("Enter Category: ");
                                    String category = scanner.nextLine();

                                    System.out.print("Enter Cost: ");
                                    float cost = scanner.nextFloat();
                                    scanner.nextLine(); 

                                    System.out.print("Enter Artist: ");
                                    String artist = scanner.nextLine();

                                    System.out.print("Enter Length: ");
                                    int length = scanner.nextInt();
                                    scanner.nextLine();  

                                    System.out.print("Enter Director: ");
                                    String director = scanner.nextLine();
                                    newMedia = new CompactDisc(title, category, cost, artist);

                                } else if ("DVD".equalsIgnoreCase(type)) {

                                    System.out.print("Enter Title: ");
                                    String title = scanner.nextLine();

                                    System.out.print("Enter Category: ");
                                    String category = scanner.nextLine();

                                    System.out.print("Enter Cost: ");
                                    float cost = scanner.nextFloat();
                                    scanner.nextLine();  

                                    System.out.print("Enter Director: ");
                                    String director = scanner.nextLine();

                                    System.out.print("Enter Length: ");
                                    int length = scanner.nextInt();
                                    scanner.nextLine(); 
                                    newMedia = new DigitalVideoDisc(title, category, director, length, cost);
                                } else if ("Book".equalsIgnoreCase(type)) {
                                    System.out.print("Enter Title, Category, and Cost: ");

                                    System.out.print("Enter Title: ");
                                    String title = scanner.nextLine();

                                    System.out.print("Enter Category: ");
                                    String category = scanner.nextLine();

                                    System.out.print("Enter Cost: ");
                                    float cost = scanner.nextFloat();
                                    scanner.nextLine(); 

                                    newMedia = new Book(title, category, cost);
                                }
                                if (newMedia != null) {
                                    store.addMedia(newMedia);
                                    System.out.println("Media added successfully!");
                                } else {
                                    System.out.println("Invalid media type.");
                                }
                                break;

                            case 2: 
                                System.out.println("Enter the title of the media to remove: ");
                                String titleToRemove = scanner.nextLine();
                                Media mediaToRemove = store.findMediaByTitle(titleToRemove);
                                if (mediaToRemove != null) {
                                    store.removeMedia(mediaToRemove);
                                    System.out.println("Media removed successfully!");
                                } else {
                                    System.out.println("Media not found in the store.");
                                }
                                break;

                            case 0: 
                                System.out.println("Returning to the main menu...");
                                break;

                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    } while (updateChoice != 0);
                    break;


                case 3: 
                    int cartChoice;
                    do {
                        cartMenu();
                        cartChoice = scanner.nextInt();
                        CartMenuChoice(cartChoice, cart);
                    } while (cartChoice != 0);
                    break;

                case 0: 
                    System.out.println("Exiting the program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
    private static void CartMenuChoice(int cartChoice, Cart cart) {
        Scanner keyboard = new Scanner(System.in);
        switch (cartChoice) {
            case 1:
                int filterCartMenu;
                do{
                    filterCartMenu();
                    filterCartMenu = keyboard.nextInt();
                    switch (filterCartMenu){
                        case 1:
                            int id;
                            System.out.println("Enter the id");
                            id = keyboard.nextInt();
                            cart.searchID(id);
                            break;
                        case 2:
                            String title;
                            keyboard.nextLine();
                            System.out.println("Entered the title");
                            title = keyboard.nextLine();
                            cart.searchByTitle(title);
                            break;
                        case 0:
                            System.out.println("Returning to cart menu...");
                            break;
                    }
                }while (filterCartMenu != 0);
                break;
            case 2:
                int sortCartMenu;
                do{
                    sortCartMenu();
                    sortCartMenu = keyboard.nextInt();
                    switch (sortCartMenu){
                        case 1:
                            cart.sortCartByTitleAndCost();
                            System.out.println("Finished sorting");
                            cart.print();
                            break;
                        case 2:
                            System.out.println("Sorting by Cost then Title:");
                            cart.sortCartByCostAndTitle();
                            System.out.println("Finished sorting");
                            cart.print();
                            break;
                        case 0:
                            System.out.println("Returning to cart menu...");
                            break;
                    }
                }while (sortCartMenu != 0);
                break;
            case 3:
                System.out.println("Enter the title: ");
                String titleToRemove = keyboard.nextLine();

                Media mediaToRemove = cart.searchByTitle(titleToRemove);
                if (mediaToRemove != null) {
                    cart.removeMedia(mediaToRemove);
                } else {
                    System.out.println("Media not found in the cart.");
                }
                break;
            case 4:
                System.out.println("Enter the title of the media to play: ");
                String titlePlay = keyboard.nextLine();

                Media mediaPlay = cart.searchByTitle(titlePlay);
                if (mediaPlay != null) {
                    if (mediaPlay instanceof Playable) {
                        ((Playable) mediaPlay).play();
                    } else {
                        System.out.println("The media is not playable.");
                    }
                } else {
                    System.out.println("Media is found in the cart.");
                }
                break;
            case 5:
                System.out.println("Order placed");
                cart.emptyCart();
                break;
            case 0:
                System.out.println("Returning to main menu!");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
}