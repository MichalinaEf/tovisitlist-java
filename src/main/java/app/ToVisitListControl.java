package app;

import exception.DataExportException;
import exception.DataImportException;
import exception.NoSuchOptionException;
import exception.UserAlreadyExistsException;
import io.ConsolePrinter;
import io.DataReader;
import io.file.FileManager;
import io.file.FileManagerBuilder;
import model.*;
import model.comparator.AlphabeticalCountryComparator;

import java.util.Arrays;
import java.util.InputMismatchException;

public class ToVisitListControl {
    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private FileManager fileManager;
    private ToVisitList toVisitList;

    ToVisitListControl(){
        fileManager = new FileManagerBuilder(printer, dataReader).build();
        try {
            toVisitList = fileManager.importData();
            System.out.println("Data from the file have been imported");
        } catch (DataImportException e){
            System.err.println(e.getMessage());
            System.err.println("New data base has been initialized");
            toVisitList = new ToVisitList();
        }
    }
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
                case DELETE_CITY:
                    deleteCity();
                    break;
                case DELETE_MONUMENT:
                    deleteMonument();
                    break;
                case DELETE_NATURAL_SPOT:
                    deleteNaturalSpot();
                    break;
                case PRINT_TOVISITLIST:
                    printToVisitList();
                    break;
                case ADD_USER:
                    addUser();
                    break;
                case PRINT_USERS:
                    printUsers();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    System.out.println("Sorry, there is no such an option, please try again");
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
            System.out.println("Failed to create a new position, wrong data");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Limit on your ToVisitList has been achieved, you should start travelling!");
        }

    }


    private void addMonument() {
        try {
            Monument monument = dataReader.readAndAddMonument();
            toVisitList.addMonument(monument);
        } catch (InputMismatchException e){
            System.out.println("Failed to create a new position, wrong data");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Limit on your ToVisitList has been achieved, you should start travelling!");
        }
    }

    private void addNewNaturalSpot() {
        try {
            NaturalSpot naturalSpot = dataReader.readAndAddNaturalSpot();
            toVisitList.addNaturalSpot(naturalSpot);
        } catch (InputMismatchException e){
            System.out.println("Failed to create a new position, wrong data");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Limit on your ToVisitList has been achieved, you should start travelling!");
        }
    }

    private void addUser(){
        ToVisitListUser toVisitListUser = dataReader.readAndCreateUser();
        try {
            toVisitList.addUser(toVisitListUser);
        } catch (UserAlreadyExistsException e){
            System.out.println(e.getMessage());
        }
    }
    private void printCities() {
        printer.printCitiesToVisit(toVisitList.getPlaces().values());
    }

    private void printMonuments() {
        printer.printMonumentsToVisit(toVisitList.getPlaces().values());
    }

    private void printNaturalSpots() {
        printer.printNaturalSpotsToVisit(toVisitList.getPlaces().values());
    }

    private void printToVisitList() {
        printer.printAllPlacesOnToVisitList(toVisitList.getPlaces().values());
    }

    private void printUsers(){
        printer.printUsers(toVisitList.getUsers().values());
    }


    private void deleteCity(){
        try {
            City city = dataReader.readAndAddCity();
            if (toVisitList.removePlace(city)) {
                System.out.println("City has been deleted");
            } else {
                System.out.println("There is no such a city on the list");
            }
        } catch (InputMismatchException e){
            System.err.println("Failed to create a new position");
        }
    }

    private void deleteMonument(){
        try {
            Monument monument = dataReader.readAndAddMonument();
            if (toVisitList.removePlace(monument)) {
                System.out.println("Monument has been deleted");
            } else {
                System.out.println("There is no such a monument on the list");
            }
        } catch (InputMismatchException e){
            System.err.println("Failed to create a new position");
        }
    }

    private void deleteNaturalSpot(){
        try {
            NaturalSpot naturalSpot = dataReader.readAndAddNaturalSpot();
            if (toVisitList.removePlace(naturalSpot)) {
                System.out.println("Natural has been deleted");
            } else {
                System.out.println("There is no such a natural spot on the list");
            }
        } catch (InputMismatchException e){
            System.err.println("Failed to create a new position");
        }
    }



    private void exit() {
        try {
            fileManager.exportData(toVisitList);
            System.out.println("Data were successfully imported to the file");
        } catch (DataExportException e) {
            System.err.println(e.getMessage());
        }
        dataReader.close();
        System.out.println("See you soon!");
    }

    private enum Option {

        EXIT (0,
                " - to exit the program"),
        ADD_CITY(1,
                " - to add new city to your ToVisitList"),
        ADD_MONUMENT(2,
                " - to add new monument to your ToVisitList"),
        ADD_NATURAL_SPOT (3,
                " - to add new natural spot to your ToVisitList"),
        PRINT_CITIES_ON_YOUR_TO_VISIT_LIST (4,
                " - to view cities on your ToVisitList and plan new journey :)"),
        PRINT_MONUMENTS_ON_YOUR_TO_VISIT_LIST (5,
                " - to view monuments on your ToVisitList and plan new journey :)"),
        PRINT_NATURAL_SPOTS_ON_YOUR_TO_VISIT_LIST (6,
                " - to view natural spots on your ToVisitList and plan new journey :)"),
        DELETE_CITY(7,
                " - to delete a city from your ToVisitList"),
        DELETE_MONUMENT(8,
                " - to delete a monument from your ToVisitList"),
        DELETE_NATURAL_SPOT(9,
                " - to delete a natural spot from your ToVisitList"),
        ADD_USER (10,
                " - to add new user"),
        PRINT_USERS (11,
                " - to view all users"),
        PRINT_TOVISITLIST(12,
                " - to view your ToVisitList");

        private int value;
        private String description;

        Option(int value, String description) {
            this.value = value;
            this.description = description;
        }

        @Override
        public String toString() {
            return value+description;
        }

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (InputMismatchException e){
                throw new NoSuchOptionException("There is no option: " + option);
            }
        }
    }
}