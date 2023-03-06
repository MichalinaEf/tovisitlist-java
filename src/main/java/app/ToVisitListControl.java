package app;

import io.DataReader;
import model.*;

public class ToVisitListControl {

    private static final int EXIT = 0;
    private static final int ADD_NEW_CITY = 1;
    private static final int ADD_NEW_MONUMENT = 2;
    private static final int ADD_NEW_NATURAL_SPOT = 3;
    private static final int PRINT_CITIES_ON_YOUR_TO_VISIT_LIST = 4;
    private static final int PRINT_MONUMENTS_ON_YOUR_TO_VISIT_LIST = 5;
    private static final int PRINT_NATURAL_SPOTS_ON_YOUR_TO_VISIT_LIST = 6;


    private DataReader dataReader = new DataReader();

    private ToVisitList toVisitList = new ToVisitList();

    public void controlLoop(){
        int option;

        do {
            printOptions();
            option = dataReader.getInt();
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
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Sorry, there is no option like this, please try again");
            }
        }
        while (option!=EXIT);
    }



    private void printOptions() {
        System.out.println("Please choose an option:");
        System.out.println(EXIT + " - to exit the program");
        System.out.println(ADD_NEW_CITY + " - to add new city to your ToVisitList");
        System.out.println(ADD_NEW_MONUMENT + " - to add new monument to your ToVisitList");
        System.out.println(ADD_NEW_NATURAL_SPOT + " - to add new natural spot to your ToVisitList");
        System.out.println(PRINT_CITIES_ON_YOUR_TO_VISIT_LIST + " - to see cities on your ToVisitList and plan new journey :)");
        System.out.println(PRINT_MONUMENTS_ON_YOUR_TO_VISIT_LIST + " - to see monuments on your ToVisitList and plan new journey :)");
        System.out.println(PRINT_NATURAL_SPOTS_ON_YOUR_TO_VISIT_LIST + " - to see natural spots on your ToVisitList and plan new journey :)");
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


    private void exit() {
        System.out.println("See you soon!");
        dataReader.close();
    }
}