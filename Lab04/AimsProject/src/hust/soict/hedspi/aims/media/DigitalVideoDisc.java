package hust.soict.hedspi.aims.media;
import hust.soict.hedspi.aims.cart.*;
public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc() {
		super();
	}
	public DigitalVideoDisc(String title,String category,String director,int length,float cost) {
		super(title, category, director, length, cost);
	}
	public DigitalVideoDisc(int id, String title,String category,String director,int length,float cost) {
		super(title, category, director, length, cost);
		this.setId(id);
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
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
	}
	
}
