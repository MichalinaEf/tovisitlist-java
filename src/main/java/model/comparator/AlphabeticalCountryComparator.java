package model.comparator;

import model.Place;

import java.util.Comparator;

public class AlphabeticalCountryComparator implements Comparator<Place> {
    @Override
    public int compare(Place p1, Place p2) {
        if(p1 == null && p2 == null) {
            return 0;
        } else if (p1 == null) {
            return 1;
        } else if (p2 == null) {
            return -1;
        }
        return p1.getCountry().compareToIgnoreCase(p2.getCountry());
    }
}
