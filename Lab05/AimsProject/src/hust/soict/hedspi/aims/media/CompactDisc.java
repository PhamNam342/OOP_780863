package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

import hust.soict.hedspi.aims.exception.PlayerException;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private List<Track> tracks = new ArrayList<>();
	public String getArtist() {
		return artist;
	}
	public CompactDisc(int id,String title, String category, float cost, String artist, int length, String director) {
        super(title, category, director, length, cost);
        this.artist = artist;
        this.setId(id);
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
	@Override
	public int getLength() {
		int length = 0;
		for(Track b : tracks) {
			length += b.getLength();
		}
		return length;
	}
	@Override
	public void play() throws PlayerException {
		// TODO Auto-generated method stub
		 if (this.getLength() > 0) {
	            java.util.Iterator iter = tracks.iterator();
	            Track nextTrack;
	            while (iter.hasNext()) {
	                nextTrack = (Track) iter.next();
	                try {
	                    nextTrack.play();
	                } catch (PlayerException e) {
	                    throw e;
	                }
	            }
	        } else {
	            throw new PlayerException("ERROR:CD length is non-positive!");
	        }
	    }
	

}
