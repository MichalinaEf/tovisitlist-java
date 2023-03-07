package app;

import exception.DataExportException;
import exception.DataImportException;
import exception.NoSuchOptionException;
import io.ConsolePrinter;
import io.DataReader;
import io.file.FileManager;
import io.file.FileManagerBuilder;
import model.*;

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
            System.out.println("Data from the file were imported");
        } catch (DataImportException e){
            System.err.println(e.getMessage());
            System.err.println("New data base were initialized");
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

        EXIT (0, " - to exit the program"),
        ADD_CITY(1," - to add new city to your ToVisitList"),
        ADD_MONUMENT(2," - to add new monument to your ToVisitList"),
        ADD_NATURAL_SPOT (3, " - to add new natural spot to your ToVisitList"),
        PRINT_CITIES_ON_YOUR_TO_VISIT_LIST (4, " - to see cities on your ToVisitList and plan new journey :)"),
        PRINT_MONUMENTS_ON_YOUR_TO_VISIT_LIST (5, " - to see monuments on your ToVisitList and plan new journey :)"),
        PRINT_NATURAL_SPOTS_ON_YOUR_TO_VISIT_LIST (6, " - to see natural spots on your ToVisitList and plan new journey :)"),
        PRINT_TOVISITLIST(7, " - to see your ToVisitList");

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