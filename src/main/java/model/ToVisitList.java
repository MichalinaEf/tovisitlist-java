package model;

public class ToVisitList {

    private static final int maxNumberOfPlacesOnTheList = 1000;

    private Place[] places = new Place[maxNumberOfPlacesOnTheList];
    private int placesNumber;

    public void addCity(City city){
        if(placesNumber < maxNumberOfPlacesOnTheList){
            places[placesNumber] = city;
            placesNumber++;
        } else
            System.out.println("Sorry, no more space on your list, you should plan your trip now");
    }

    public void printCitiesToVisit(){
        int countCities = 0;
        for (int i = 0; i < placesNumber; i++) {
            if(places[i] instanceof City){
                System.out.println(places[i].toString());
                countCities++;
            }
        }
        if(countCities == 0){
            System.out.println("You don't have any city to visit, you must add something to your list!");
        }
    }

    public void addMonument(Monument monument){
        if(placesNumber < maxNumberOfPlacesOnTheList){
            places[placesNumber] = monument;
            placesNumber++;
        } else
            System.out.println("Sorry, no more space on your list, you should plan your trip now");
    }
    public void printMonumentsToVisit(){
        int countMonuments = 0;
        for (int i = 0; i < placesNumber; i++) {
            if(places[i] instanceof Monument){
                System.out.println(places[i].toString());
                countMonuments++;
            }
        }
        if(countMonuments == 0){
            System.out.println("You don't have any monuments to visit, you must add something to your list!");
        }
    }
    public void addNature(NaturalSpot naturalSpot){
        if(placesNumber < maxNumberOfPlacesOnTheList){
            places[placesNumber] = naturalSpot;
            placesNumber++;
        } else
            System.out.println("Sorry, no more space on your list, you should plan your trip now");
    }
    public void printNaturalSpotsToVisit(){
        int countNature = 0;
        for (int i = 0; i < placesNumber; i++) {
            if(places[i] instanceof NaturalSpot){
                System.out.println(places[i].toString());
                countNature++;
            }
        }
        if(countNature == 0){
            System.out.println("You don't have any natural spots to visit, you must add something to your list!");
        }
    }

}