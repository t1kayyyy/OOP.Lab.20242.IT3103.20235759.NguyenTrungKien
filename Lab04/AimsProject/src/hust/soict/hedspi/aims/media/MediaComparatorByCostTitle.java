package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media>{

	@Override
	public int compare(Media o1, Media o2) {
		// TODO Auto-generated method stub
        int costCompare = Float.compare(o2.getCost(), o1.getCost());
        if (costCompare == 0) {
            return o1.getTitle().compareToIgnoreCase(o2.getTitle());
        }
        return costCompare;
	}
}
