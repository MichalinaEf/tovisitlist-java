package app;

import io.DataReader;
import model.*;

public class ToVisitListControl {
    private DataReader dataReader = new DataReader();
    private ToVisitList toVisitList = new ToVisitList();

    public void controlLoop(){
        Option option;

        do {
            printOptions();
            option = Option.createFromInt(dataReader.getInt());
            switch (option){
                case ADD_NEW_CITY:
                    addNewCity();
                    break;
                case PRINT_CITIES_ON_YOUR_TO_VISIT_LIST:
                    printCities();
                    break;
                case ADD_NEW_MONUMENT:
                    addNewMonument();
                    break;
                case PRINT_MONUMENTS_ON_YOUR_TO_VISIT_LIST:
                    printMonuments();
                    break;
                case ADD_NEW_NATURAL_SPOT:
                    addNewNaturalSpot();
                    break;
                case PRINT_NATURAL_SPOTS_ON_YOUR_TO_VISIT_LIST:
                    printNaturalSpots();
                    break;
                case PRINT_TOVISITLIST:
                    printToVisitList();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Sorry, there is no option like this, please try again");
            }
        }
        while (option != Option.EXIT);
    }



    private void printOptions() {
        System.out.println("Please choose an option:");
        for (Option option:Option.values()) {
            System.out.println(option);
        }
    }

    private void addNewCity() {
        City city = dataReader.readAndAddCity();
        toVisitList.addCity(city);
    }

    private void printCities() {
        toVisitList.printCitiesToVisit();
    }
    private void addNewMonument() {
        Monument monument = dataReader.readAndAddMonument();
        toVisitList.addMonument(monument);
    }

    private void printMonuments() {
        toVisitList.printMonumentsToVisit();
    }
    private void addNewNaturalSpot() {
        NaturalSpot naturalSpot = dataReader.readAndAddNature();
        toVisitList.addNature(naturalSpot);
    }

    private void printNaturalSpots() {
        toVisitList.printNaturalSpotsToVisit();
    }

    private void printToVisitList() {
        toVisitList.printAllPlacesOnToVisitLisit();
    }



    private void exit() {
        System.out.println("See you soon!");
        dataReader.close();
    }
}