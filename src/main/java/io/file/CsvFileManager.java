package io.file;

import exception.DataExportException;
import exception.DataImportException;
import exception.InvalidDataException;
import model.*;

import java.io.*;
import java.util.Scanner;

public class CsvFileManager implements FileManager {

    private static final String FILE_NAME = "ToVisitList.csv";

    @Override
    public void exportData(ToVisitList toVisitList) {
        Place[] places = toVisitList.getPlaces();

        try (FileWriter fileWriter = new FileWriter(FILE_NAME);
             BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
            for (Place place :places) {
                bufferedWriter.write(place.toCsv());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            throw new DataExportException("Error writing data to the file" + FILE_NAME);
        }

    }

    @Override
    public ToVisitList importData() {
        ToVisitList toVisitList = new ToVisitList();
        try (Scanner fileReader = new Scanner(new File(FILE_NAME))){
            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                Place place = createPlaceFromString(line);
                toVisitList.addPlace(place);
            }
        } catch (FileNotFoundException e) {
            throw new DataImportException("File " + FILE_NAME + " wasn't found ");
        }
        return toVisitList;
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
        throw new InvalidDataException("Unown Type of place " + type);
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
