package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

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
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		if (this.getLength() > 0) {
            System.out.println("Playing track: " + this.getTitle());
            System.out.println("Track length: " + this.getLength());
        } else {
            throw new PlayerException("ERROR: Track length is non-positive!");
        }
	}
	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		// TODO Auto-generated method stub
		Track track =(Track) obj;
		if (!(obj instanceof Track)) {
			return false;
		}
		return title.equalsIgnoreCase(track.getTitle())&& length == track.getLength();
	}

}
