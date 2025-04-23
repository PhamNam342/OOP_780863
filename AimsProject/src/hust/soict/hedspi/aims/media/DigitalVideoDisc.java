package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.cart.*;
public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc() {
		super();
	}
	public DigitalVideoDisc(String title,String category,String director,int length,float cost) {
		super(title, category, director, length, cost);
	}
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(String title,String director) {
		super();
	}
	public DigitalVideoDisc(String title,String category,String director,float cost) {
		super(title, category, director, cost);
	}
	public DigitalVideoDisc(String title,String category,float cost) {
		super(title, category, cost);
	}
	public String toString(){
		String res = new String();
		res = this.getTitle() +"-"+ this.getCategory() +"-"+ this.getDirector()+"-"+ this.getLength()+":"+this.getCost();
		return res;
	}
	public boolean isMatch(String tiltle) {
		return this.getTitle().toLowerCase().contains(tiltle.toLowerCase());
	}
	
}
