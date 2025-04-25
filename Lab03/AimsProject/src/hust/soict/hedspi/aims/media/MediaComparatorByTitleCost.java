package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	@Override
	public int compare(Media m1, Media m2) {
        return Comparator.comparing(Media::getTitle)
        		.thenComparing(Media::getCost)
        		.compare(m1, m2);
    }
}
