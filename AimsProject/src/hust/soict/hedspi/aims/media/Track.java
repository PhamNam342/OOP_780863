package hust.soict.hedspi.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	public String getTitle() {
		return title;
	}
	public int getLength() {
		return length;
	}
	public Track(String title) {
		this.title = title;
	}
	public Track(String title , int length) {
		this.length = length;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println(this.getTitle() + " is playing");
		System.out.println(this.getTitle() +" is "+ this.length);
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		// TODO Auto-generated method stub
		Track track =(Track) obj;
		
		return this.equals(track.getTitle()) && this.equals(track.getLength());
	}
	
}
