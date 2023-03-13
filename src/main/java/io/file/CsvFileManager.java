package io.file;

import exception.DataExportException;
import exception.DataImportException;
import exception.InvalidDataException;
import model.*;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class CsvFileManager implements FileManager {

    private static final String PLACES_FILE_NAME = "ToVisitList.csv";
    private static final String USERS_FILE_NAME = "ToVisitList_Users.csv";

    @Override
    public void exportData(ToVisitList toVisitList) {
        exportPlaces(toVisitList);
        exportUsers(toVisitList);
    }

    private void exportUsers(ToVisitList toVisitList) {
        Collection<ToVisitListUser> users = toVisitList.getUsers().values();
        exportToCsv(users, USERS_FILE_NAME);

    }

    private void exportPlaces(ToVisitList toVisitList) {
        Collection<Place> places = toVisitList.getPlaces().values();
        exportToCsv(places, PLACES_FILE_NAME);
    }
    private <T extends CsvConvertible> void exportToCsv(Collection<T> collection, String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (T element : collection) {
                bufferedWriter.write(element.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Error writing data to the file" + fileName);
        }
    }

    @Override
    public ToVisitList importData() {
        ToVisitList toVisitList = new ToVisitList();
        importPlaces(toVisitList);
        importUsers(toVisitList);
        return toVisitList;
    }

    private void importPlaces(ToVisitList toVisitList){
        try (Scanner fileReader = new Scanner(new File(PLACES_FILE_NAME))){
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                Place place = createPlaceFromString(line);
                toVisitList.addPlace(place);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("File " + PLACES_FILE_NAME + " wasn't found ");
        }
    }

    private void importUsers(ToVisitList toVisitList){
        try (Scanner fileReader = new Scanner(new File(USERS_FILE_NAME))){
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                ToVisitListUser toVisitListUser = createUserFromString(line);
                toVisitList.addUser(toVisitListUser);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("File " + USERS_FILE_NAME + " wasn't found ");
        }
    }
    private Place createPlaceFromString(String csvText) {
        String[] split = csvText.split(";");
        String type = split[0];
        if(City.TYPE.equals(type)){
            return createCity(split);
        } else if (Monument.TYPE.equals(type)) {
            return createMonument(split);
        } else if (NaturalSpot.TYPE.equals(type)){
            return createNaturalSpot(split);
        }
        throw new InvalidDataException("Unknown Type of place " + type);
    }

    private NaturalSpot createNaturalSpot(String[] data) {
        String title = data[1];
        String country = data[2];
        boolean unescoList = toBoolean(data[3]);
        boolean naturalWonderOfTheWorld = toBoolean(data[4]);
        return new NaturalSpot(title,country,unescoList,naturalWonderOfTheWorld);
    }

    private Monument createMonument(String[] data) {
        String title = data[1];
        String country = data[2];
        boolean unescoList = toBoolean(data[3]);
        boolean wonderOfTheWorld = toBoolean(data[4]);
        return new Monument(title,country,unescoList,wonderOfTheWorld);
    }

    private City createCity(String[] data) {
        String title = data[1];
        String city = data[2];
        String country = data[3];
        boolean capital = toBoolean(data[4]);
        return new City(title,city,country,capital);
    }

    private ToVisitListUser createUserFromString(String csvText){
        String [] split = csvText.split(";");
        String firstName = split[0];
        String lastName = split[1];
        String email = split[2];
        return new ToVisitListUser(firstName,lastName,email);
    }

    private boolean toBoolean(String data) {
        boolean dataToBoolean = false;
        if(data.equals("true")){
            dataToBoolean = true;
        } else if (data.equals("false")) {
            dataToBoolean = false;
        }
        return dataToBoolean;
    }


}
