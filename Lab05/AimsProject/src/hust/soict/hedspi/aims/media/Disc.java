package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	private int length;
	private String director;
	public int getLength() {
		return length;
	}
	public String getDirector() {
		return director;
	}

	public Disc() {
		super();
		this.length =0;
	}
	public Disc(String title, String category, String director, int length, float cost) {
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, float cost) {
        super(title, cost);
    }

    public Disc(String title) {
        super(title);
    }

    public Disc(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Disc(String title, String category, String director, float cost) {
        super(title, category, cost);
        this.director = director;
    }
	@Override
	public int compareTo(Media o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
