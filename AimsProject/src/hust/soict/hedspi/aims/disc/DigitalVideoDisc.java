package hust.soict.hedspi.aims.disc;
import hust.soict.hedspi.aims.cart.*;
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private static int nbDigitalVideoDisc=0;
	public int id;

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public String getCategory() {
		return category;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getId() {
		return id;
	}
	public DigitalVideoDisc(String title) {
		this.title=title;
		nbDigitalVideoDisc++;
		id=nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(String title,String director) {
		this.title=title;
		this.director=director;
		nbDigitalVideoDisc++;
		id=nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(String title,String category,String director,float cost) {
		this.title=title;
		this.category=category;
		this.director=director;
		this.cost=cost;
		nbDigitalVideoDisc++;
		id=nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(String title,String category,float cost) {
		this.title=title;
		this.category=category;
		this.cost=cost;
		nbDigitalVideoDisc++;
		id=nbDigitalVideoDisc;
	}
	public DigitalVideoDisc(String title,String category,String director,int length,float cost) {
		this.title=title;
		this.category=category;
		this.director=director;
		this.length=length;
		this.cost=cost;
		nbDigitalVideoDisc++;
		id=nbDigitalVideoDisc;
	}
	public String toString(){
		String res = new String();
		res = this.getTitle() +"-"+ this.getCategory() +"-"+ this.getDirector()+"-"+ this.getLength()+":"+this.getCost();
		return res;
	}
	public boolean isMatch(String tiltle) {
		return this.title.toLowerCase().contains(tiltle.toLowerCase());
	}
}
