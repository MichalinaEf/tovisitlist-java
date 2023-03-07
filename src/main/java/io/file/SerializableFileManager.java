package io.file;

import exception.DataExportException;
import exception.DataImportException;
import model.ToVisitList;

import java.io.*;

public class SerializableFileManager implements FileManager{
    private static final String FILE_NAME = "ToVisitList.o";


    @Override
    public void exportData(ToVisitList toVisitList) {
        try (FileOutputStream fos = new FileOutputStream(FILE_NAME);
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(toVisitList);
        } catch (FileNotFoundException e) {
            throw new DataExportException("File " + FILE_NAME + " wasn't found ");
        } catch (IOException e) {
            throw new DataExportException("Error writing data to the file " + FILE_NAME);
        }
    }
    @Override
    public ToVisitList importData() {
        try (FileInputStream fis = new FileInputStream(FILE_NAME);
             ObjectInputStream ois = new ObjectInputStream(fis)
        ){
            return (ToVisitList) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new DataImportException("There is no file as " + FILE_NAME);
        } catch (IOException e) {
            throw new DataImportException("Error reading data of the file " + FILE_NAME);
        } catch (ClassNotFoundException e) {
            throw new DataImportException("Wrong file format of " + FILE_NAME);
        }
    }


}
