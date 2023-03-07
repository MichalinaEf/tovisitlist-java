package io;

import model.City;
import model.Monument;
import model.NaturalSpot;
import model.Place;

public class ConsolePrinter {

    public void printCitiesToVisit(Place[] places){
        int countCities = 0;
        for (Place place:places) {
            if(place instanceof City) {
                System.out.println(place.toString());
                countCities++;
            }
        }
        if(countCities == 0){
            System.out.println("You don't have any city to visit, you must add something to your list!");
        }
    }

    public void printMonumentsToVisit(Place[] places){
        int countMonuments = 0;
        for (Place place:places) {
            if(place instanceof Monument) {
                System.out.println(place.toString());
                countMonuments++;
            }
        }
        if(countMonuments == 0){
            System.out.println("You don't have any city to visit, you must add something to your list!");
        }
    }

    public void printNaturalSpotsToVisit(Place[] places){
        int countNaturalPlaces = 0;
        for (Place place:places) {
            if(place instanceof NaturalSpot) {
                System.out.println(place.toString());
                countNaturalPlaces++;
            }
        }
        if(countNaturalPlaces == 0){
            System.out.println("You don't have any city to visit, you must add something to your list!");
        }
    }

    public void printAllPlacesOnToVisitList(Place[] places) {
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
        System.out.println(builder.toString());
    }
}
