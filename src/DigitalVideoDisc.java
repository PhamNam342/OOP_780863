
public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	private int id;
	private static int nbDigitalVideoDisc=0;
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	public int getid() {
		return id;
	}
	public void setTitle(String tile) {
		this.title=title;
	}
	public DigitalVideoDisc(String title) {
		this.title=title;
		nbDigitalVideoDisc++;
		id=nbDigitalVideoDisc;
		}
	public DigitalVideoDisc(String title,String category) {
		this.category=category;
		this.title=title;
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
	public DigitalVideoDisc(String title,String category,String director,int length) {
		this.title=title;
		this.category=category;
		this.director=director;
		this.length=length;
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
}
