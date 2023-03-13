package io;

import model.*;

import java.util.Collection;
import java.util.Collections;

public class ConsolePrinter {

    public void printCitiesToVisit(Collection<Place> places){
        int countCities = 0;
        for (Place place:places) {
            if(place instanceof City) {
                System.out.println(place);
                countCities++;
            }
        }
        if(countCities == 0){
            System.out.println("You don't have any city to visit, you must add something to your list!");
        }
    }

    public void printMonumentsToVisit(Collection<Place> places){
        int countMonuments = 0;
        for (Place place:places) {
            if(place instanceof Monument) {
                System.out.println(place);
                countMonuments++;
            }
        }
        if(countMonuments == 0){
            System.out.println("You don't have any city to visit, you must add something to your list!");
        }
    }

    public void printNaturalSpotsToVisit(Collection<Place> places){
        int countNaturalPlaces = 0;
        for (Place place:places) {
            if(place instanceof NaturalSpot) {
                System.out.println(place);
                countNaturalPlaces++;
            }
        }
        if(countNaturalPlaces == 0){
            System.out.println("You don't have any city to visit, you must add something to your list!");
        }
    }

    public void printAllPlacesOnToVisitList(Collection<Place> places) {
        int countPlaces = 0;
        StringBuilder builder = new StringBuilder();
        for (Place place:places) {
            builder.append(place);
            builder.append("\n");
            countPlaces++;
        }
        if(countPlaces == 0){
            System.out.println("You don't have any place to visit, you must add something to your list!");
        }
        System.out.println(builder);
    }

    public void printUsers(Collection<ToVisitListUser>users){
        for (ToVisitListUser user : users){
            System.out.println(user.toString());
        }
    }
}
