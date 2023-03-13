package model;

import java.io.Serializable;

public class ToVisitList implements Serializable {

    private static final int MAX_NUMBER_OF_PLACES_ON_THE_LIST = 1000;

    private Place[] places = new Place[MAX_NUMBER_OF_PLACES_ON_THE_LIST];
    private int placesNumber;

    public Place[] getPlaces() {
        Place[] result = new Place[placesNumber];
        for (int i = 0; i < placesNumber; i++) {
            result[i] = places[i];
        }
        return result;
    }

    public void addCity(City city){
        addPlace(city);
    }

    public void addMonument(Monument monument){
        addPlace(monument);
    }

    public void addNaturalSpot(NaturalSpot naturalSpot){
        addPlace(naturalSpot);
    }

    public void addPlace(Place place){
        if(placesNumber>=MAX_NUMBER_OF_PLACES_ON_THE_LIST){
            throw new IndexOutOfBoundsException("Max places on the list exceeded" + MAX_NUMBER_OF_PLACES_ON_THE_LIST);
        }
        places[placesNumber]=place;
        placesNumber++;
    }
}