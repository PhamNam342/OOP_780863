package hust.soict.hedspi.aims.cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import static hust.soict.hedspi.aims.media.Media.COMPARE_BY_COST_TITLE;
import static hust.soict.hedspi.aims.media.Media.COMPARE_BY_TITLE_COST;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Cart {
	 public static final int MAX_NUMBERS_ORDERED = 20;
	    private List<Media>itemsOrdered = new ArrayList<Media>();
	    public void addMedia(Media md) {
	        	if (itemsOrdered.size() < MAX_NUMBERS_ORDERED){
	            itemsOrdered.add(md);
	            System.out.println( md.getTitle() + " has been added to your cart!");
	        		}
	        	else {
	            System.out.println("The cart is almost full!");
	        		}
	    }
	    public void addMedia(Media md1, Media md2) {
	    		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED ) {
	    		itemsOrdered.add(md1);
	    		System.out.println( md1.getTitle() + " has been added to your cart!");
	    		}
	    		else {
		    		System.out.println("The cart is almost full!");
	    		}
	    		if(itemsOrdered.size() < MAX_NUMBERS_ORDERED ) {
		    		itemsOrdered.add(md2);
		    		System.out.println( md2.getTitle() + " has been added to your cart!");
	    		}
		    		else {
			    		System.out.println("The cart is almost full!");
		    		}
	    	}
	    public void removeMedia(Media md) {
	    	if(itemsOrdered.size()==0) {
	    		System.out.println("You have not added any media");
	    	}
	    	else {
	    		if(itemsOrdered.contains(md)) {
	    			itemsOrdered.remove(md);
	    		}
	    		else {
	    			System.out.println("Can not find the media!");
	    		}
	    	}
	    }
	    public void addMedia(Media[] mediaList) { 
	        for (Media media : mediaList) {
	            if (itemsOrdered.size() > MAX_NUMBERS_ORDERED) {
	                System.out.println("MAX NUMBERS ORDERED REACHED");
	                return;
	            }
	            itemsOrdered.add(media);
	            System.out.println("Product " + media.getTitle() + " is added ");
	        }
	    }
	    public float total() {
	    	if(itemsOrdered.isEmpty()) {
	    		return 0;
	    	}
	    	else {
	    		float cost = 0;
	            for (Media media : itemsOrdered) {
	                cost += media.getCost();
	            }
	            return cost;
	    	}
	    }
	    public void print() {
	    	System.out.println("***********************CART***********************");
	    	for (int i = 0 ; i < itemsOrdered.size();i++) {
	            System.out.printf("%d %-3d %-20s %4.2f\n",i+1,itemsOrdered.get(i).getId(), itemsOrdered.get(i).getCategory(), itemsOrdered.get(i).getCost());
	        }
	        System.out.printf("%-3s %-20s %4.2f\n","","Total Cost", total());
	        System.out.println("***************************************************");
	    }
	   public void searchID(int id){
			if(itemsOrdered.isEmpty()) {
				System.out.println("The cart is empty!");
			}
			boolean found = false;
	        for (Media media : itemsOrdered) {
	            if (id == media.getId()) {
	                System.out.println(media.toString());
	                found = true;
	            }
	        }
	        if (!found) {
	            System.out.println("No matching titles found for \"" + id + "\".");
	        }

	   }
	   public void searchTitle(String title) {
	        if(itemsOrdered.isEmpty()) {
	        	System.out.println("The cart is empty!");
	        }
	        else {
	        	boolean found = false;
	        	for(Media md : itemsOrdered) {
	        		if(md.getTitle().equals(title)) {
	        			found = true;
	        			System.out.println(md.toString());
	        			break;
	        		}
	        	}
	        	if (!found) {
		            System.out.println("No matching titles found for \"" + title + "\".");
		        }
	        }
	    }
	   public Media searchByTitle(String title) {
		   if(itemsOrdered.isEmpty()) {
			   return null;
		   }
		   else {
			   for(Media md : itemsOrdered) {
				   if(md.getTitle().equals(title)) {
					   return md;
				   }
			   }
			   return null;
		   }
	   }
	    public boolean isMatch(String mediaTitle, String inputTitle) {
	        return mediaTitle.contains(inputTitle);
	    }
	    public void sortCartByTitleAndCost() {
	        itemsOrdered.sort(COMPARE_BY_TITLE_COST);
	    }

	    public void sortCartByCostAndTitle() {
	        itemsOrdered.sort(COMPARE_BY_COST_TITLE);
	    }
	    public void displayCartItems() {
	        for (int i = 0; i < itemsOrdered.size(); i++) {
	            System.out.printf("%-3d %-20s %10.2f\n", i + 1, itemsOrdered.get(i).getTitle(), itemsOrdered.get(i).getCost());
	        }
	        System.out.printf("%-3s %-20s %10.2f\n", "", "Total Cost", total());
	    }
	    public void emptyCart() {
	        itemsOrdered.clear();
	        System.out.println("The cart has been emptied.");
	    }
	   
	  }
	   



