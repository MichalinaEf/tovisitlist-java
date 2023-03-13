package model;

import exception.PlaceAlreadyExistsException;
import exception.UserAlreadyExistsException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ToVisitList implements Serializable {
    private Map<String, Place> places = new HashMap<>();
    private Map<String, ToVisitListUser> users = new HashMap<>();

    public Map<String, Place> getPlaces() {
        return places;
    }

    public Map<String,ToVisitListUser> getUsers(){
        return users;
    }

    public void addUser(ToVisitListUser user){
        if(users.containsKey(user.getEmail()))
            throw new UserAlreadyExistsException(
                    "This email has been already used" + user.getEmail()
            );
        users.put(user.getEmail(),user);
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
        if(places.containsKey(place.getTitle()))
            throw new PlaceAlreadyExistsException(
                    "This places has been already added to your list" + place.getTitle()
            );
        places.put(place.getTitle(),place);
    }

    public boolean removePlace(Place place) {
        if (places.containsValue(place)) {
            places.remove(place.getTitle());
            return true;
        } else {
            return false;
        }
    }
}