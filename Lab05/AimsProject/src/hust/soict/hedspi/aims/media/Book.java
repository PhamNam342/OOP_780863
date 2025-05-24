package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
public class Book extends Media{
	private List<String> authors = new ArrayList<>();
	public List<String> getauthors(){
		return authors;
	}
	public Book() {
        super();
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }
    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }
    public Book(int id, String title, String category, float cost) {
    	super(id , title, category ,cost);
    }
    public void addAuthor(String name) {
    	if(authors.contains(name)) {
    		System.out.println("The author is already existed!");
    	}
    	else {
    		authors.add(name);
    	}
    }
    public void removeAuthor(String name) {
    	if(authors.size() ==0) {
    		System.out.println("The list is empty!");
    	}
    	else {
    		if(authors.contains(name)) {
    			authors.remove(name);
    		}
    		else {
    			System.out.println("Can find the author!");
    		}
    	}
    }
	@Override
	public int compareTo(Media o) {
		// TODO Auto-generated method stub
		return 0;
	}


}
