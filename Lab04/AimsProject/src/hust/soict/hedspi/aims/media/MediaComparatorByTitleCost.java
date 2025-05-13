package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
        int titleCompare = o1.getTitle().compareToIgnoreCase(o2.getTitle());
        if (titleCompare == 0) {
            return Float.compare(o2.getCost(), o1.getCost()); 
        }
        return titleCompare;
	}
	
}
