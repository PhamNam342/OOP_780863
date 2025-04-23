package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<Track>();
	public String getArtist() {
		return artist;
	}
	public CompactDisc(String title, String category, float cost, String artist, int length, String director) {
        super(title, category, director, length, cost);
        this.artist = artist;
    }
	 public CompactDisc(String title, String category, float cost, String artist) {
	        super(title, category, cost);
	        this.artist = artist;
	    }
	public void addTrack(Track track1) {
		if(this.tracks.contains(track1)) {
			System.out.println("The track was added already");
		}
		else {
			this.tracks.add(track1);
		}
	}
	public void removeTrack(Track track) {
		if(this.tracks.contains(track)) {
			this.tracks.remove(track);
			System.out.println("The track "+ track.getTitle() +" has been removed from the list");
		}
		else {
			System.out.println("The track "+ track.getTitle() +" is not in the list");
		}
	}
	public int getLength() {
		int length = 0;
		for(Track b : tracks) {
			length += b.getLength();
		}
		return length;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing "+ this.getTitle());
		
		System.out.println("CD Length :" + this.getLength());
		System.out.println("Information of CompactDisc :" );
		for(Track track : tracks) {
			track.play();
		}
	}
	
	
}
