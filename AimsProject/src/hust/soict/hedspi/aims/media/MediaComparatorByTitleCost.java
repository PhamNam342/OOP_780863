package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	public int compare(Media m1, Media m2) {
		int titlecompare = m1.getTitle().compareTo(m2.getTitle());
		if(titlecompare != 0) {
			return titlecompare;
		}
		return Float.compare(m2.getCost(), m1.getCost());
	}
	
	
}
