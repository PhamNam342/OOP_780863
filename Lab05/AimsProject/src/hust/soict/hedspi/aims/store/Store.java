package hust.soict.hedspi.aims.store;
import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.media.Media;
public class Store {
	public static final int MAX_ITEMS_NUMBERS = 100;
	private List<Media> itemsInStore = new ArrayList<>();
	public int number_items = 0;
	public ArrayList<Media> getItemsInStore(){
		return (ArrayList<Media>) itemsInStore;
	}
	public void addMedia(Media md ) {
		if(itemsInStore.contains(md)) {
			System.out.println("The media" + md.getTitle()+" is already added in Store!");
		}
		else {
			if(itemsInStore.size() >= MAX_ITEMS_NUMBERS) {
				System.out.println("The store is full! Can not be added!");
			}
			else {
				itemsInStore.add(md);
				System.out.println("The media "+ md.getTitle() +" has been add in Store!");
			}
		}
	}
	public void removeMedia(Media md) {
		if(itemsInStore.size() == 0) {
			System.out.println("The store is empty!");
		}
		else {
			if(itemsInStore.contains(md)) {
			itemsInStore.remove(md);
			System.out.println("The dvd "+ md.getTitle() + " has been removed from store!");
			}
			else {
				System.out.println("The item is not in Store!");
			}
		}
	}
	public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(i + 1 + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }

    public Media findMediaByTitle(String titleToPlay) {
        for (Media element : itemsInStore) {
            if (isMatch(element.getTitle(), titleToPlay)) {
                System.out.println(element.toString());
                return element;
            }
        }
        return null;
    }

    public boolean isMatch(String mediaTitle, String inputTitle) {
        return mediaTitle.contains(inputTitle);
    }
}
