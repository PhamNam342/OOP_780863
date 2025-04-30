package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	private static int nb = 0;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public Media() {
		
	}
	public Media(String title) {
		this.title = title;
		nb ++;
		this.id = nb;
	}
	public Media(String title, String Category) {
		this.title = title;
		this.category = Category;
		nb++;
		this.id = nb;
	}
	public Media(String title , float cost) {
		this.title = title;
		this.cost = cost;
		nb++;
		this.id = nb;
	}
	public Media(String title, String category , float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		nb++;
		this.id = nb;
	}
	public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
        nb++;
        
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Media - " + getId() + " - " + getTitle() + " - " + getCategory() + " - " + ": " + getCost();
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if(this == obj) return true;
		if (!(obj instanceof Media)) return false;
		Media md = (Media) obj;
		return title.equals(md.getTitle());
	}
	public int isMatch(String title) {
		return this.title.compareTo(title);
	}
}
