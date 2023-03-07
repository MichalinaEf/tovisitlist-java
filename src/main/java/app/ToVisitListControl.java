package app;

import exception.NoSuchOptionException;
import io.ConsolePrinter;
import io.DataReader;
import model.*;

import java.util.InputMismatchException;

public class ToVisitListControl {
    private DataReader dataReader = new DataReader();
    private ConsolePrinter printer = new ConsolePrinter();
    private ToVisitList toVisitList = new ToVisitList();

    public void controlLoop(){
        Option option;
        do {
            printOptions();
            option = getOption();
            switch (option){
                case ADD_CITY:
                    addCity();

                    break;
                case PRINT_CITIES_ON_YOUR_TO_VISIT_LIST:
                    printCities();
                    break;
                case ADD_MONUMENT:
                    addMonument();
                    break;
                case PRINT_MONUMENTS_ON_YOUR_TO_VISIT_LIST:
                    printMonuments();
                    break;
                case ADD_NATURAL_SPOT:
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

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk){
            try {
                option=Option.createFromInt(dataReader.getInt());
                optionOk=true;
            } catch (NoSuchOptionException e) {
                System.out.println(e.getMessage() + ", please try again");
            } catch (InputMismatchException e){
                System.out.println("Provided value is not a number");
            }
        }
        return option;
    }


    private void printOptions() {
        System.out.println("Please choose an option:");
        for (Option option:Option.values()) {
            System.out.println(option);
        }
    }

    private void addCity() {
        try {
            City city = dataReader.readAndAddCity();
            toVisitList.addCity(city);
        } catch (InputMismatchException e){
            System.out.println("New position couldn't be created, wrong data");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Limit on your ToVisitList was achieved, you should start travelling!");
        }

    }

    private void printCities() {
        Place[] places = toVisitList.getPlaces();
        printer.printCitiesToVisit(places);
    }
    private void addMonument() {
        try {
            Monument monument = dataReader.readAndAddMonument();
            toVisitList.addMonument(monument);
        } catch (InputMismatchException e){
            System.out.println("New position couldn't be created, wrong data");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Limit on your ToVisitList was achieved, you should start travelling!");
        }
    }

    private void printMonuments() {
        Place[] places = toVisitList.getPlaces();
        printer.printMonumentsToVisit(places);
    }
    private void addNewNaturalSpot() {
        try {
            NaturalSpot naturalSpot = dataReader.readAndAddNaturalSpot();
            toVisitList.addNaturalSpot(naturalSpot);
        } catch (InputMismatchException e){
            System.out.println("New position couldn't be created, wrong data");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Limit on your ToVisitList was achieved, you should start travelling!");
        }
    }

    private void printNaturalSpots() {
        Place[] places = toVisitList.getPlaces();
        printer.printNaturalSpotsToVisit(places);
    }

    private void printToVisitList() {
        Place[] places = toVisitList.getPlaces();
        printer.printAllPlacesOnToVisitList(places);
    }



    private void exit() {
        System.out.println("See you soon!");
        dataReader.close();
    }
}