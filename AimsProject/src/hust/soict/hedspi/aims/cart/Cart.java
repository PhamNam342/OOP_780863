package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.disc.*;
import java.util.Scanner;
public class Cart {
	 public static final int MAX_NUMBERS_ORDERED = 20;
	    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	    public int qtyOrdered = 0;
	    public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
	        	if (qtyOrdered < MAX_NUMBERS_ORDERED){
	        	qtyOrdered++;
	            itemsOrdered[qtyOrdered] = dvd;
	            System.out.println( dvd.getTitle() + " has been added to your cart!");
	        		}
	        	else {
	            System.out.println("The cart is almost full!");
	        		}
	    }
	    public void addDigitalVideoDisc(DigitalVideoDisc... dvdlist) {
	    		if(qtyOrdered+ dvdlist.length<= MAX_NUMBERS_ORDERED){
	    			for(DigitalVideoDisc dvd: dvdlist) {
	    			qtyOrdered++;
	    			itemsOrdered[qtyOrdered] = dvd;
	    			 System.out.println( dvd.getTitle() + " has been added to your cart!");
	    					}
	    			}
	    		else {
	    		System.out.println("Can not add,please reduce your dvd");
	    			}
	    }
	    public void addDigitalVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
	    		if(qtyOrdered+2<= MAX_NUMBERS_ORDERED ) {
	    		qtyOrdered++;
	    		itemsOrdered[qtyOrdered] = dvd1;
	    		System.out.println( dvd1.getTitle() + " has been added to your cart!");
	    		qtyOrdered++;
	    		itemsOrdered[qtyOrdered]= dvd2;
	    		System.out.println( dvd2.getTitle() + " has been added to your cart!");
	    			}
	    		else {
	    		System.out.println("The cart is almost full!");
	    			}
	    	}
	    public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
	    	if(qtyOrdered==0) {
	    		System.out.println("You have not added any disc");
	    	}
	    	for(int i=1;i<=qtyOrdered;i++) {
	    		if(itemsOrdered[i].getTitle().equals(dvd)) {
	    			for(int j=i;j<=qtyOrdered;j++) {
	    				itemsOrdered[j]=itemsOrdered[j+1];
	    			}
	    			itemsOrdered[qtyOrdered]=null;
	    			qtyOrdered--;
	    			System.out.println( dvd.getTitle() + " has been removed from your cart!");
	    		}
	    	}
	    }
	    public float total() {
	    	if(qtyOrdered==0) {
	    		return 0;
	    	}
	    	else {
	    		float sum=0;
	    		for(int i=1;i<=qtyOrdered;i++) {
	    			sum+=itemsOrdered[i].getCost();
	    		}
	    		return sum;
	    	}
	    }
	    public void display() {
	    	System.out.println("***********************CART***********************");
	    	for (int i = 1; i <=qtyOrdered; i++) {
	            System.out.printf("%d %-3d %-20s %4.2f\n",itemsOrdered[i].getId(),i, itemsOrdered[i].getTitle(), itemsOrdered[i].getCost());
	        }
	        System.out.printf("%-3s %-20s %4.2f\n","","Total Cost", total());
	        System.out.println("***************************************************");
	    }
	   public void searchDVDID(){
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Nhap chuoi vao:");
			int id_input= keyboard.nextInt();
			for(int i = 1 ;i <= qtyOrdered ; i++) {
				if (itemsOrdered[i].getId() == id_input) {
					System.out.println(itemsOrdered[i].toString());
				}
			}
	   }
			public void searchDVDTitle(String keyword) {
				boolean match_found = false;
				for(int i = 1; i<= qtyOrdered ;i++) {
					if(itemsOrdered[i].isMatch(keyword)== true) {
						System.out.println("Found! "+ itemsOrdered[i].toString());
						match_found = true;
						break;
					}
				}
				if(match_found== false) {
					System.out.println("Sorry, no DVD were found");
				}
			}
			}
	   //public void searchDVDTitle(){



