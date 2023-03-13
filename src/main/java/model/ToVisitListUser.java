package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ToVisitListUser extends User{

    private List <Place> visitedPlaces = new ArrayList<>();
    private List<Place> placesToVisit = new ArrayList<>();

    public List<Place> getVisitedPlaces() {
        return visitedPlaces;
    }

    public List<Place> getPlacesToVisit() {
        return placesToVisit;
    }

    public ToVisitListUser(String firstName, String lastName, String email) {
        super(firstName, lastName, email);
    }

    public void addPlaceToVisitedPlaces(Place place){
        visitedPlaces.add(place);
    }

    public void addToToVisitList(Place place){
        placesToVisit.add(place);
    }

    public boolean moveToVisitedPlaces(Place place){
        boolean result = false;
        if(placesToVisit.remove(place)){
            result = true;
            addPlaceToVisitedPlaces(place);
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ToVisitListUser that = (ToVisitListUser) o;
        return Objects.equals(visitedPlaces, that.visitedPlaces)
                && Objects.equals(placesToVisit, that.placesToVisit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), visitedPlaces, placesToVisit);
    }

    public String toCsv(){
        return getFirstName() + ";" + getLastName() + ";" + getEmail();
    }
}
